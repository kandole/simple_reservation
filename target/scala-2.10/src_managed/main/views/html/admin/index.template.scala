
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
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template5[String,Restaurant,List[models.OrderReal],List[models.FoodOrder],models.OrderControl,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(r: Restaurant)(orList: List[models.OrderReal])(ofList: List[models.FoodOrder])(oc: models.OrderControl):play.api.templates.Html = {
        _display_ {import views.normalUser.NUIndexHelper


Seq[Any](format.raw/*1.121*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main(title)/*5.13*/ {_display_(Seq[Any](format.raw/*5.15*/("""
	
	"""),_display_(Seq[Any](/*7.3*/adminNavbar("nav1"))),format.raw/*7.22*/("""
	<div class="alert alert-block">
	  <button type="button" class="close" data-dismiss="alert">&times;</button>
	  <h4>请注意!</h4>
	  <p>“划账”前，请再次刷新该页面，以确保看到当前所有的订单</p>
	  <p>当前版本只支持一天进行一次“划账”操作</p>
	</div>

	<table class="table">
		<caption>今日订单 饭店："""),_display_(Seq[Any](/*16.21*/r/*16.22*/.name)),format.raw/*16.27*/("""<caption>	
		<thead>
			<tr>
				<th>总人数</th>
				<th>总份数</th>
				<th>总金额</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>"""),_display_(Seq[Any](/*26.10*/orList/*26.16*/.size)),format.raw/*26.21*/(""" 人</td>
				<td>"""),_display_(Seq[Any](/*27.10*/NUIndexHelper/*27.23*/.totalNum(orList))),format.raw/*27.40*/(""" 份</td>
				<td>"""),_display_(Seq[Any](/*28.10*/NUIndexHelper/*28.23*/.totalMoney(orList))),format.raw/*28.42*/(""" 元</td>
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
			"""),_display_(Seq[Any](/*43.5*/for(of <- ofList) yield /*43.22*/ {_display_(Seq[Any](format.raw/*43.24*/("""
			<tr>
				<td>"""),_display_(Seq[Any](/*45.10*/of/*45.12*/.name)),format.raw/*45.17*/("""</td>
				<td>"""),_display_(Seq[Any](/*46.10*/of/*46.12*/.price)),format.raw/*46.18*/(""" 元</td>
				<td name="fen">"""),_display_(Seq[Any](/*47.21*/of/*47.23*/.num)),format.raw/*47.27*/(""" 份</td>
			</tr>
			""")))})),format.raw/*49.5*/("""
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
			"""),_display_(Seq[Any](/*66.5*/for(or <- orList) yield /*66.22*/ {_display_(Seq[Any](format.raw/*66.24*/("""
			<tr>
				<td>
					"""),_display_(Seq[Any](/*69.7*/or/*69.9*/.user.name)),format.raw/*69.19*/("""
					<input type="hidden" name="uIds["""),_display_(Seq[Any](/*70.39*/orList/*70.45*/.indexOf(or))),format.raw/*70.57*/("""]" value=""""),_display_(Seq[Any](/*70.68*/or/*70.70*/.user.id.toString)),format.raw/*70.87*/("""" />
				</td>
				<td>
				"""),_display_(Seq[Any](/*73.6*/for((f, n) <- or.food) yield /*73.28*/ {_display_(Seq[Any](format.raw/*73.30*/("""
					<p>"""),_display_(Seq[Any](/*74.10*/f/*74.11*/.name)),format.raw/*74.16*/(""" - """),_display_(Seq[Any](/*74.20*/f/*74.21*/.price)),format.raw/*74.27*/(""" 元 ["""),_display_(Seq[Any](/*74.32*/n)),format.raw/*74.33*/(""" 份]</p>
				""")))})),format.raw/*75.6*/("""
				</td>
				<td>
					"""),_display_(Seq[Any](/*78.7*/or/*78.9*/.user.balance)),format.raw/*78.22*/(""" 元
				</td>
				<td>
					"""),_display_(Seq[Any](/*81.7*/NUIndexHelper/*81.20*/.onesMoney(or))),format.raw/*81.34*/(""" 元
					<input type="hidden" name="pays["""),_display_(Seq[Any](/*82.39*/orList/*82.45*/.indexOf(or))),format.raw/*82.57*/("""]" value=""""),_display_(Seq[Any](/*82.68*/NUIndexHelper/*82.81*/.onesMoney(or))),format.raw/*82.95*/("""" />
				</td>
			</tr>
			""")))})),format.raw/*85.5*/("""
		</tbody>
	</table>

	"""),_display_(Seq[Any](/*89.3*/if(oc.status == "open")/*89.26*/ {_display_(Seq[Any](format.raw/*89.28*/("""
		<button class="btn btn-success" type="submit">划账</button>
        
    """)))}/*92.7*/else/*92.12*/{_display_(Seq[Any](format.raw/*92.13*/("""
		"""),_display_(Seq[Any](/*93.4*/if(oc.status == "closed")/*93.29*/ {_display_(Seq[Any](format.raw/*93.31*/("""
			<a class="btn btn-warning disabled" href="#">未开启</a>
		""")))}/*95.5*/else/*95.10*/{_display_(Seq[Any](format.raw/*95.11*/("""
			"""),_display_(Seq[Any](/*96.5*/if(oc.status == "finished")/*96.32*/ {_display_(Seq[Any](format.raw/*96.34*/("""
				<a class="btn btn-danger disabled" href="#">已划账</a>
			""")))}/*98.6*/else/*98.11*/{_display_(Seq[Any](format.raw/*98.12*/("""
				<a class="btn btn-danger disabled" href="#">已取消</a>
			""")))})),format.raw/*100.5*/("""
		""")))})),format.raw/*101.4*/("""
	""")))})),format.raw/*102.3*/("""
	</form>

""")))})))}
    }
    
    def render(title:String,r:Restaurant,orList:List[models.OrderReal],ofList:List[models.FoodOrder],oc:models.OrderControl): play.api.templates.Html = apply(title)(r)(orList)(ofList)(oc)
    
    def f:((String) => (Restaurant) => (List[models.OrderReal]) => (List[models.FoodOrder]) => (models.OrderControl) => play.api.templates.Html) = (title) => (r) => (orList) => (ofList) => (oc) => apply(title)(r)(orList)(ofList)(oc)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jul 18 12:08:15 CST 2013
                    SOURCE: /opt/dacOrder.git/app/views/admin/index.scala.html
                    HASH: cad69b625c066d468f7a0a0f481cfebd8f39076f
                    MATRIX: 619->1|854->120|882->161|918->163|937->174|976->176|1015->181|1055->200|1339->448|1349->449|1376->454|1539->581|1554->587|1581->592|1634->609|1656->622|1695->639|1748->656|1770->669|1811->688|2034->876|2067->893|2107->895|2161->913|2172->915|2199->920|2250->935|2261->937|2289->943|2353->971|2364->973|2390->977|2442->998|2720->1241|2753->1258|2793->1260|2852->1284|2862->1286|2894->1296|2969->1335|2984->1341|3018->1353|3065->1364|3076->1366|3115->1383|3179->1412|3217->1434|3257->1436|3303->1446|3313->1447|3340->1452|3380->1456|3390->1457|3418->1463|3459->1468|3482->1469|3526->1482|3587->1508|3597->1510|3632->1523|3695->1551|3717->1564|3753->1578|3830->1619|3845->1625|3879->1637|3926->1648|3948->1661|3984->1675|4043->1703|4103->1728|4135->1751|4175->1753|4268->1829|4281->1834|4320->1835|4359->1839|4393->1864|4433->1866|4511->1927|4524->1932|4563->1933|4603->1938|4639->1965|4679->1967|4758->2029|4771->2034|4810->2035|4903->2096|4939->2100|4974->2103
                    LINES: 20->1|24->1|26->4|27->5|27->5|27->5|29->7|29->7|38->16|38->16|38->16|48->26|48->26|48->26|49->27|49->27|49->27|50->28|50->28|50->28|65->43|65->43|65->43|67->45|67->45|67->45|68->46|68->46|68->46|69->47|69->47|69->47|71->49|88->66|88->66|88->66|91->69|91->69|91->69|92->70|92->70|92->70|92->70|92->70|92->70|95->73|95->73|95->73|96->74|96->74|96->74|96->74|96->74|96->74|96->74|96->74|97->75|100->78|100->78|100->78|103->81|103->81|103->81|104->82|104->82|104->82|104->82|104->82|104->82|107->85|111->89|111->89|111->89|114->92|114->92|114->92|115->93|115->93|115->93|117->95|117->95|117->95|118->96|118->96|118->96|120->98|120->98|120->98|122->100|123->101|124->102
                    -- GENERATED --
                */
            