// @SOURCE:/opt/dacOrder.git/conf/routes
// @HASH:1ff78e2fdc7aa82e72b58bfa00148c68dee87883
// @DATE:Fri Jul 19 08:13:23 CST 2013

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._
import java.net.URLEncoder

import play.api.mvc._
import se.radley.plugin.salat.Binders._

import Router.queryString


// @LINE:51
// @LINE:48
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:12
// @LINE:9
// @LINE:8
// @LINE:6
package controllers {

// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:12
class ReverseAdmin {
    

// @LINE:15
def saveRestaurant(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "saveRestaurant")
}
                                                

// @LINE:39
def showRecord(date:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "showRecord" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("date", date)))))
}
                                                

// @LINE:29
def saveU(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "saveUser")
}
                                                

// @LINE:36
def recharge(uId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "recharge" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("uId", uId)))))
}
                                                

// @LINE:35
def userDelete(uId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "userDelete" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("uId", uId)))))
}
                                                

// @LINE:28
def saveUser(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "saveUser")
}
                                                

// @LINE:30
def userManager(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "userManager")
}
                                                

// @LINE:33
def userUpdate(uId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "userUpdate" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("uId", uId)))))
}
                                                

// @LINE:19
def showFood(rId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "showFood" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("rId", rId)))))
}
                                                

// @LINE:20
def justShowFood(rId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "justShowFood" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("rId", rId)))))
}
                                                

// @LINE:17
def saveFood(rId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "saveFood" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("rId", rId)))))
}
                                                

// @LINE:32
def orderOpenControl(status:String, endTime:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "orderOpenControl" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("status", status)), Some(implicitly[QueryStringBindable[String]].unbind("endTime", endTime)))))
}
                                                

// @LINE:21
def updateFood(fId:String, rId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "updateFood" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("fId", fId)), Some(implicitly[QueryStringBindable[String]].unbind("rId", rId)))))
}
                                                

// @LINE:34
def updateU(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "userUpdate")
}
                                                

// @LINE:25
def updateRestaurant(rId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "updateRestaurant" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("rId", rId)))))
}
                                                

// @LINE:22
def updateF(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "updateFood")
}
                                                

// @LINE:31
def finishOrder(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "finishOrder")
}
                                                

// @LINE:23
def deleteF(fId:String, rId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deleteFood" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("fId", fId)), Some(implicitly[QueryStringBindable[String]].unbind("rId", rId)))))
}
                                                

// @LINE:16
def saveR(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "saveRestaurant")
}
                                                

// @LINE:14
def RFmanager(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "RFmanager")
}
                                                

// @LINE:12
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "admin")
}
                                                

// @LINE:37
def rech(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "recharge")
}
                                                

// @LINE:18
def saveF(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "saveFood")
}
                                                

// @LINE:24
def deleteR(rId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deleteRestaurant" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("rId", rId)))))
}
                                                

// @LINE:27
def setR(rId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "setRestaurant" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("rId", rId)))))
}
                                                

// @LINE:26
def updateR(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "updateRestaurant")
}
                                                

// @LINE:38
def orderRecords(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "orderRecords")
}
                                                
    
}
                          

// @LINE:9
// @LINE:8
// @LINE:6
class ReverseApplication {
    

// @LINE:8
def authenticate(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "login")
}
                                                

// @LINE:9
def logout(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                                                

// @LINE:6
def login(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          

// @LINE:48
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
class ReverseNormalUser {
    

// @LINE:45
def updatePW(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "nuUpdatePasswd")
}
                                                

// @LINE:46
def updatePasswd(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "nuUpdatePasswd")
}
                                                

// @LINE:44
def cancleO(oId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cancleOrder" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("oId", oId)))))
}
                                                

// @LINE:42
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "normalUser")
}
                                                

// @LINE:48
def showUserHistory(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "showUserHistory")
}
                                                

// @LINE:43
def orderF(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "orderFood")
}
                                                
    
}
                          

// @LINE:51
class ReverseAssets {
    

// @LINE:51
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          
}
                  


