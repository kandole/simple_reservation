
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
object orderOff extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Flash,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(implicit flash: Flash):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.40*/("""

"""),_display_(Seq[Any](/*3.2*/main(title)/*3.13*/ {_display_(Seq[Any](format.raw/*3.15*/("""
	"""),_display_(Seq[Any](/*4.3*/adminNavbar("nav1"))),format.raw/*4.22*/("""

	<div class="jumbotron">
	<h1>没有开启订单</h1>
	<p class="lead">请到 [饭店及菜品管理] 中开启订单</p>
	"""),_display_(Seq[Any](/*9.3*/flash/*9.8*/.get("finishOrderSuccess").map/*9.38*/ {message =>_display_(Seq[Any](format.raw/*9.50*/("""
        <div class="alert alert-success">"""),_display_(Seq[Any](/*10.43*/message)),format.raw/*10.50*/("""</div>
    """)))})),format.raw/*11.6*/("""
	</div>
""")))})))}
    }
    
    def render(title:String,flash:Flash): play.api.templates.Html = apply(title)(flash)
    
    def f:((String) => (Flash) => play.api.templates.Html) = (title) => (flash) => apply(title)(flash)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jul 17 08:05:00 CST 2013
                    SOURCE: /opt/dacOrder.git/app/views/admin/orderOff.scala.html
                    HASH: 4f9971c20ef3f3935499c87ff686467030f4f6d3
                    MATRIX: 551->1|666->39|703->42|722->53|761->55|798->58|838->77|958->163|970->168|1008->198|1057->210|1136->253|1165->260|1208->272
                    LINES: 20->1|23->1|25->3|25->3|25->3|26->4|26->4|31->9|31->9|31->9|31->9|32->10|32->10|33->11
                    -- GENERATED --
                */
            