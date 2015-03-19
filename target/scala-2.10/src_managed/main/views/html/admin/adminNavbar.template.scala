
package views.html.admin

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
object adminNavbar extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(nav: String):play.api.templates.Html = {
        _display_ {import views.ViewHelper


Seq[Any](format.raw/*1.15*/("""

"""),format.raw/*4.1*/("""
	<div class="navbar navbar-inverse">
	  <div class="navbar-inner">
	    <a class="brand" href="/logout">退出</a>
	    <ul class="nav">
	      """),_display_(Seq[Any](/*9.9*/ViewHelper/*9.19*/.showActiveNav(nav))),format.raw/*9.38*/("""
	    </ul>
	  </div>
	</div>"""))}
    }
    
    def render(nav:String): play.api.templates.Html = apply(nav)
    
    def f:((String) => play.api.templates.Html) = (nav) => apply(nav)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jul 17 08:05:00 CST 2013
                    SOURCE: /opt/dacOrder.git/app/views/admin/adminNavbar.scala.html
                    HASH: a65e57c5f83de4b60f817e0e1c9c452bda66dd23
                    MATRIX: 548->1|662->14|690->41|866->183|884->193|924->212
                    LINES: 20->1|24->1|26->4|31->9|31->9|31->9
                    -- GENERATED --
                */
            