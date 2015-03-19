
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
object justShowFood extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[String,models.Restaurant,List[models.Food],Flash,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(r: models.Restaurant)(fList: List[models.Food])(implicit flash: Flash):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.88*/("""


"""),_display_(Seq[Any](/*4.2*/main(title)/*4.13*/ {_display_(Seq[Any](format.raw/*4.15*/("""
	"""),_display_(Seq[Any](/*5.3*/adminNavbar("nav2"))),format.raw/*5.22*/("""

	<div>
		<table class="table">
			<caption>"""),_display_(Seq[Any](/*9.14*/r/*9.15*/.name)),format.raw/*9.20*/(""" 的 菜品列表</caption>
			<thead>
				<tr>
					<th>名称</th>
					<th>价格</th>
				</tr>
			</thead>
			<tbody>
				"""),_display_(Seq[Any](/*17.6*/for(f <- fList) yield /*17.21*/ {_display_(Seq[Any](format.raw/*17.23*/("""
				<tr>
					<td>"""),_display_(Seq[Any](/*19.11*/f/*19.12*/.name)),format.raw/*19.17*/("""</td>
					<td>"""),_display_(Seq[Any](/*20.11*/f/*20.12*/.price)),format.raw/*20.18*/(""" 元</td>
				</tr>
				""")))})),format.raw/*22.6*/("""
			</tbody>
		</table>
		<a class="btn" href="/RFmanager">返回</a>
	</div>

""")))})))}
    }
    
    def render(title:String,r:models.Restaurant,fList:List[models.Food],flash:Flash): play.api.templates.Html = apply(title)(r)(fList)(flash)
    
    def f:((String) => (models.Restaurant) => (List[models.Food]) => (Flash) => play.api.templates.Html) = (title) => (r) => (fList) => (flash) => apply(title)(r)(fList)(flash)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jul 17 08:05:00 CST 2013
                    SOURCE: /opt/dacOrder.git/app/views/admin/justShowFood.scala.html
                    HASH: 39b69e97bc303525fc58752d70c681df9308a334
                    MATRIX: 591->1|754->87|792->91|811->102|850->104|887->107|927->126|1008->172|1017->173|1043->178|1188->288|1219->303|1259->305|1315->325|1325->326|1352->331|1404->347|1414->348|1442->354|1496->377
                    LINES: 20->1|23->1|26->4|26->4|26->4|27->5|27->5|31->9|31->9|31->9|39->17|39->17|39->17|41->19|41->19|41->19|42->20|42->20|42->20|44->22
                    -- GENERATED --
                */
            