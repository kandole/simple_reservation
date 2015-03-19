
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
object showHistory extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[String,User,List[models.OrderHistory],Flash,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(user: User)(history: List[models.OrderHistory])(implicit flash: Flash):play.api.templates.Html = {
        _display_ {import views.ViewHelper._


Seq[Any](format.raw/*1.88*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main(title)/*5.13*/ {_display_(Seq[Any](format.raw/*5.15*/("""
	"""),_display_(Seq[Any](/*6.3*/nuMain(user)/*6.15*/("nav-showHistory")/*6.34*/ {_display_(Seq[Any](format.raw/*6.36*/("""
	<script src=""""),_display_(Seq[Any](/*7.16*/routes/*7.22*/.Assets.at("javascripts/jquery.pager.js"))),format.raw/*7.63*/("""" type="text/javascript"></script>
    <script type="text/javascript" language="javascript">
    	var pageSize = 10;
        $(document).ready(function() """),format.raw/*10.38*/("""{"""),format.raw/*10.39*/("""
        	hideAllRows();
        	showRows(0, pageSize);
            $("#pager").pager("""),format.raw/*13.31*/("""{"""),format.raw/*13.32*/(""" pagenumber: 1, pagecount: """),_display_(Seq[Any](/*13.60*/{history.size})),format.raw/*13.74*/("""/pageSize, buttonClickCallback: PageClick """),format.raw/*13.116*/("""}"""),format.raw/*13.117*/(""");

        """),format.raw/*15.9*/("""}"""),format.raw/*15.10*/(""");

        PageClick = function(pageclickednumber) """),format.raw/*17.49*/("""{"""),format.raw/*17.50*/("""
        	hideAllRows();
        	showRows(pageclickednumber-1, pageSize);
            $("#pager").pager("""),format.raw/*20.31*/("""{"""),format.raw/*20.32*/(""" pagenumber: pageclickednumber, pagecount: """),_display_(Seq[Any](/*20.76*/{history.size})),format.raw/*20.90*/("""/pageSize, buttonClickCallback: PageClick """),format.raw/*20.132*/("""}"""),format.raw/*20.133*/(""");      
        """),format.raw/*21.9*/("""}"""),format.raw/*21.10*/("""

        function showRows(start, size) """),format.raw/*23.40*/("""{"""),format.raw/*23.41*/("""
        	for (var i=start*size; i<start*size+size; i++) """),format.raw/*24.57*/("""{"""),format.raw/*24.58*/("""
        		$(".pager_row").eq(i).show();
        	"""),format.raw/*26.10*/("""}"""),format.raw/*26.11*/("""
        """),format.raw/*27.9*/("""}"""),format.raw/*27.10*/("""
        function hideAllRows() """),format.raw/*28.32*/("""{"""),format.raw/*28.33*/("""
        	for (var i=0; i<"""),_display_(Seq[Any](/*29.27*/history/*29.34*/.size)),format.raw/*29.39*/("""; i++) """),format.raw/*29.46*/("""{"""),format.raw/*29.47*/("""
        		$(".pager_row").eq(i).hide();
        	"""),format.raw/*31.10*/("""}"""),format.raw/*31.11*/("""
        """),format.raw/*32.9*/("""}"""),format.raw/*32.10*/("""
    </script>
	<table class="table">
		<caption>"""),_display_(Seq[Any](/*35.13*/user/*35.17*/.name)),format.raw/*35.22*/(""" 的订单记录</caption>
		<thead>
			<tr>
				<th>订单号</th>
				<th>饭店</th>
				<th>菜品及单价</th>
				<th>数量</th>
				<th>支出</th>
				<th>日期</th>
				<th>状态</th>
			</tr>
		</thead>
		<tbody>
			"""),_display_(Seq[Any](/*48.5*/for(h <- history) yield /*48.22*/ {_display_(Seq[Any](format.raw/*48.24*/("""
			
			<tr class="pager_row" id="tr-"""),_display_(Seq[Any](/*50.34*/h/*50.35*/.id)),format.raw/*50.38*/("""">
				<td>"""),_display_(Seq[Any](/*51.10*/h/*51.11*/.id)),format.raw/*51.14*/("""</td>
				<td>"""),_display_(Seq[Any](/*52.10*/h/*52.11*/.restaurant.name)),format.raw/*52.27*/("""</td>
				<td>"""),_display_(Seq[Any](/*53.10*/h/*53.11*/.food.name)),format.raw/*53.21*/(""" - """),_display_(Seq[Any](/*53.25*/h/*53.26*/.food.price)),format.raw/*53.37*/(""" 元</td>
				<td>"""),_display_(Seq[Any](/*54.10*/h/*54.11*/.num)),format.raw/*54.15*/(""" 份</td>
				<td>"""),_display_(Seq[Any](/*55.10*/(h.food.price * h.num))),format.raw/*55.32*/(""" 元</td>
				<td>"""),_display_(Seq[Any](/*56.10*/h/*56.11*/.date)),format.raw/*56.16*/("""</td>
				<td>
					"""),_display_(Seq[Any](/*58.7*/showStatusZHCN(h.status))),format.raw/*58.31*/("""
				</td>
			</tr>
			<script type="text/javascript">
				$(document).ready(function()"""),format.raw/*62.33*/("""{"""),format.raw/*62.34*/("""
					if ('"""),_display_(Seq[Any](/*63.12*/h/*63.13*/.status)),format.raw/*63.20*/("""' == "open") """),format.raw/*63.33*/("""{"""),format.raw/*63.34*/("""
						$('#tr-"""),_display_(Seq[Any](/*64.15*/h/*64.16*/.id)),format.raw/*64.19*/("""').addClass('success');
					"""),format.raw/*65.6*/("""}"""),format.raw/*65.7*/(""" else if ('"""),_display_(Seq[Any](/*65.19*/h/*65.20*/.status)),format.raw/*65.27*/("""' == "finished") """),format.raw/*65.44*/("""{"""),format.raw/*65.45*/("""
						$('#tr-"""),_display_(Seq[Any](/*66.15*/h/*66.16*/.id)),format.raw/*66.19*/("""').addClass('info');
					"""),format.raw/*67.6*/("""}"""),format.raw/*67.7*/(""" else """),format.raw/*67.13*/("""{"""),format.raw/*67.14*/("""
						$('#tr-"""),_display_(Seq[Any](/*68.15*/h/*68.16*/.id)),format.raw/*68.19*/("""').addClass('warning');
					"""),format.raw/*69.6*/("""}"""),format.raw/*69.7*/("""

				"""),format.raw/*71.5*/("""}"""),format.raw/*71.6*/(""")
			</script>
			""")))})),format.raw/*73.5*/("""
		</tbody>
	</table>
	<div id="pager"></div>
	""")))}/*77.3*/(flash))),format.raw/*77.10*/("""
""")))})))}
    }
    
    def render(title:String,user:User,history:List[models.OrderHistory],flash:Flash): play.api.templates.Html = apply(title)(user)(history)(flash)
    
    def f:((String) => (User) => (List[models.OrderHistory]) => (Flash) => play.api.templates.Html) = (title) => (user) => (history) => (flash) => apply(title)(user)(history)(flash)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Oct 21 16:30:57 CST 2013
                    SOURCE: /opt/dacOrder.git/app/views/normalUser/showHistory.scala.html
                    HASH: 4e128e2fa56ec9b4ceaf23bdde802fdc49412041
                    MATRIX: 590->1|779->87|807->116|843->118|862->129|901->131|938->134|958->146|985->165|1024->167|1075->183|1089->189|1151->230|1333->384|1362->385|1477->472|1506->473|1570->501|1606->515|1677->557|1707->558|1746->570|1775->571|1855->623|1884->624|2017->729|2046->730|2126->774|2162->788|2233->830|2263->831|2307->848|2336->849|2405->890|2434->891|2519->948|2548->949|2626->999|2655->1000|2691->1009|2720->1010|2780->1042|2809->1043|2872->1070|2888->1077|2915->1082|2950->1089|2979->1090|3057->1140|3086->1141|3122->1150|3151->1151|3237->1201|3250->1205|3277->1210|3497->1395|3530->1412|3570->1414|3644->1452|3654->1453|3679->1456|3727->1468|3737->1469|3762->1472|3813->1487|3823->1488|3861->1504|3912->1519|3922->1520|3954->1530|3994->1534|4004->1535|4037->1546|4090->1563|4100->1564|4126->1568|4179->1585|4223->1607|4276->1624|4286->1625|4313->1630|4369->1651|4415->1675|4530->1762|4559->1763|4607->1775|4617->1776|4646->1783|4687->1796|4716->1797|4767->1812|4777->1813|4802->1816|4858->1845|4886->1846|4934->1858|4944->1859|4973->1866|5018->1883|5047->1884|5098->1899|5108->1900|5133->1903|5186->1929|5214->1930|5248->1936|5277->1937|5328->1952|5338->1953|5363->1956|5419->1985|5447->1986|5480->1992|5508->1993|5558->2012|5624->2060|5653->2067
                    LINES: 20->1|24->1|26->4|27->5|27->5|27->5|28->6|28->6|28->6|28->6|29->7|29->7|29->7|32->10|32->10|35->13|35->13|35->13|35->13|35->13|35->13|37->15|37->15|39->17|39->17|42->20|42->20|42->20|42->20|42->20|42->20|43->21|43->21|45->23|45->23|46->24|46->24|48->26|48->26|49->27|49->27|50->28|50->28|51->29|51->29|51->29|51->29|51->29|53->31|53->31|54->32|54->32|57->35|57->35|57->35|70->48|70->48|70->48|72->50|72->50|72->50|73->51|73->51|73->51|74->52|74->52|74->52|75->53|75->53|75->53|75->53|75->53|75->53|76->54|76->54|76->54|77->55|77->55|78->56|78->56|78->56|80->58|80->58|84->62|84->62|85->63|85->63|85->63|85->63|85->63|86->64|86->64|86->64|87->65|87->65|87->65|87->65|87->65|87->65|87->65|88->66|88->66|88->66|89->67|89->67|89->67|89->67|90->68|90->68|90->68|91->69|91->69|93->71|93->71|95->73|99->77|99->77
                    -- GENERATED --
                */
            