// @SOURCE:/opt/dacOrder.git/conf/routes
// @HASH:1ff78e2fdc7aa82e72b58bfa00148c68dee87883
// @DATE:Fri Jul 19 08:13:23 CST 2013


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import se.radley.plugin.salat.Binders._

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix  
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" } 


// @LINE:6
private[this] lazy val controllers_Application_login0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:8
private[this] lazy val controllers_Application_authenticate1 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:9
private[this] lazy val controllers_Application_logout2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
        

// @LINE:12
private[this] lazy val controllers_Admin_index3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin"))))
        

// @LINE:14
private[this] lazy val controllers_Admin_RFmanager4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("RFmanager"))))
        

// @LINE:15
private[this] lazy val controllers_Admin_saveRestaurant5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("saveRestaurant"))))
        

// @LINE:16
private[this] lazy val controllers_Admin_saveR6 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("saveRestaurant"))))
        

// @LINE:17
private[this] lazy val controllers_Admin_saveFood7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("saveFood"))))
        

// @LINE:18
private[this] lazy val controllers_Admin_saveF8 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("saveFood"))))
        

// @LINE:19
private[this] lazy val controllers_Admin_showFood9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("showFood"))))
        

// @LINE:20
private[this] lazy val controllers_Admin_justShowFood10 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("justShowFood"))))
        

// @LINE:21
private[this] lazy val controllers_Admin_updateFood11 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("updateFood"))))
        

// @LINE:22
private[this] lazy val controllers_Admin_updateF12 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("updateFood"))))
        

// @LINE:23
private[this] lazy val controllers_Admin_deleteF13 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deleteFood"))))
        

// @LINE:24
private[this] lazy val controllers_Admin_deleteR14 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deleteRestaurant"))))
        

// @LINE:25
private[this] lazy val controllers_Admin_updateRestaurant15 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("updateRestaurant"))))
        

// @LINE:26
private[this] lazy val controllers_Admin_updateR16 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("updateRestaurant"))))
        

// @LINE:27
private[this] lazy val controllers_Admin_setR17 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("setRestaurant"))))
        

// @LINE:28
private[this] lazy val controllers_Admin_saveUser18 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("saveUser"))))
        

// @LINE:29
private[this] lazy val controllers_Admin_saveU19 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("saveUser"))))
        

// @LINE:30
private[this] lazy val controllers_Admin_userManager20 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("userManager"))))
        

// @LINE:31
private[this] lazy val controllers_Admin_finishOrder21 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("finishOrder"))))
        

// @LINE:32
private[this] lazy val controllers_Admin_orderOpenControl22 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("orderOpenControl"))))
        

// @LINE:33
private[this] lazy val controllers_Admin_userUpdate23 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("userUpdate"))))
        

// @LINE:34
private[this] lazy val controllers_Admin_updateU24 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("userUpdate"))))
        

// @LINE:35
private[this] lazy val controllers_Admin_userDelete25 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("userDelete"))))
        

// @LINE:36
private[this] lazy val controllers_Admin_recharge26 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("recharge"))))
        

// @LINE:37
private[this] lazy val controllers_Admin_rech27 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("recharge"))))
        

// @LINE:38
private[this] lazy val controllers_Admin_orderRecords28 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("orderRecords"))))
        

// @LINE:39
private[this] lazy val controllers_Admin_showRecord29 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("showRecord"))))
        

// @LINE:42
private[this] lazy val controllers_NormalUser_index30 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("normalUser"))))
        

// @LINE:43
private[this] lazy val controllers_NormalUser_orderF31 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("orderFood"))))
        

// @LINE:44
private[this] lazy val controllers_NormalUser_cancleO32 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cancleOrder"))))
        

// @LINE:45
private[this] lazy val controllers_NormalUser_updatePW33 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("nuUpdatePasswd"))))
        

// @LINE:46
private[this] lazy val controllers_NormalUser_updatePasswd34 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("nuUpdatePasswd"))))
        

// @LINE:48
private[this] lazy val controllers_NormalUser_showUserHistory35 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("showUserHistory"))))
        

