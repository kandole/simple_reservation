package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.format.Formats._
import models._

import com.mongodb.casbah.Imports._
import org.bson.types.ObjectId
import scala.collection.mutable.ListBuffer
import org.joda.time._
// import play.api.cache.Cache
// import play.api.Play.current

object Admin extends Controller with Secured {

  private def mergeUserData(dbOrderList: List[Order]): List[OrderReal] = {
    //产生OrderReal，既合并相同用户的订单
    //存储相同行的index
    var indexList = List[Int]()
    val lbuf = new ListBuffer[OrderReal]
    for (o <- dbOrderList) {
      val oIndex = dbOrderList.indexOf(o)
      if (!indexList.contains(oIndex)) {
        val user: User = User.findOne(MongoDBObject("_id" -> new ObjectId(o.user))).get
        val r: Restaurant = Restaurant.findOne(MongoDBObject("_id" -> new ObjectId(o.restaurant))).getOrElse(
            Restaurant(new ObjectId(o.restaurant), "已删除", false, "", "", "")
          )
        val food: Food = Food.findOne(MongoDBObject("_id" -> new ObjectId(o.food))).getOrElse(
            Food(new ObjectId(o.food), "已删除", 0.0, o.restaurant)
          )

        // val orderR = new OrderReal(user, r, List(food))
        val flbuf = new ListBuffer[(Food, Int)]
        val t = (food, o.number)
        flbuf += t

        //将自身加入indexList
        indexList = oIndex :: indexList
        for (co <- dbOrderList) {
          // println("Admin co delete : co.user - " + co.user + " co.restaurant - " + co.restaurant)
          val coIndex = dbOrderList.indexOf(co)
          if (!indexList.contains(coIndex)) {
            if (co.user == o.user && co.restaurant == o.restaurant) {
              // println("Admin co delete")
              val cFood: Food = Food.findOne(MongoDBObject("_id" -> new ObjectId(co.food))).get
              val t = (cFood, co.number)
              flbuf += t

              //将co加入到indexList
              indexList = coIndex :: indexList
            }
          }
        }
        val fl = flbuf.toList
        val orderR = new OrderReal(user, r, fl)
        lbuf += orderR
      }
    }
    lbuf.toList 
  }

  private def mergeFoodData(dbOrderList: List[Order]): List[FoodOrder] = {
    //产生OrderReal，既将同一种食物的订单合并
    //存储相同行的index
    var indexList = List[Int]()
    val lbuf = new ListBuffer[FoodOrder]
    for (o <- dbOrderList) {
      val oIndex = dbOrderList.indexOf(o)
      if (!indexList.contains(oIndex)) {
        val food: Food = Food.findOne(MongoDBObject("_id" -> new ObjectId(o.food))).getOrElse(
            Food(new ObjectId(o.food), "已删除", 0.0, o.restaurant)
          )
        var num = o.number
        //将自身加入indexList
        indexList = oIndex :: indexList
        for (co <- dbOrderList) {
          // println("Admin co delete : co.user - " + co.user + " co.restaurant - " + co.restaurant)
          val coIndex = dbOrderList.indexOf(co)
          if (!indexList.contains(coIndex)) {
            if (co.food == o.food) {
              // println("Admin co delete")
              num = num + co.number
              //将co加入到indexList
              indexList = coIndex :: indexList
            }
          }
        }
        // Logger.info("mergeFoodData: " + "name: " + food.name + ",num: " + num + ",price: " + food.price)
        val fo = FoodOrder(food.name, num, food.price)
        lbuf += fo
      }
    }
    lbuf.toList 
  }


  //订单一览
	def index = adminIsAuthed { adminLoginId => implicit request =>
    //同一时刻，只有一个订单开启
    val oc = OrderControl.findOne(MongoDBObject("_id" -> "oc001")).get
    // if (oc.status == "open") {
    if (oc.date == LocalDate.now().toString) {
      // val dbOrderList: List[Order] = Order.find(MongoDBObject("date" -> LocalDate.now().toString, "status" -> "open")).toList
      val dbOrderList: List[Order] = Order.find(MongoDBObject("date" -> LocalDate.now().toString)).toList
      val orList = mergeUserData(dbOrderList)
      val ofList = mergeFoodData(dbOrderList)
      //指定的饭店
      val restaurant = Restaurant.findOne(MongoDBObject("isSeted" -> true)).get
    	Ok(views.html.admin.index("Admin Home")(restaurant)(orList)(ofList)(oc))
    } else {
      Ok(views.html.admin.orderOff("Admin Home"))
    }
  }

