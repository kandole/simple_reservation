package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.User

import org.bson.types.ObjectId

object Application extends Controller {
  
  val loginForm = Form(
    tuple(
      "login_id" -> text,
      "passwd" -> text,
      "authority" -> text
    ) verifying("无效的用户名、密码或权限", result => result match {
      case (login_id, passwd, authority) => User.authenticate(login_id, passwd, authority).isDefined
      })
  )

  def login = Action { implicit request =>
    Ok(views.html.login(loginForm))
  }

  def authenticate = Action {implicit request =>
    loginForm.bindFromRequest.fold(
      formWithErrors => BadRequest(views.html.login(formWithErrors)),
      user => {
        if (user._3.equals("管理员"))
          Redirect(routes.Admin.index).withSession("admin_login_id" -> user._1)
        else 
          Redirect(routes.NormalUser.index()).withSession("login_id" -> user._1)
          
      }
    )
  }

  def logout = Action {
    Redirect(routes.Application.login).withNewSession.flashing(
      "logoutSuccess" -> "已退出，欢迎再来~"
    )
  }
}

trait Secured {
  private def loginId(request: RequestHeader) = request.session.get("login_id")
  private def adminLoginId(request: RequestHeader) = request.session.get("admin_login_id")

  private def onUnauthorized(request: RequestHeader) = Results.Redirect(routes.Application.login)

  def isAuthed(f: => String => Request[AnyContent] => Result) =  Security.Authenticated(loginId, onUnauthorized) {
    user => Action(request => f(user)(request))
  }

  def adminIsAuthed(f: => String => Request[AnyContent] => Result) =  Security.Authenticated(adminLoginId, onUnauthorized) {
    user => Action(request => f(user)(request))
  }

}