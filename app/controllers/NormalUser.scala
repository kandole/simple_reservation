package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models._
import scala.collection.mutable.ListBuffer

import com.mongodb.casbah.Imports._
import org.bson.types.ObjectId
import org.joda.time._
// import play.api.cache.Cache
// import play.api.Play.current

object NormalUser extends Controller with Secured {

	def index() = isAuthed { loginId => implicit request =>
		//pwMark 修改密码是否出错，false为正常，true为出错

		//同一时刻，只有一个订单开启
    	val oc = OrderControl.findOne(MongoDBObject("_id" -> "oc001")).get
		val login_id = request.session.get("login_id")
		//当前登录的用户
		val user: User = User.findOne(MongoDBObject("login_id" -> login_id, "authority" -> "普通用户")).get
		if (oc.status == "open") {
			//选定的饭店
			val restaurant: Restaurant = Restaurant.findOne(MongoDBObject("_id"-> new ObjectId(oc.rId))).get
			//选定饭店的菜品
			val fList: List[Food] = Food.find(MongoDBObject("restaurant" -> restaurant.id.toString)).toList
			//根据当前的日期获取订单情况
			val now = LocalDate.now().toString
			val orderList: List[Order] = Order.find(MongoDBObject("user" -> user.id.toString, "restaurant" -> restaurant.id.toString, "date" -> now, "status" -> "open")).toList
			// val oIdList: List[String] = for (o <- orderList) yield {
			// 	o.id.toString
			// }
			//Order _id
			var endTime = oc.endTime
			
	    	Ok(views.html.normalUser.index("User Home")(user)(restaurant)(fList)(orderList)(endTime))
    	} else {
    		Ok(views.html.normalUser.noOrder("User Home")(user))
    	}
	}

	def updatePasswd = isAuthed { loginId => implicit request =>
		val login_id = request.session.get("login_id")
		//当前登录的用户
		val user: User = User.findOne(MongoDBObject("login_id" -> login_id, "authority" -> "普通用户")).get
		Ok(views.html.normalUser.updatePW("修改密码")(user)(passwdUForm))
	} 

	def orderF = isAuthed { loginId => implicit request =>
		val oc = OrderControl.findOne(MongoDBObject("_id" -> "oc001")).get
		//判断提交时订单是否关闭
		if (oc.status == "open") {
			orderForm().bindFromRequest.fold(
		      errorsForm => Redirect(routes.NormalUser.index()), 
		      order => {
		        Order.save(order)
		        Redirect(routes.NormalUser.index())
		      }
		    )
		} else {
			Redirect(routes.NormalUser.index()).flashing(
				"noOrderOpen" -> "对不起，订单已关闭，订餐失败。"
			)
		}
	}

	val passwdUForm = Form{
		tuple(
			"uId" -> nonEmptyText,
			"old_passwd" -> nonEmptyText,
			"new_passwd" -> tuple(
				"main" -> nonEmptyText,
				"confirm" -> nonEmptyText
			).verifying(
				"两次输入的新密码不相同", passwords => passwords._1 == passwords._2
			)
		) verifying("原密码错误", fields => fields match {
			case (uId, op, (_, _)) => User.checkPasswd(uId, op).isDefined
		})
	}

	def updatePW = isAuthed { loginId => implicit request =>
		passwdUForm.bindFromRequest.fold(
	      errorsForm => {
			val login_id = request.session.get("login_id")
			// 当前登录的用户
			val user: User = User.findOne(MongoDBObject("login_id" -> login_id, "authority" -> "普通用户")).get
	  		BadRequest(views.html.normalUser.updatePW("修改密码出错")(user)(errorsForm))
	  		// Cache.set("updatePWErrorsForm", errorsForm)
	  		// Redirect(routes.NormalUser.index()).flashing(
	    //       "updatePWError" -> "密码修改出错"
	    //     )
	  		},
	      passwdU => {
	        val o = MongoDBObject("_id" -> new ObjectId(passwdU._1))
	        val q = MongoDBObject("$set" -> MongoDBObject("passwd" -> passwdU._3._1))
	        User.update(o, q, false, false, User.dao.collection.writeConcern)
	        Redirect(routes.NormalUser.index()).flashing(
	          "updatePWSuccess" -> "密码修改成功"
	        )
	      }
	    )
	}

	// def upError = isAuthed { loginId => implicit request =>
	// 	val errorsForm = Cache.getAs[Form[(String, String, (String, String))]]("updatePWErrorsForm").get
	// 	val login_id = request.session.get("login_id")
	// 	// 当前登录的用户
	// 	val user: User = User.findOne(MongoDBObject("login_id" -> login_id, "authority" -> "普通用户")).get

	//   	BadRequest(views.html.normalUser.updatePW(user)(errorsForm))
	// }

	def orderForm(id: ObjectId = new ObjectId): Form[Order] = Form{
	    mapping(
	      "id" -> ignored(id),
	      "uId" -> text,
	      "rId" -> text,
	      "fId" -> text,
	      "date" -> ignored(LocalDate.now().toString),
	      "number" -> number,
	      "status" -> text
	    ) (Order.apply) (Order.unapply)
	}
	//取消订单
	def cancleO(oId: String) = isAuthed { loginId => implicit request =>
		Order.remove(MongoDBObject("_id" -> new ObjectId(oId)))
		Redirect(routes.NormalUser.index())
	}

	//查看订餐历史
	def showUserHistory = isAuthed { loginId => implicit request =>
		val login_id = request.session.get("login_id")
		// 当前登录的用户
		val user: User = User.findOne(MongoDBObject("login_id" -> login_id, "authority" -> "普通用户")).get
		val oList = Order.find(MongoDBObject("user" -> user.id.toString)).toList
		val lbuf = new ListBuffer[OrderHistory]
		for (o <- oList) {
	        val r: Restaurant = Restaurant.findOne(MongoDBObject("_id" -> new ObjectId(o.restaurant))).getOrElse(
	        		Restaurant(new ObjectId(o.restaurant), "已删除", false, "", "", "")
	        	)
	        val food: Food = Food.findOne(MongoDBObject("_id" -> new ObjectId(o.food))).getOrElse(
	        		Food(new ObjectId(o.food), "已删除", 0.0, o.restaurant)
	        	)

	  		val oHistory = OrderHistory(o.id.toString, food, r, o.number, o.status, o.date)
	  		lbuf += oHistory
		}
		val history = lbuf.toList.reverse
		Ok(views.html.normalUser.showHistory("订餐历史")(user)(history))
	}
}