  // def index2 = adminIsAuthed { adminLoginId => implicit request =>
  //   var dbOrderList: List[Order] = Order.find(MongoDBObject("date" -> LocalDate.now().toString)).toList

  // }
  //订饭开启与关闭
  def orderOpenControl(status: String, endTime: String) = adminIsAuthed { adminLoginId => implicit request =>
    val rOption = Restaurant.findOne(MongoDBObject("isSeted" -> true))
    rOption match {
      case Some(restaurant) => {
        //如果订单是关闭的，那么应该创建一个新订单，既开启订单，其isOpen为true
        if (status == "finished" || status == "cancled" || status == "closed") {
          val o = MongoDBObject("_id" -> "oc001")
          val q = MongoDBObject("$set" -> MongoDBObject("rId" -> restaurant.id.toString,"status" -> "open", "endTime" -> endTime, "date" -> LocalDate.now().toString))
          OrderControl.update(o, q, false, false, OrderControl.dao.collection.writeConcern)
          Logger.info("Start order." + DateTime.now())
        } else {
          //在取消订单前，提示是否先划账
          val o = MongoDBObject("_id" -> "oc001")
          val q = MongoDBObject("$set" -> MongoDBObject("status" -> "cancled"))
          OrderControl.update(o, q, false, false, OrderControl.dao.collection.writeConcern)
          //将Order中所有该饭店open的订单的status改为cancled
          val oo = MongoDBObject("restaurant" -> restaurant.id.toString, "date" -> LocalDate.now().toString, "status" -> "open")
          val oq = MongoDBObject("$set" -> MongoDBObject("status" -> "cancled"))
          Order.update(oo, oq, false, false, Order.dao.collection.writeConcern)
          Logger.info("Cancle order." + DateTime.now())
        }
        Redirect(routes.Admin.RFmanager)
      }
      case None => {
        Redirect(routes.Admin.RFmanager).flashing(
          "noRestaurantSeted" -> "请先指定饭店"
        )
      }
    }
  }


  def userManager = adminIsAuthed { adminLoginId => implicit request =>
      val uList = User.find(MongoDBObject("authority" -> "普通用户")).toList
      Ok(views.html.admin.userManager("用户管理")(uList))
  }

  def saveUser = adminIsAuthed { adminLoginId => implicit request =>
      Ok(views.html.admin.saveUser("添加用户")(userForm()))
  }

  def saveU = adminIsAuthed { adminLoginId => implicit request =>
    userForm().bindFromRequest.fold(
      errorsForm => BadRequest(views.html.admin.saveUser("Error Input!-添加用户")(errorsForm)), 
      user => {
        User.save(user)
        Redirect(routes.Admin.userManager).flashing(
          "userAdded" -> "新用户添加成功"
        )
      }
    )    
  }

  def RFmanager = adminIsAuthed { adminLoginId => implicit request =>
      val oc = OrderControl.findOne(MongoDBObject("_id" -> "oc001")).get
      val rList = Restaurant.findAll().toList

      Ok(views.html.admin.RFmanager("饭店菜品管理")(rList)(oc))
  }

  def userForm(id: ObjectId = new ObjectId): Form[User] = Form(
  	mapping(
  		"id" -> ignored(id),
  		"login_id" -> nonEmptyText,
  		"passwd" -> nonEmptyText,
  		"name" -> nonEmptyText,
  		"authority" -> nonEmptyText,
      "balance" -> of[Double]
  	) (User.apply) (User.unapply)
  )

  val uuserForm: Form[UUser] = Form(
    mapping(
      "id" -> text,
      "login_id" -> nonEmptyText,
      "name" -> nonEmptyText,
      "authority" -> nonEmptyText
    ) (UUser.apply) (UUser.unapply)
  )

  val rechargeForm = Form(
    tuple(
      "uId" -> text,
      "reMoney" -> of[Double]
    )
  )

  // def orderControlForm(): Form[OrderControl] = Form(
  //   mapping(
  //     "id" -> ignored("oc001"),
  //     "rId" -> text,
  //     "orderIsOpen" -> of[Boolean]
  //   ) (OrderControl.apply)(OrderControl.unapply)
  // )

  def restaurantForm(id: ObjectId = new ObjectId): Form[Restaurant] = Form{
    mapping(
      "id" -> ignored(id),
      "name" -> nonEmptyText,
      "isSeted" -> of[Boolean],
      "phone1" -> text,
      "phone2" -> text,
      "others" -> text
      // "pic" -> ignored("noPic")
    ) (Restaurant.apply) (Restaurant.unapply)
  }

