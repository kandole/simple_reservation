
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
object rSaveSuccess extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(rId: String):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.30*/("""


"""),_display_(Seq[Any](/*4.2*/main(title)/*4.13*/ {_display_(Seq[Any](format.raw/*4.15*/("""
	"""),_display_(Seq[Any](/*5.3*/adminNavbar("nav2"))),format.raw/*5.22*/("""
	<div class="jumbotron">
		<h2>添加成功，</h2>
		<h2>是否继续添加该饭店的菜品？</h2>
		<a class="btn btn-success" href="/saveFood?rId="""),_display_(Seq[Any](/*9.51*/rId)),format.raw/*9.54*/("""">继续</a>
		<a class="btn btn-info" href="/RFmanager">返回</a>
	</div>
""")))})))}
    }
    
    def render(title:String,rId:String): play.api.templates.Html = apply(title)(rId)
    
    def f:((String) => (String) => play.api.templates.Html) = (title) => (rId) => apply(title)(rId)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jul 17 08:05:00 CST 2013
                    SOURCE: /opt/dacOrder.git/app/views/admin/rSaveSuccess.scala.html
                    HASH: 070779cd6c10c10c37eb75d1fdaf61e052fe081b
                    MATRIX: 556->1|661->29|699->33|718->44|757->46|794->49|834->68|987->186|1011->189
                    LINES: 20->1|23->1|26->4|26->4|26->4|27->5|27->5|31->9|31->9
                    -- GENERATED --
                */
            