// @LINE:51
// @LINE:48
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:12
// @LINE:9
// @LINE:8
// @LINE:6
package controllers.javascript {

// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:12
class ReverseAdmin {
    

// @LINE:15
def saveRestaurant : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.saveRestaurant",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "saveRestaurant"})
      }
   """
)
                        

// @LINE:39
def showRecord : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.showRecord",
   """
      function(date) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "showRecord" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("date", date)])})
      }
   """
)
                        

// @LINE:29
def saveU : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.saveU",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "saveUser"})
      }
   """
)
                        

// @LINE:36
def recharge : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.recharge",
   """
      function(uId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recharge" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("uId", uId)])})
      }
   """
)
                        

// @LINE:35
def userDelete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.userDelete",
   """
      function(uId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "userDelete" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("uId", uId)])})
      }
   """
)
                        

// @LINE:28
def saveUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.saveUser",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "saveUser"})
      }
   """
)
                        

// @LINE:30
def userManager : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.userManager",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "userManager"})
      }
   """
)
                        

// @LINE:33
def userUpdate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.userUpdate",
   """
      function(uId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "userUpdate" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("uId", uId)])})
      }
   """
)
                        

// @LINE:19
def showFood : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.showFood",
   """
      function(rId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "showFood" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("rId", rId)])})
      }
   """
)
                        

// @LINE:20
def justShowFood : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.justShowFood",
   """
      function(rId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "justShowFood" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("rId", rId)])})
      }
   """
)
                        

// @LINE:17
def saveFood : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.saveFood",
   """
      function(rId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "saveFood" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("rId", rId)])})
      }
   """
)
                        

// @LINE:32
def orderOpenControl : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.orderOpenControl",
   """
      function(status,endTime) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "orderOpenControl" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("status", status), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("endTime", endTime)])})
      }
   """
)
                        

// @LINE:21
def updateFood : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.updateFood",
   """
      function(fId,rId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "updateFood" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("fId", fId), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("rId", rId)])})
      }
   """
)
                        

// @LINE:34
def updateU : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.updateU",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "userUpdate"})
      }
   """
)
                        

// @LINE:25
def updateRestaurant : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.updateRestaurant",
   """
      function(rId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "updateRestaurant" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("rId", rId)])})
      }
   """
)
                        

// @LINE:22
def updateF : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.updateF",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateFood"})
      }
   """
)
                        

// @LINE:31
def finishOrder : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.finishOrder",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "finishOrder"})
      }
   """
)
                        

// @LINE:23
def deleteF : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.deleteF",
   """
      function(fId,rId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteFood" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("fId", fId), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("rId", rId)])})
      }
   """
)
                        

// @LINE:16
def saveR : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.saveR",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "saveRestaurant"})
      }
   """
)
                        

// @LINE:14
def RFmanager : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.RFmanager",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "RFmanager"})
      }
   """
)
                        

// @LINE:12
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin"})
      }
   """
)
                        

// @LINE:37
def rech : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.rech",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "recharge"})
      }
   """
)
                        

// @LINE:18
def saveF : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.saveF",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "saveFood"})
      }
   """
)
                        

// @LINE:24
def deleteR : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.deleteR",
   """
      function(rId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteRestaurant" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("rId", rId)])})
      }
   """
)
                        

// @LINE:27
def setR : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.setR",
   """
      function(rId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "setRestaurant" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("rId", rId)])})
      }
   """
)
                        

// @LINE:26
def updateR : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.updateR",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateRestaurant"})
      }
   """
)
                        

// @LINE:38
def orderRecords : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Admin.orderRecords",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "orderRecords"})
      }
   """
)
                        
    
}
              

// @LINE:9
// @LINE:8
// @LINE:6
class ReverseApplication {
    

// @LINE:8
def authenticate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.authenticate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

// @LINE:9
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:6
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.login",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              

// @LINE:48
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
class ReverseNormalUser {
    

// @LINE:45
def updatePW : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NormalUser.updatePW",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "nuUpdatePasswd"})
      }
   """
)
                        

// @LINE:46
def updatePasswd : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NormalUser.updatePasswd",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "nuUpdatePasswd"})
      }
   """
)
                        

