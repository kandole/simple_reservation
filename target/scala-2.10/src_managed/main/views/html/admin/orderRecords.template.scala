
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
object orderRecords extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,List[String],Flash,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(oList: List[String])(implicit flash: Flash):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.61*/("""


"""),_display_(Seq[Any](/*4.2*/main(title)/*4.13*/ {_display_(Seq[Any](format.raw/*4.15*/("""
	"""),_display_(Seq[Any](/*5.3*/adminNavbar("nav3"))),format.raw/*5.22*/("""
	<script src=""""),_display_(Seq[Any](/*6.16*/routes/*6.22*/.Assets.at("javascripts/jquery.pager.js"))),format.raw/*6.63*/("""" type="text/javascript"></script>
    <script type="text/javascript" language="javascript">
    	var pageSize = 10;
        $(document).ready(function() """),format.raw/*9.38*/("""{"""),format.raw/*9.39*/("""
        	hideAllRows();
        	showRows(0, pageSize);
            $("#pager").pager("""),format.raw/*12.31*/("""{"""),format.raw/*12.32*/(""" pagenumber: 1, pagecount: """),_display_(Seq[Any](/*12.60*/{oList.size})),format.raw/*12.72*/("""/pageSize, buttonClickCallback: PageClick """),format.raw/*12.114*/("""}"""),format.raw/*12.115*/(""");

        """),format.raw/*14.9*/("""}"""),format.raw/*14.10*/(""");

        PageClick = function(pageclickednumber) """),format.raw/*16.49*/("""{"""),format.raw/*16.50*/("""
        	hideAllRows();
        	showRows(pageclickednumber-1, pageSize);
            $("#pager").pager("""),format.raw/*19.31*/("""{"""),format.raw/*19.32*/(""" pagenumber: pageclickednumber, pagecount: """),_display_(Seq[Any](/*19.76*/{oList.size})),format.raw/*19.88*/("""/pageSize, buttonClickCallback: PageClick """),format.raw/*19.130*/("""}"""),format.raw/*19.131*/(""");      
        """),format.raw/*20.9*/("""}"""),format.raw/*20.10*/("""

        function showRows(start, size) """),format.raw/*22.40*/("""{"""),format.raw/*22.41*/("""
        	for (var i=start*size; i<start*size+size; i++) """),format.raw/*23.57*/("""{"""),format.raw/*23.58*/("""
        		$(".pager_row").eq(i).show();
        	"""),format.raw/*25.10*/("""}"""),format.raw/*25.11*/("""
        """),format.raw/*26.9*/("""}"""),format.raw/*26.10*/("""
        function hideAllRows() """),format.raw/*27.32*/("""{"""),format.raw/*27.33*/("""
        	for (var i=0; i<"""),_display_(Seq[Any](/*28.27*/oList/*28.32*/.size)),format.raw/*28.37*/("""; i++) """),format.raw/*28.44*/("""{"""),format.raw/*28.45*/("""
        		$(".pager_row").eq(i).hide();
        	"""),format.raw/*30.10*/("""}"""),format.raw/*30.11*/("""
        """),format.raw/*31.9*/("""}"""),format.raw/*31.10*/("""
    </script>
	<table class="table">
		<caption>历史记录</caption>
		<thead>
			<tr>
				<th>日期</th>
				
			</tr>
		</thead>
		<tbody>
			"""),_display_(Seq[Any](/*42.5*/for(d <- oList) yield /*42.20*/ {_display_(Seq[Any](format.raw/*42.22*/("""
			<tr class="pager_row">
				<td><a href="/showRecord?date="""),_display_(Seq[Any](/*44.36*/d)),format.raw/*44.37*/("""">"""),_display_(Seq[Any](/*44.40*/d)),format.raw/*44.41*/("""</a></td>
			</tr>
			""")))})),format.raw/*46.5*/("""
		</tbody>
	</table>
	<div id="pager"></div>
""")))})))}
    }
    
    def render(title:String,oList:List[String],flash:Flash): play.api.templates.Html = apply(title)(oList)(flash)
    
    def f:((String) => (List[String]) => (Flash) => play.api.templates.Html) = (title) => (oList) => (flash) => apply(title)(oList)(flash)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Oct 21 16:30:57 CST 2013
                    SOURCE: /opt/dacOrder.git/app/views/admin/orderRecords.scala.html
                    HASH: a41eb29e7221e6a90d2a142d27cdd3c0b15f7e72
                    MATRIX: 568->1|704->60|742->64|761->75|800->77|837->80|877->99|928->115|942->121|1004->162|1185->316|1213->317|1328->404|1357->405|1421->433|1455->445|1526->487|1556->488|1595->500|1624->501|1704->553|1733->554|1866->659|1895->660|1975->704|2009->716|2080->758|2110->759|2154->776|2183->777|2252->818|2281->819|2366->876|2395->877|2473->927|2502->928|2538->937|2567->938|2627->970|2656->971|2719->998|2733->1003|2760->1008|2795->1015|2824->1016|2902->1066|2931->1067|2967->1076|2996->1077|3168->1214|3199->1229|3239->1231|3337->1293|3360->1294|3399->1297|3422->1298|3476->1321
                    LINES: 20->1|23->1|26->4|26->4|26->4|27->5|27->5|28->6|28->6|28->6|31->9|31->9|34->12|34->12|34->12|34->12|34->12|34->12|36->14|36->14|38->16|38->16|41->19|41->19|41->19|41->19|41->19|41->19|42->20|42->20|44->22|44->22|45->23|45->23|47->25|47->25|48->26|48->26|49->27|49->27|50->28|50->28|50->28|50->28|50->28|52->30|52->30|53->31|53->31|64->42|64->42|64->42|66->44|66->44|66->44|66->44|68->46
                    -- GENERATED --
                */
            