  val uRestaurantForm: Form[URestaurant] = Form{
    mapping(
      "id" -> text,
      "name" -> nonEmptyText,
      "phone1" -> text,
      "phone2" -> text,
      "others" -> text
      // "pic" -> ignored("noPic")
    ) (URestaurant.apply) (URestaurant.unapply)
  }

  def foodForm(id: ObjectId = new ObjectId): Form[Food] = Form{
    mapping(
      "id" -> ignored(id),
      "name" -> nonEmptyText,
      "price" -> of[Double],
      "restaurant" -> nonEmptyText
    ) (Food.apply) (Food.unapply)
  }

  val finishOrderForm: Form[OrderFinish] = Form(
    mapping(
      "uIds" -> list(text),
      "pays" -> list(text)
    ) (OrderFinish.apply)(OrderFinish.unapply)
  )

  def saveRestaurant = adminIsAuthed { adminLoginId => implicit request =>
      Ok(views.html.admin.saveRestaurant("添加饭店")(restaurantForm()))
  }

  def saveR = adminIsAuthed { adminLoginId => implicit request =>
    restaurantForm().bindFromRequest.fold(
      errorsForm => BadRequest(views.html.admin.saveRestaurant("Error Input!-添加饭店")(errorsForm)), 
      restaurant => {
        // request.body.moteTo(new File("/public/images"))
        Restaurant.save(restaurant)
        val rId = restaurant.id.toString
        Ok(views.html.admin.rSaveSuccess("添加饭店成功")(rId))
     }
    )
  }

  def saveFood(rId: String) = adminIsAuthed { adminLoginId => implicit request =>
    Ok(views.html.admin.saveFood("添加菜品")(foodForm())(rId))
  }

  def saveF = adminIsAuthed { adminLoginId => implicit request =>
    //从Post过来的表单中获取rId
    val rMap = request.body.asFormUrlEncoded.get.asInstanceOf[Map[String,Seq[String]]]
    val rId = rMap("restaurant")(0)
    // println("saveF rId: " + rId)
    foodForm().bindFromRequest.fold(
      errorsForm => {
        BadRequest(views.html.admin.saveFood("Error Input!-添加菜品")(errorsForm)(rId))
      }, 
      food => {
        // val fl = List(List(food.id.toString, food.name, food.price.toString))
        // println("saveF Food: " + food.id.toString + " " + food.name + " " + food.price.toString + " " + food.restaurant)
        // Food.save(food)
        // val q = MongoDBObject("_id" -> new ObjectId(food.restaurant))
        // val rfList = Restaurant.findOne(q).get.food.toList
        // println("saveF rfList: " + rfList.toString)
        // val nfl = rfList :: fl
        // val o = MongoDBObject("$set" -> MongoDBObject("food" -> nfl))
        // Restaurant.update(q, o, false, false, Restaurant.dao.collection.writeConcern)
        // Redirect(routes.Admin.saveFood(rId)).flashing(
        //   "food" -> "菜品添加成功"
        // )

        Food.save(food)
        Redirect(routes.Admin.saveFood(rId)).flashing(
          "food" -> "菜品添加成功,是否继续？"
        )
      }
    )
  }

  def updateFood(fId: String, rId: String) = adminIsAuthed { adminLoginId => implicit request =>
    val fIdO = new ObjectId(fId)
    val food = Food.findOne(MongoDBObject("_id" -> fIdO)).get
    val filledFForm = foodForm(fIdO).fill(food)
    Ok(views.html.admin.updateFood("修改菜品信息")(filledFForm)(fId)(rId))
  }

  def updateF = adminIsAuthed { adminLoginId => implicit request =>
    //从Post过来的表单中获取rId
    val fMap = request.body.asFormUrlEncoded.get.asInstanceOf[Map[String,Seq[String]]]
    val fId = fMap("id")(0)
    val rId = fMap("restaurant")(0)
    foodForm(new ObjectId(fId)).bindFromRequest.fold(
      errorsForm => {
        BadRequest(views.html.admin.updateFood("输入错误!-修改菜品信息")(errorsForm)(fId)(rId))
      }, 
      food => {
        val o = MongoDBObject("_id" -> food.id)
        val q = MongoDBObject("$set" -> MongoDBObject("name" -> food.name, "price" -> food.price))
        Food.update(o, q, false, false, Food.dao.collection.writeConcern)
        Redirect(routes.Admin.showFood(rId)).flashing(
          "updateFoodSuccess" -> "菜品修改成功"
        )
     }
    )
  }

