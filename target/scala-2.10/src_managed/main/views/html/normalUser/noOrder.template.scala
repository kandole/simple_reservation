
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
object noOrder extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,User,Flash,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(user: User)(implicit flash: Flash):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.52*/("""

"""),_display_(Seq[Any](/*3.2*/main(title)/*3.13*/ {_display_(Seq[Any](format.raw/*3.15*/("""
	"""),_display_(Seq[Any](/*4.3*/nuMain(user)/*4.15*/("nav1")/*4.23*/ {_display_(Seq[Any](format.raw/*4.25*/("""
	<div class="jumbotron">
		<h1>现在没有订单</h1>
	</div>
	""")))}/*8.3*/(flash))),format.raw/*8.10*/("""
""")))})))}
    }
    
    def render(title:String,user:User,flash:Flash): play.api.templates.Html = apply(title)(user)(flash)
    
    def f:((String) => (User) => (Flash) => play.api.templates.Html) = (title) => (user) => (flash) => apply(title)(user)(flash)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jul 17 08:04:56 CST 2013
                    SOURCE: /opt/dacOrder.git/app/views/normalUser/noOrder.scala.html
                    HASH: d33bbc6fa5d52b9689768c9e6259f5b25a244897
                    MATRIX: 560->1|687->51|724->54|743->65|782->67|819->70|839->82|855->90|894->92|965->146|993->153
                    LINES: 20->1|23->1|25->3|25->3|25->3|26->4|26->4|26->4|26->4|30->8|30->8
                    -- GENERATED --
                */
            