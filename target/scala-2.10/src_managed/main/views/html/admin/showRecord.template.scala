
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
object showRecord extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template5[String,Restaurant,List[models.OrderReal],List[models.FoodOrder],String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(r: Restaurant)(orList: List[models.OrderReal])(ofList: List[models.FoodOrder])(d: String):play.api.templates.Html = {
        _display_ {import views.normalUser.NUIndexHelper


Seq[Any](format.raw/*1.107*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main(title)/*5.13*/ {_display_(Seq[Any](format.raw/*5.15*/("""
	
	"""),_display_(Seq[Any](/*7.3*/adminNavbar("nav3"))),format.raw/*7.22*/("""
	<a class="btn" href="javascript:;" onClick="javascript:history.back(-1)">返回</a>
	<table class="table">
		<caption>日期："""),_display_(Seq[Any](/*10.16*/d)),format.raw/*10.17*/(""" 饭店："""),_display_(Seq[Any](/*10.22*/r/*10.23*/.name)),format.raw/*10.28*/("""<caption>	
		<thead>
			<tr>
				<th>总人数</th>
				<th>总份数</th>
				<th>总金额</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>"""),_display_(Seq[Any](/*20.10*/orList/*20.16*/.size)),format.raw/*20.21*/(""" 人</td>
				<td>"""),_display_(Seq[Any](/*21.10*/NUIndexHelper/*21.23*/.totalNum(orList))),format.raw/*21.40*/(""" 份</td>
				<td>"""),_display_(Seq[Any](/*22.10*/NUIndexHelper/*22.23*/.totalMoney(orList))),format.raw/*22.42*/(""" 元</td>
			</tr>
		</tbody>
	</table>

	<table class="table">
		<caption>订单汇总<caption>	
		<thead>
			<tr>
				<th>菜品</th>
				<th>单价</th>
				<th>份数</th>
			</tr>
		</thead>
		<tbody>
			"""),_display_(Seq[Any](/*37.5*/for(of <- ofList) yield /*37.22*/ {_display_(Seq[Any](format.raw/*37.24*/("""
			<tr>
				<td>"""),_display_(Seq[Any](/*39.10*/of/*39.12*/.name)),format.raw/*39.17*/("""</td>
				<td>"""),_display_(Seq[Any](/*40.10*/of/*40.12*/.price)),format.raw/*40.18*/(""" 元</td>
				<td name="fen">"""),_display_(Seq[Any](/*41.21*/of/*41.23*/.num)),format.raw/*41.27*/(""" 份</td>
			</tr>
			""")))})),format.raw/*43.5*/("""
		</tbody>
	</table>	

		
	<form action="/finishOrder" method="post">
	<table class="table">
		<caption>订单详情<caption>	
		<thead>
			<tr>
				<th>买家</th>
				<th>订购菜品及价格</th>
				<th>账户余额</th>
				<th>支出</th>
			</tr>
		</thead>
		<tbody>
			"""),_display_(Seq[Any](/*60.5*/for(or <- orList) yield /*60.22*/ {_display_(Seq[Any](format.raw/*60.24*/("""
			<tr>
				<td>
					"""),_display_(Seq[Any](/*63.7*/or/*63.9*/.user.name)),format.raw/*63.19*/("""
					<input type="hidden" name="uIds["""),_display_(Seq[Any](/*64.39*/orList/*64.45*/.indexOf(or))),format.raw/*64.57*/("""]" value=""""),_display_(Seq[Any](/*64.68*/or/*64.70*/.user.id.toString)),format.raw/*64.87*/("""" />
				</td>
				<td>
				"""),_display_(Seq[Any](/*67.6*/for((f, n) <- or.food) yield /*67.28*/ {_display_(Seq[Any](format.raw/*67.30*/("""
					<p>"""),_display_(Seq[Any](/*68.10*/f/*68.11*/.name)),format.raw/*68.16*/(""" - """),_display_(Seq[Any](/*68.20*/f/*68.21*/.price)),format.raw/*68.27*/(""" 元 ["""),_display_(Seq[Any](/*68.32*/n)),format.raw/*68.33*/(""" 份]</p>
				""")))})),format.raw/*69.6*/("""
				</td>
				<td>
					"""),_display_(Seq[Any](/*72.7*/or/*72.9*/.user.balance)),format.raw/*72.22*/(""" 元
				</td>
				<td>
					"""),_display_(Seq[Any](/*75.7*/NUIndexHelper/*75.20*/.onesMoney(or))),format.raw/*75.34*/(""" 元
					<input type="hidden" name="pays["""),_display_(Seq[Any](/*76.39*/orList/*76.45*/.indexOf(or))),format.raw/*76.57*/("""]" value=""""),_display_(Seq[Any](/*76.68*/NUIndexHelper/*76.81*/.onesMoney(or))),format.raw/*76.95*/("""" />
				</td>
			</tr>
			""")))})),format.raw/*79.5*/("""
		</tbody>
	</table>

	</form>

""")))})))}
    }
    
    def render(title:String,r:Restaurant,orList:List[models.OrderReal],ofList:List[models.FoodOrder],d:String): play.api.templates.Html = apply(title)(r)(orList)(ofList)(d)
    
    def f:((String) => (Restaurant) => (List[models.OrderReal]) => (List[models.FoodOrder]) => (String) => play.api.templates.Html) = (title) => (r) => (orList) => (ofList) => (d) => apply(title)(r)(orList)(ofList)(d)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jul 19 08:13:29 CST 2013
                    SOURCE: /opt/dacOrder.git/app/views/admin/showRecord.scala.html
                    HASH: 972b1da60c3ddc558d943b752f6a36d719e7685f
                    MATRIX: 611->1|832->106|860->147|896->149|915->160|954->162|993->167|1033->186|1189->306|1212->307|1253->312|1263->313|1290->318|1453->445|1468->451|1495->456|1548->473|1570->486|1609->503|1662->520|1684->533|1725->552|1948->740|1981->757|2021->759|2075->777|2086->779|2113->784|2164->799|2175->801|2203->807|2267->835|2278->837|2304->841|2356->862|2634->1105|2667->1122|2707->1124|2766->1148|2776->1150|2808->1160|2883->1199|2898->1205|2932->1217|2979->1228|2990->1230|3029->1247|3093->1276|3131->1298|3171->1300|3217->1310|3227->1311|3254->1316|3294->1320|3304->1321|3332->1327|3373->1332|3396->1333|3440->1346|3501->1372|3511->1374|3546->1387|3609->1415|3631->1428|3667->1442|3744->1483|3759->1489|3793->1501|3840->1512|3862->1525|3898->1539|3957->1567
                    LINES: 20->1|24->1|26->4|27->5|27->5|27->5|29->7|29->7|32->10|32->10|32->10|32->10|32->10|42->20|42->20|42->20|43->21|43->21|43->21|44->22|44->22|44->22|59->37|59->37|59->37|61->39|61->39|61->39|62->40|62->40|62->40|63->41|63->41|63->41|65->43|82->60|82->60|82->60|85->63|85->63|85->63|86->64|86->64|86->64|86->64|86->64|86->64|89->67|89->67|89->67|90->68|90->68|90->68|90->68|90->68|90->68|90->68|90->68|91->69|94->72|94->72|94->72|97->75|97->75|97->75|98->76|98->76|98->76|98->76|98->76|98->76|101->79
                    -- GENERATED --
                */
            