  def deleteF(fId: String, rId: String) = adminIsAuthed { adminLoginId => implicit request =>
    Food.remove(MongoDBObject("_id" -> new ObjectId(fId)))
    Redirect(routes.Admin.showFood(rId))
  }

  def showFood(rId: String) = adminIsAuthed { adminLoginId => implicit request =>
    val r = Restaurant.findOne(MongoDBObject("_id" -> new ObjectId(rId))).get
    val rList: List[Food] = Food.find(MongoDBObject("restaurant" -> rId)).toList
    Ok(views.html.admin.showFood("菜品列表")(r)(rList))
  }

  def justShowFood(rId: String) = adminIsAuthed { adminLoginId => implicit request =>
    val r = Restaurant.findOne(MongoDBObject("_id" -> new ObjectId(rId))).get
    val rList: List[Food] = Food.find(MongoDBObject("restaurant" -> rId)).toList
    Ok(views.html.admin.justShowFood("菜品列表")(r)(rList))
  }

  def setR(rId: String) = adminIsAuthed { adminLoginId => implicit request =>
    //将原先指定的饭店消除
    val oo = MongoDBObject("isSeted" -> true)
    val oq = MongoDBObject("$set" -> MongoDBObject("isSeted" -> false))
    Restaurant.update(oo, oq, false, false, Restaurant.dao.collection.writeConcern)
    //指定饭店
    val o = MongoDBObject("_id" -> new ObjectId(rId))
    val q = MongoDBObject("$set" -> MongoDBObject("isSeted" -> true))
    Restaurant.update(o, q, false, false, Restaurant.dao.collection.writeConcern)
    Redirect(routes.Admin.RFmanager)
  } 

  def finishOrder = adminIsAuthed { adminLoginId => implicit request =>
    finishOrderForm.bindFromRequest.fold(
      errorsForm => {
        // Logger.info("in Admin finishOrder. Error.")
        Redirect(routes.Admin.index)
      }, 
      finishOrder => {
        Logger.info("Finish order." + DateTime.now())
        //划账，修改账户余额
        for (i <- 0 to (finishOrder.uIds.size - 1)) {
          val uId = finishOrder.uIds(i)
          val pay = finishOrder.pays(i).toDouble
          val balance: Double = User.findOne(MongoDBObject("_id" -> new ObjectId(uId))).get.balance
          val rePay = 0.0 - pay
          val o = MongoDBObject("_id" -> new ObjectId(uId))
          val q = MongoDBObject("$inc" -> MongoDBObject("balance" -> rePay))
          User.update(o, q, false, false, User.dao.collection.writeConcern)

          //将Order中所有该饭店open的订单的status改为finished
          val rId = OrderControl.findOne(MongoDBObject("_id" -> "oc001")).get.rId
          val oo = MongoDBObject("restaurant" -> rId, "date" -> LocalDate.now().toString, "status" -> "open")
          val oq = MongoDBObject("$set" -> MongoDBObject("status" -> "finished"))
          Order.update(oo, oq, false, true, Order.dao.collection.writeConcern)
        }
        //关闭订单
        val o = MongoDBObject("_id" -> "oc001")
        val q = MongoDBObject("$set" -> MongoDBObject("status" -> "finished"))
        OrderControl.update(o, q, false, false, OrderControl.dao.collection.writeConcern)
        Redirect(routes.Admin.index).flashing(
          "finishOrderSuccess" -> "划账成功，订单关闭"
        )
     }
    )
  }

  def deleteR(rId: String) = adminIsAuthed { adminLoginId => implicit request =>
    Restaurant.remove(MongoDBObject("_id" -> new ObjectId(rId)))
    //删除该饭店的所有菜品
    Food.remove(MongoDBObject("restaurant" -> rId))
    Redirect(routes.Admin.RFmanager)
  }

  def userUpdate(uId: String) = adminIsAuthed { adminLoginId => implicit request =>
    val uIdO = new ObjectId(uId)
    val user = User.findOne(MongoDBObject("_id" -> uIdO)).get
    val uuser = UUser(user.id.toString, user.login_id, user.name, user.authority)
    // Logger.info("Admin userUpdate: " + "_id: " + user.id.toString)
    val filledUForm = uuserForm.fill(uuser)
    // Logger.info("Admin userUpdate: " + "uIdO: " + uIdO.toString)
    Ok(views.html.admin.updateUser("修改用户信息")(filledUForm)(uId))
  }

