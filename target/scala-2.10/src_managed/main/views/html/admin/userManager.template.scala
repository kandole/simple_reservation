
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
object userManager extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,List[models.User],Flash,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(uList: List[models.User])(implicit flash: Flash):play.api.templates.Html = {
        _display_ {import views.ViewHelper._


Seq[Any](format.raw/*1.66*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main(title)/*5.13*/ {_display_(Seq[Any](format.raw/*5.15*/("""
	"""),_display_(Seq[Any](/*6.3*/adminNavbar("nav4"))),format.raw/*6.22*/("""

	<div>
		<a class="btn btn-primary" href="/saveUser">添加用户</a>
	</div>
	<div>
	"""),_display_(Seq[Any](/*12.3*/flash/*12.8*/.get("updateUserSuccess").map/*12.37*/ {message =>_display_(Seq[Any](format.raw/*12.49*/("""
        <div class="alert alert-success">"""),_display_(Seq[Any](/*13.43*/message)),format.raw/*13.50*/("""</div>
    """)))})),format.raw/*14.6*/("""
	</div>
	<div>
	"""),_display_(Seq[Any](/*17.3*/flash/*17.8*/.get("rechargeSuccess").map/*17.35*/ {message =>_display_(Seq[Any](format.raw/*17.47*/("""
        <div class="alert alert-success">"""),_display_(Seq[Any](/*18.43*/message)),format.raw/*18.50*/("""</div>
    """)))})),format.raw/*19.6*/("""
	</div>

	<div>
		<table class="table">
			<caption>用户总体信息</caption>
			<thead>
				<tr>
					<th>总人数</th>
					<th>账户总额</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>"""),_display_(Seq[Any](/*33.11*/uList/*33.16*/.size)),format.raw/*33.21*/(""" 人</td>
					<td>"""),_display_(Seq[Any](/*34.11*/totalBalance(uList))),format.raw/*34.30*/(""" 元</td>
				</tr>
			</tbody>
		</table>

		<table class="table">
			<caption>用户列表</caption>
			<thead>
				<tr>
					<th>登录名</th>
					<th>姓名</th>
					<th>权限</th>
					<th>账户余额</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				"""),_display_(Seq[Any](/*51.6*/for(u <- uList) yield /*51.21*/ {_display_(Seq[Any](format.raw/*51.23*/("""
				<tr>
					<td>"""),_display_(Seq[Any](/*53.11*/u/*53.12*/.login_id)),format.raw/*53.21*/("""</td>
					<td>"""),_display_(Seq[Any](/*54.11*/u/*54.12*/.name)),format.raw/*54.17*/("""</td>
					<td>"""),_display_(Seq[Any](/*55.11*/u/*55.12*/.authority)),format.raw/*55.22*/("""</td>
					<td>"""),_display_(Seq[Any](/*56.11*/u/*56.12*/.balance)),format.raw/*56.20*/(""" 元</td>
					<td>
						<a class="btn btn-warning" href="/userUpdate?uId="""),_display_(Seq[Any](/*58.57*/u/*58.58*/.id.toString)),format.raw/*58.70*/("""">修改</a>
						<a id="deleteULink_"""),_display_(Seq[Any](/*59.27*/u/*59.28*/.id.toString)),format.raw/*59.40*/("""" class="btn btn-danger" href="#">删除</a>
						<script type="text/javascript">
							$(document).ready(function()"""),format.raw/*61.36*/("""{"""),format.raw/*61.37*/("""
							  $('#deleteULink_"""),_display_(Seq[Any](/*62.27*/u/*62.28*/.id.toString)),format.raw/*62.40*/("""').click(function()"""),format.raw/*62.59*/("""{"""),format.raw/*62.60*/("""
							  	var r = confirm("确定要删除该用户？")
							  	if (r==true) """),format.raw/*64.24*/("""{"""),format.raw/*64.25*/("""
							  		window.location.href = "/userDelete?uId="""),_display_(Seq[Any](/*65.53*/u/*65.54*/.id.toString)),format.raw/*65.66*/(""""
							  	"""),format.raw/*66.11*/("""}"""),format.raw/*66.12*/("""

							  """),format.raw/*68.10*/("""}"""),format.raw/*68.11*/(""")
							"""),format.raw/*69.8*/("""}"""),format.raw/*69.9*/(""");
						</script>
						<a class="btn btn-success" href="/recharge?uId="""),_display_(Seq[Any](/*71.55*/u/*71.56*/.id.toString)),format.raw/*71.68*/("""">充值</a>
					</td>
				</tr>
				""")))})),format.raw/*74.6*/("""
			</tbody>
		</table>
	</div>
""")))})))}
    }
    
    def render(title:String,uList:List[models.User],flash:Flash): play.api.templates.Html = apply(title)(uList)(flash)
    
    def f:((String) => (List[models.User]) => (Flash) => play.api.templates.Html) = (title) => (uList) => (flash) => apply(title)(uList)(flash)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jul 17 12:23:04 CST 2013
                    SOURCE: /opt/dacOrder.git/app/views/admin/userManager.scala.html
                    HASH: 2c92eb47195bf4322fb080d3d7795a8c50c7f189
                    MATRIX: 572->1|739->65|767->94|803->96|822->107|861->109|898->112|938->131|1054->212|1067->217|1105->246|1155->258|1234->301|1263->308|1306->320|1359->338|1372->343|1408->370|1458->382|1537->425|1566->432|1609->444|1824->623|1838->628|1865->633|1919->651|1960->670|2234->909|2265->924|2305->926|2361->946|2371->947|2402->956|2454->972|2464->973|2491->978|2543->994|2553->995|2585->1005|2637->1021|2647->1022|2677->1030|2787->1104|2797->1105|2831->1117|2902->1152|2912->1153|2946->1165|3088->1279|3117->1280|3180->1307|3190->1308|3224->1320|3271->1339|3300->1340|3391->1403|3420->1404|3509->1457|3519->1458|3553->1470|3593->1482|3622->1483|3661->1494|3690->1495|3726->1504|3754->1505|3863->1578|3873->1579|3907->1591|3973->1626
                    LINES: 20->1|24->1|26->4|27->5|27->5|27->5|28->6|28->6|34->12|34->12|34->12|34->12|35->13|35->13|36->14|39->17|39->17|39->17|39->17|40->18|40->18|41->19|55->33|55->33|55->33|56->34|56->34|73->51|73->51|73->51|75->53|75->53|75->53|76->54|76->54|76->54|77->55|77->55|77->55|78->56|78->56|78->56|80->58|80->58|80->58|81->59|81->59|81->59|83->61|83->61|84->62|84->62|84->62|84->62|84->62|86->64|86->64|87->65|87->65|87->65|88->66|88->66|90->68|90->68|91->69|91->69|93->71|93->71|93->71|96->74
                    -- GENERATED --
                */
            