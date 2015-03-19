
package views.html.normalUser

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
import org.bson.types.ObjectId
/**/
object nuNavbar extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,models.User,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(nav: String, user: models.User):play.api.templates.Html = {
        _display_ {import views.ViewHelper


Seq[Any](format.raw/*1.34*/("""

"""),format.raw/*4.1*/("""
	<div class="navbar">
	  <div class="navbar-inner">
	    <a class="brand" href="/logout">退出</a>
	    """),_display_(Seq[Any](/*8.7*/ViewHelper/*8.17*/.showActiveNavForNU(nav, user))),format.raw/*8.47*/("""
	  </div>
	</div>"""))}
    }
    
    def render(nav:String,user:models.User): play.api.templates.Html = apply(nav,user)
    
    def f:((String,models.User) => play.api.templates.Html) = (nav,user) => apply(nav,user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jul 17 08:04:58 CST 2013
                    SOURCE: /opt/dacOrder.git/app/views/normalUser/nuNavbar.scala.html
                    HASH: dc3384a80c5898cbb8539ca558bdf7e78200eef9
                    MATRIX: 562->1|695->33|723->60|860->163|878->173|929->203
                    LINES: 20->1|24->1|26->4|30->8|30->8|30->8
                    -- GENERATED --
                */
            