  def updateU = adminIsAuthed { adminLoginId => implicit request =>
    uuserForm.bindFromRequest.fold(
      errorsForm => {
        val uId = errorsForm.data("id")
        BadRequest(views.html.admin.updateUser("输入错误!-修改用户信息")(errorsForm)(uId))
      }, 
      uuser => {
        // Logger.info("Admin updateU: " + "_id: " + uuser.id)
        val o = MongoDBObject("_id" -> new ObjectId(uuser.id))
        val q = MongoDBObject("$set" -> MongoDBObject("login_id" -> uuser.login_id, "name" -> uuser.name, "authority" -> uuser.authority))
        User.update(o, q, false, false, User.dao.collection.writeConcern)
        Redirect(routes.Admin.userManager).flashing(
          "updateUserSuccess" -> "用户修改成功"
        )
     }
    )
  }

  def userDelete(uId: String) = adminIsAuthed { adminLoginId => implicit request =>
    User.remove(MongoDBObject("_id" -> new ObjectId(uId)))
    Redirect(routes.Admin.userManager)
  }

  def recharge(uId: String) = adminIsAuthed { adminLoginId => implicit request =>
    val user = User.findOne(MongoDBObject("_id" -> new ObjectId(uId))).get
    Ok(views.html.admin.recharge("充值")(user))
  }
  //充值
  def rech = adminIsAuthed { adminLoginId => implicit request =>
    rechargeForm.bindFromRequest.fold(
      errorsForm => {

        val user = User.findOne(MongoDBObject("_id" -> new ObjectId(errorsForm.get._1))).get
        BadRequest(views.html.admin.recharge("输入错误!-充值")(user))
      }, 
      recharge => {
        val o = MongoDBObject("_id" -> new ObjectId(recharge._1))
        val q = MongoDBObject("$inc" -> MongoDBObject("balance" -> recharge._2))
        User.update(o, q, false, false, User.dao.collection.writeConcern)
        Redirect(routes.Admin.userManager).flashing(
          "rechargeSuccess" -> "充值成功"
        )
     }
    )
  }

  def updateRestaurant(rId: String) = adminIsAuthed { adminLoginId => implicit request =>
    val rIdO = new ObjectId(rId)
    val r = Restaurant.findOne(MongoDBObject("_id" -> rIdO)).get
    val ur = URestaurant(r.id.toString, r.name, r.phone1, r.phone2, r.others)
    val filledRForm = uRestaurantForm.fill(ur)
    Ok(views.html.admin.updateRestaurant("修改饭店信息")(filledRForm)(rId))
  }
// def updateRestaurant(rId: String) = TODO
  def updateR = adminIsAuthed { adminLoginId => implicit request =>
    uRestaurantForm.bindFromRequest.fold(
      errorsForm => {
        // Logger.info("updateR in error:" + errorsForm)
        val rId = errorsForm.data("id")
        BadRequest(views.html.admin.updateRestaurant("输入错误!-修改饭店信息")(errorsForm)(rId))}, 
      r => {
        // Logger.info("updateR in update: " + "_id: " + r.id)
        // request.body.moteTo(new File("/public/images"))
        val o = MongoDBObject("_id" -> new ObjectId(r.id))
        val q = MongoDBObject("$set" -> MongoDBObject("name" -> r.name, "phone1" -> r.phone1, "phone2" -> r.phone2, "others" -> r.others))
        Restaurant.update(o, q, false, false, Restaurant.dao.collection.writeConcern)
        Redirect(routes.Admin.RFmanager).flashing(
          "updateRestaurantSuccess" -> "饭店修改成功"
        )
     }
    )
  }

  def orderRecords = adminIsAuthed { adminLoginId => implicit request =>
    val dateList = Order.collection.distinct("date").toList.reverse
    // orderList.map(o => println(o))
    val dList = dateList.map(d => d.toString)

    Ok(views.html.admin.orderRecords("订单记录")(dList))
  }

  def showRecord(d: String) = adminIsAuthed { adminLoginId => implicit request =>
    val dbOrderList: List[Order] = Order.find(MongoDBObject("date" -> d)).toList
    val orList = mergeUserData(dbOrderList)
    val ofList = mergeFoodData(dbOrderList)
    val restaurant = orList(0).restaurant
    Ok(views.html.admin.showRecord("订单详情")(restaurant)(orList)(ofList)(d))
  }

}