// @LINE:44
def cancleO : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NormalUser.cancleO",
   """
      function(oId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cancleOrder" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("oId", oId)])})
      }
   """
)
                        

// @LINE:42
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NormalUser.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "normalUser"})
      }
   """
)
                        

// @LINE:48
def showUserHistory : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NormalUser.showUserHistory",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "showUserHistory"})
      }
   """
)
                        

// @LINE:43
def orderF : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.NormalUser.orderF",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "orderFood"})
      }
   """
)
                        
    
}
              

// @LINE:51
class ReverseAssets {
    

// @LINE:51
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              
}
        


// @LINE:51
// @LINE:48
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:12
// @LINE:9
// @LINE:8
// @LINE:6
package controllers.ref {

// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:12
class ReverseAdmin {
    

// @LINE:15
def saveRestaurant(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.saveRestaurant(), HandlerDef(this, "controllers.Admin", "saveRestaurant", Seq(), "GET", """""", _prefix + """saveRestaurant""")
)
                      

// @LINE:39
def showRecord(date:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.showRecord(date), HandlerDef(this, "controllers.Admin", "showRecord", Seq(classOf[String]), "GET", """""", _prefix + """showRecord""")
)
                      

// @LINE:29
def saveU(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.saveU(), HandlerDef(this, "controllers.Admin", "saveU", Seq(), "POST", """""", _prefix + """saveUser""")
)
                      

// @LINE:36
def recharge(uId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.recharge(uId), HandlerDef(this, "controllers.Admin", "recharge", Seq(classOf[String]), "GET", """""", _prefix + """recharge""")
)
                      

// @LINE:35
def userDelete(uId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.userDelete(uId), HandlerDef(this, "controllers.Admin", "userDelete", Seq(classOf[String]), "GET", """""", _prefix + """userDelete""")
)
                      

// @LINE:28
def saveUser(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.saveUser(), HandlerDef(this, "controllers.Admin", "saveUser", Seq(), "GET", """""", _prefix + """saveUser""")
)
                      

// @LINE:30
def userManager(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.userManager(), HandlerDef(this, "controllers.Admin", "userManager", Seq(), "GET", """""", _prefix + """userManager""")
)
                      

// @LINE:33
def userUpdate(uId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.userUpdate(uId), HandlerDef(this, "controllers.Admin", "userUpdate", Seq(classOf[String]), "GET", """""", _prefix + """userUpdate""")
)
                      

// @LINE:19
def showFood(rId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.showFood(rId), HandlerDef(this, "controllers.Admin", "showFood", Seq(classOf[String]), "GET", """""", _prefix + """showFood""")
)
                      

// @LINE:20
def justShowFood(rId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.justShowFood(rId), HandlerDef(this, "controllers.Admin", "justShowFood", Seq(classOf[String]), "GET", """""", _prefix + """justShowFood""")
)
                      

// @LINE:17
def saveFood(rId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.saveFood(rId), HandlerDef(this, "controllers.Admin", "saveFood", Seq(classOf[String]), "GET", """""", _prefix + """saveFood""")
)
                      

// @LINE:32
def orderOpenControl(status:String, endTime:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.orderOpenControl(status, endTime), HandlerDef(this, "controllers.Admin", "orderOpenControl", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """orderOpenControl""")
)
                      

// @LINE:21
def updateFood(fId:String, rId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.updateFood(fId, rId), HandlerDef(this, "controllers.Admin", "updateFood", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """updateFood""")
)
                      

// @LINE:34
def updateU(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.updateU(), HandlerDef(this, "controllers.Admin", "updateU", Seq(), "POST", """""", _prefix + """userUpdate""")
)
                      

// @LINE:25
def updateRestaurant(rId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.updateRestaurant(rId), HandlerDef(this, "controllers.Admin", "updateRestaurant", Seq(classOf[String]), "GET", """""", _prefix + """updateRestaurant""")
)
                      

// @LINE:22
def updateF(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.updateF(), HandlerDef(this, "controllers.Admin", "updateF", Seq(), "POST", """""", _prefix + """updateFood""")
)
                      

// @LINE:31
def finishOrder(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.finishOrder(), HandlerDef(this, "controllers.Admin", "finishOrder", Seq(), "POST", """""", _prefix + """finishOrder""")
)
                      

// @LINE:23
def deleteF(fId:String, rId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.deleteF(fId, rId), HandlerDef(this, "controllers.Admin", "deleteF", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """deleteFood""")
)
                      

// @LINE:16
def saveR(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.saveR(), HandlerDef(this, "controllers.Admin", "saveR", Seq(), "POST", """""", _prefix + """saveRestaurant""")
)
                      

// @LINE:14
def RFmanager(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.RFmanager(), HandlerDef(this, "controllers.Admin", "RFmanager", Seq(), "GET", """ POST 	/addUser 					controllers.Admin.addUser""", _prefix + """RFmanager""")
)
                      

// @LINE:12
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.index(), HandlerDef(this, "controllers.Admin", "index", Seq(), "GET", """ Admin page""", _prefix + """admin""")
)
                      

// @LINE:37
def rech(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.rech(), HandlerDef(this, "controllers.Admin", "rech", Seq(), "POST", """""", _prefix + """recharge""")
)
                      

// @LINE:18
def saveF(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.saveF(), HandlerDef(this, "controllers.Admin", "saveF", Seq(), "POST", """""", _prefix + """saveFood""")
)
                      

// @LINE:24
def deleteR(rId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.deleteR(rId), HandlerDef(this, "controllers.Admin", "deleteR", Seq(classOf[String]), "GET", """""", _prefix + """deleteRestaurant""")
)
                      

// @LINE:27
def setR(rId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.setR(rId), HandlerDef(this, "controllers.Admin", "setR", Seq(classOf[String]), "GET", """""", _prefix + """setRestaurant""")
)
                      

// @LINE:26
def updateR(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.updateR(), HandlerDef(this, "controllers.Admin", "updateR", Seq(), "POST", """""", _prefix + """updateRestaurant""")
)
                      

// @LINE:38
def orderRecords(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Admin.orderRecords(), HandlerDef(this, "controllers.Admin", "orderRecords", Seq(), "GET", """""", _prefix + """orderRecords""")
)
                      
    
}
                          

// @LINE:9
// @LINE:8
// @LINE:6
class ReverseApplication {
    

// @LINE:8
def authenticate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.authenticate(), HandlerDef(this, "controllers.Application", "authenticate", Seq(), "POST", """GET 	/login 						controllers.Application.login""", _prefix + """login""")
)
                      

// @LINE:9
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:6
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Seq(), "GET", """ Auth page""", _prefix + """""")
)
                      
    
}
                          

// @LINE:48
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
class ReverseNormalUser {
    

// @LINE:45
def updatePW(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.NormalUser.updatePW(), HandlerDef(this, "controllers.NormalUser", "updatePW", Seq(), "POST", """""", _prefix + """nuUpdatePasswd""")
)
                      

// @LINE:46
def updatePasswd(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.NormalUser.updatePasswd(), HandlerDef(this, "controllers.NormalUser", "updatePasswd", Seq(), "GET", """""", _prefix + """nuUpdatePasswd""")
)
                      

// @LINE:44
def cancleO(oId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.NormalUser.cancleO(oId), HandlerDef(this, "controllers.NormalUser", "cancleO", Seq(classOf[String]), "GET", """""", _prefix + """cancleOrder""")
)
                      

// @LINE:42
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.NormalUser.index(), HandlerDef(this, "controllers.NormalUser", "index", Seq(), "GET", """ Normal User page""", _prefix + """normalUser""")
)
                      

// @LINE:48
def showUserHistory(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.NormalUser.showUserHistory(), HandlerDef(this, "controllers.NormalUser", "showUserHistory", Seq(), "GET", """ GET		/nuUPError					controllers.NormalUser.upError""", _prefix + """showUserHistory""")
)
                      

// @LINE:43
def orderF(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.NormalUser.orderF(), HandlerDef(this, "controllers.NormalUser", "orderF", Seq(), "POST", """""", _prefix + """orderFood""")
)
                      
    
}
                          

// @LINE:51
class ReverseAssets {
    

// @LINE:51
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          
}
                  
      