// @LINE:51
private[this] lazy val controllers_Assets_at36 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.login"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.authenticate"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Application.logout"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin""","""controllers.Admin.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """RFmanager""","""controllers.Admin.RFmanager"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """saveRestaurant""","""controllers.Admin.saveRestaurant"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """saveRestaurant""","""controllers.Admin.saveR"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """saveFood""","""controllers.Admin.saveFood(rId:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """saveFood""","""controllers.Admin.saveF"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """showFood""","""controllers.Admin.showFood(rId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """justShowFood""","""controllers.Admin.justShowFood(rId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """updateFood""","""controllers.Admin.updateFood(fId:String, rId:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """updateFood""","""controllers.Admin.updateF"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deleteFood""","""controllers.Admin.deleteF(fId:String, rId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deleteRestaurant""","""controllers.Admin.deleteR(rId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """updateRestaurant""","""controllers.Admin.updateRestaurant(rId:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """updateRestaurant""","""controllers.Admin.updateR"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """setRestaurant""","""controllers.Admin.setR(rId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """saveUser""","""controllers.Admin.saveUser"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """saveUser""","""controllers.Admin.saveU"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """userManager""","""controllers.Admin.userManager"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """finishOrder""","""controllers.Admin.finishOrder"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """orderOpenControl""","""controllers.Admin.orderOpenControl(status:String, endTime:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """userUpdate""","""controllers.Admin.userUpdate(uId:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """userUpdate""","""controllers.Admin.updateU"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """userDelete""","""controllers.Admin.userDelete(uId:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """recharge""","""controllers.Admin.recharge(uId:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """recharge""","""controllers.Admin.rech"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """orderRecords""","""controllers.Admin.orderRecords"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """showRecord""","""controllers.Admin.showRecord(date:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """normalUser""","""controllers.NormalUser.index"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """orderFood""","""controllers.NormalUser.orderF"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cancleOrder""","""controllers.NormalUser.cancleO(oId:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """nuUpdatePasswd""","""controllers.NormalUser.updatePW"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """nuUpdatePasswd""","""controllers.NormalUser.updatePasswd"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """showUserHistory""","""controllers.NormalUser.showUserHistory"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
       
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Application_login0(params) => {
   call { 
        invokeHandler(controllers.Application.login, HandlerDef(this, "controllers.Application", "login", Nil,"GET", """ Auth page""", Routes.prefix + """"""))
   }
}
        

// @LINE:8
case controllers_Application_authenticate1(params) => {
   call { 
        invokeHandler(controllers.Application.authenticate, HandlerDef(this, "controllers.Application", "authenticate", Nil,"POST", """GET 	/login 						controllers.Application.login""", Routes.prefix + """login"""))
   }
}
        

// @LINE:9
case controllers_Application_logout2(params) => {
   call { 
        invokeHandler(controllers.Application.logout, HandlerDef(this, "controllers.Application", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
   }
}
        

// @LINE:12
case controllers_Admin_index3(params) => {
   call { 
        invokeHandler(controllers.Admin.index, HandlerDef(this, "controllers.Admin", "index", Nil,"GET", """ Admin page""", Routes.prefix + """admin"""))
   }
}
        

// @LINE:14
case controllers_Admin_RFmanager4(params) => {
   call { 
        invokeHandler(controllers.Admin.RFmanager, HandlerDef(this, "controllers.Admin", "RFmanager", Nil,"GET", """ POST 	/addUser 					controllers.Admin.addUser""", Routes.prefix + """RFmanager"""))
   }
}
        

// @LINE:15
case controllers_Admin_saveRestaurant5(params) => {
   call { 
        invokeHandler(controllers.Admin.saveRestaurant, HandlerDef(this, "controllers.Admin", "saveRestaurant", Nil,"GET", """""", Routes.prefix + """saveRestaurant"""))
   }
}
        

// @LINE:16
case controllers_Admin_saveR6(params) => {
   call { 
        invokeHandler(controllers.Admin.saveR, HandlerDef(this, "controllers.Admin", "saveR", Nil,"POST", """""", Routes.prefix + """saveRestaurant"""))
   }
}
        

// @LINE:17
case controllers_Admin_saveFood7(params) => {
   call(params.fromQuery[String]("rId", None)) { (rId) =>
        invokeHandler(controllers.Admin.saveFood(rId), HandlerDef(this, "controllers.Admin", "saveFood", Seq(classOf[String]),"GET", """""", Routes.prefix + """saveFood"""))
   }
}
        

// @LINE:18
case controllers_Admin_saveF8(params) => {
   call { 
        invokeHandler(controllers.Admin.saveF, HandlerDef(this, "controllers.Admin", "saveF", Nil,"POST", """""", Routes.prefix + """saveFood"""))
   }
}
        

// @LINE:19
case controllers_Admin_showFood9(params) => {
   call(params.fromQuery[String]("rId", None)) { (rId) =>
        invokeHandler(controllers.Admin.showFood(rId), HandlerDef(this, "controllers.Admin", "showFood", Seq(classOf[String]),"GET", """""", Routes.prefix + """showFood"""))
   }
}
        

// @LINE:20
case controllers_Admin_justShowFood10(params) => {
   call(params.fromQuery[String]("rId", None)) { (rId) =>
        invokeHandler(controllers.Admin.justShowFood(rId), HandlerDef(this, "controllers.Admin", "justShowFood", Seq(classOf[String]),"GET", """""", Routes.prefix + """justShowFood"""))
   }
}
        

// @LINE:21
case controllers_Admin_updateFood11(params) => {
   call(params.fromQuery[String]("fId", None), params.fromQuery[String]("rId", None)) { (fId, rId) =>
        invokeHandler(controllers.Admin.updateFood(fId, rId), HandlerDef(this, "controllers.Admin", "updateFood", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """updateFood"""))
   }
}
        

// @LINE:22
case controllers_Admin_updateF12(params) => {
   call { 
        invokeHandler(controllers.Admin.updateF, HandlerDef(this, "controllers.Admin", "updateF", Nil,"POST", """""", Routes.prefix + """updateFood"""))
   }
}
        

// @LINE:23
case controllers_Admin_deleteF13(params) => {
   call(params.fromQuery[String]("fId", None), params.fromQuery[String]("rId", None)) { (fId, rId) =>
        invokeHandler(controllers.Admin.deleteF(fId, rId), HandlerDef(this, "controllers.Admin", "deleteF", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """deleteFood"""))
   }
}
        

// @LINE:24
case controllers_Admin_deleteR14(params) => {
   call(params.fromQuery[String]("rId", None)) { (rId) =>
        invokeHandler(controllers.Admin.deleteR(rId), HandlerDef(this, "controllers.Admin", "deleteR", Seq(classOf[String]),"GET", """""", Routes.prefix + """deleteRestaurant"""))
   }
}
        

// @LINE:25
case controllers_Admin_updateRestaurant15(params) => {
   call(params.fromQuery[String]("rId", None)) { (rId) =>
        invokeHandler(controllers.Admin.updateRestaurant(rId), HandlerDef(this, "controllers.Admin", "updateRestaurant", Seq(classOf[String]),"GET", """""", Routes.prefix + """updateRestaurant"""))
   }
}
        

// @LINE:26
case controllers_Admin_updateR16(params) => {
   call { 
        invokeHandler(controllers.Admin.updateR, HandlerDef(this, "controllers.Admin", "updateR", Nil,"POST", """""", Routes.prefix + """updateRestaurant"""))
   }
}
        

// @LINE:27
case controllers_Admin_setR17(params) => {
   call(params.fromQuery[String]("rId", None)) { (rId) =>
        invokeHandler(controllers.Admin.setR(rId), HandlerDef(this, "controllers.Admin", "setR", Seq(classOf[String]),"GET", """""", Routes.prefix + """setRestaurant"""))
   }
}
        

// @LINE:28
case controllers_Admin_saveUser18(params) => {
   call { 
        invokeHandler(controllers.Admin.saveUser, HandlerDef(this, "controllers.Admin", "saveUser", Nil,"GET", """""", Routes.prefix + """saveUser"""))
   }
}
        

// @LINE:29
case controllers_Admin_saveU19(params) => {
   call { 
        invokeHandler(controllers.Admin.saveU, HandlerDef(this, "controllers.Admin", "saveU", Nil,"POST", """""", Routes.prefix + """saveUser"""))
   }
}
        

// @LINE:30
case controllers_Admin_userManager20(params) => {
   call { 
        invokeHandler(controllers.Admin.userManager, HandlerDef(this, "controllers.Admin", "userManager", Nil,"GET", """""", Routes.prefix + """userManager"""))
   }
}
        

// @LINE:31
case controllers_Admin_finishOrder21(params) => {
   call { 
        invokeHandler(controllers.Admin.finishOrder, HandlerDef(this, "controllers.Admin", "finishOrder", Nil,"POST", """""", Routes.prefix + """finishOrder"""))
   }
}
        

// @LINE:32
case controllers_Admin_orderOpenControl22(params) => {
   call(params.fromQuery[String]("status", None), params.fromQuery[String]("endTime", None)) { (status, endTime) =>
        invokeHandler(controllers.Admin.orderOpenControl(status, endTime), HandlerDef(this, "controllers.Admin", "orderOpenControl", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """orderOpenControl"""))
   }
}
        

// @LINE:33
case controllers_Admin_userUpdate23(params) => {
   call(params.fromQuery[String]("uId", None)) { (uId) =>
        invokeHandler(controllers.Admin.userUpdate(uId), HandlerDef(this, "controllers.Admin", "userUpdate", Seq(classOf[String]),"GET", """""", Routes.prefix + """userUpdate"""))
   }
}
        

// @LINE:34
case controllers_Admin_updateU24(params) => {
   call { 
        invokeHandler(controllers.Admin.updateU, HandlerDef(this, "controllers.Admin", "updateU", Nil,"POST", """""", Routes.prefix + """userUpdate"""))
   }
}
        

// @LINE:35
case controllers_Admin_userDelete25(params) => {
   call(params.fromQuery[String]("uId", None)) { (uId) =>
        invokeHandler(controllers.Admin.userDelete(uId), HandlerDef(this, "controllers.Admin", "userDelete", Seq(classOf[String]),"GET", """""", Routes.prefix + """userDelete"""))
   }
}
        

// @LINE:36
case controllers_Admin_recharge26(params) => {
   call(params.fromQuery[String]("uId", None)) { (uId) =>
        invokeHandler(controllers.Admin.recharge(uId), HandlerDef(this, "controllers.Admin", "recharge", Seq(classOf[String]),"GET", """""", Routes.prefix + """recharge"""))
   }
}
        

// @LINE:37
case controllers_Admin_rech27(params) => {
   call { 
        invokeHandler(controllers.Admin.rech, HandlerDef(this, "controllers.Admin", "rech", Nil,"POST", """""", Routes.prefix + """recharge"""))
   }
}
        

// @LINE:38
case controllers_Admin_orderRecords28(params) => {
   call { 
        invokeHandler(controllers.Admin.orderRecords, HandlerDef(this, "controllers.Admin", "orderRecords", Nil,"GET", """""", Routes.prefix + """orderRecords"""))
   }
}
        

// @LINE:39
case controllers_Admin_showRecord29(params) => {
   call(params.fromQuery[String]("date", None)) { (date) =>
        invokeHandler(controllers.Admin.showRecord(date), HandlerDef(this, "controllers.Admin", "showRecord", Seq(classOf[String]),"GET", """""", Routes.prefix + """showRecord"""))
   }
}
        

// @LINE:42
case controllers_NormalUser_index30(params) => {
   call { 
        invokeHandler(controllers.NormalUser.index, HandlerDef(this, "controllers.NormalUser", "index", Nil,"GET", """ Normal User page""", Routes.prefix + """normalUser"""))
   }
}
        

// @LINE:43
case controllers_NormalUser_orderF31(params) => {
   call { 
        invokeHandler(controllers.NormalUser.orderF, HandlerDef(this, "controllers.NormalUser", "orderF", Nil,"POST", """""", Routes.prefix + """orderFood"""))
   }
}
        

// @LINE:44
case controllers_NormalUser_cancleO32(params) => {
   call(params.fromQuery[String]("oId", None)) { (oId) =>
        invokeHandler(controllers.NormalUser.cancleO(oId), HandlerDef(this, "controllers.NormalUser", "cancleO", Seq(classOf[String]),"GET", """""", Routes.prefix + """cancleOrder"""))
   }
}
        

// @LINE:45
case controllers_NormalUser_updatePW33(params) => {
   call { 
        invokeHandler(controllers.NormalUser.updatePW, HandlerDef(this, "controllers.NormalUser", "updatePW", Nil,"POST", """""", Routes.prefix + """nuUpdatePasswd"""))
   }
}
        

// @LINE:46
case controllers_NormalUser_updatePasswd34(params) => {
   call { 
        invokeHandler(controllers.NormalUser.updatePasswd, HandlerDef(this, "controllers.NormalUser", "updatePasswd", Nil,"GET", """""", Routes.prefix + """nuUpdatePasswd"""))
   }
}
        

// @LINE:48
case controllers_NormalUser_showUserHistory35(params) => {
   call { 
        invokeHandler(controllers.NormalUser.showUserHistory, HandlerDef(this, "controllers.NormalUser", "showUserHistory", Nil,"GET", """ GET		/nuUPError					controllers.NormalUser.upError""", Routes.prefix + """showUserHistory"""))
   }
}
        

// @LINE:51
case controllers_Assets_at36(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}
    
}
        