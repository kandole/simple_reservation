
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
object showFood extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[String,models.Restaurant,List[models.Food],Flash,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(r: models.Restaurant)(fList: List[models.Food])(implicit flash: Flash):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.88*/("""


"""),_display_(Seq[Any](/*4.2*/main(title)/*4.13*/ {_display_(Seq[Any](format.raw/*4.15*/("""
	"""),_display_(Seq[Any](/*5.3*/adminNavbar("nav2"))),format.raw/*5.22*/("""

	<div>
		<a class="btn btn-primary" href="/saveFood?rId="""),_display_(Seq[Any](/*8.51*/r/*8.52*/.id.toString)),format.raw/*8.64*/("""">添加菜品</a>
	</div>

	"""),_display_(Seq[Any](/*11.3*/flash/*11.8*/.get("updateFoodSuccess").map/*11.37*/ {message =>_display_(Seq[Any](format.raw/*11.49*/("""
        <div class="alert alert-success">"""),_display_(Seq[Any](/*12.43*/message)),format.raw/*12.50*/("""</div>
    """)))})),format.raw/*13.6*/("""

	<div>
		<table class="table">
			<caption>"""),_display_(Seq[Any](/*17.14*/r/*17.15*/.name)),format.raw/*17.20*/(""" 的 菜品列表</caption>
			<thead>
				<tr>
					<th>名称</th>
					<th>价格</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				"""),_display_(Seq[Any](/*26.6*/for(f <- fList) yield /*26.21*/ {_display_(Seq[Any](format.raw/*26.23*/("""
				<tr>
					<td>"""),_display_(Seq[Any](/*28.11*/f/*28.12*/.name)),format.raw/*28.17*/("""</td>
					<td>"""),_display_(Seq[Any](/*29.11*/f/*29.12*/.price)),format.raw/*29.18*/(""" 元</td>
					<td>
						<a class="btn btn-warning" href="/updateFood?fId="""),_display_(Seq[Any](/*31.57*/f/*31.58*/.id.toString)),format.raw/*31.70*/("""&rId="""),_display_(Seq[Any](/*31.76*/r/*31.77*/.id.toString)),format.raw/*31.89*/("""">修改</a>
						<a id="deleteFLink_"""),_display_(Seq[Any](/*32.27*/f/*32.28*/.id.toString)),format.raw/*32.40*/("""" class="btn btn-danger" href="#">删除</a></td>
						<script type="text/javascript">
							$(document).ready(function()"""),format.raw/*34.36*/("""{"""),format.raw/*34.37*/("""
							  $('#deleteFLink_"""),_display_(Seq[Any](/*35.27*/f/*35.28*/.id.toString)),format.raw/*35.40*/("""').click(function()"""),format.raw/*35.59*/("""{"""),format.raw/*35.60*/("""
							  	var r = confirm("确定要删除该菜品？")
							  	if (r==true) """),format.raw/*37.24*/("""{"""),format.raw/*37.25*/("""
							  		window.location.href = "/deleteFood?fId="""),_display_(Seq[Any](/*38.53*/f/*38.54*/.id.toString)),format.raw/*38.66*/("""&rId="""),_display_(Seq[Any](/*38.72*/r/*38.73*/.id.toString)),format.raw/*38.85*/(""""
							  	"""),format.raw/*39.11*/("""}"""),format.raw/*39.12*/("""

							  """),format.raw/*41.10*/("""}"""),format.raw/*41.11*/(""")
							"""),format.raw/*42.8*/("""}"""),format.raw/*42.9*/(""");
						</script>
					</td>
				</tr>
				""")))})),format.raw/*46.6*/("""
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
                    SOURCE: /opt/dacOrder.git/app/views/admin/showFood.scala.html
                    HASH: 538309cc0f56c349c7f56f28ef1539fb20f39b93
                    MATRIX: 587->1|750->87|788->91|807->102|846->104|883->107|923->126|1017->185|1026->186|1059->198|1116->220|1129->225|1167->254|1217->266|1296->309|1325->316|1368->328|1450->374|1460->375|1487->380|1649->507|1680->522|1720->524|1776->544|1786->545|1813->550|1865->566|1875->567|1903->573|2013->647|2023->648|2057->660|2099->666|2109->667|2143->679|2214->714|2224->715|2258->727|2405->846|2434->847|2497->874|2507->875|2541->887|2588->906|2617->907|2708->970|2737->971|2826->1024|2836->1025|2870->1037|2912->1043|2922->1044|2956->1056|2996->1068|3025->1069|3064->1080|3093->1081|3129->1090|3157->1091|3233->1136
                    LINES: 20->1|23->1|26->4|26->4|26->4|27->5|27->5|30->8|30->8|30->8|33->11|33->11|33->11|33->11|34->12|34->12|35->13|39->17|39->17|39->17|48->26|48->26|48->26|50->28|50->28|50->28|51->29|51->29|51->29|53->31|53->31|53->31|53->31|53->31|53->31|54->32|54->32|54->32|56->34|56->34|57->35|57->35|57->35|57->35|57->35|59->37|59->37|60->38|60->38|60->38|60->38|60->38|60->38|61->39|61->39|63->41|63->41|64->42|64->42|68->46
                    -- GENERATED --
                */
            