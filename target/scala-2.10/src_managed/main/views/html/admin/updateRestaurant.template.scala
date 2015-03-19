
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
object updateRestaurant extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Form[models.URestaurant],String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(rForm: Form[models.URestaurant])(rId: String):play.api.templates.Html = {
        _display_ {import helper._

import helper.twitterBootstrap._


Seq[Any](format.raw/*1.63*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main(title)/*6.13*/ {_display_(Seq[Any](format.raw/*6.15*/("""
	"""),_display_(Seq[Any](/*7.3*/adminNavbar("nav2"))),format.raw/*7.22*/("""

	<div class="form-sub">
	"""),_display_(Seq[Any](/*10.3*/helper/*10.9*/.form(action = routes.Admin.updateR)/*10.45*/ {_display_(Seq[Any](format.raw/*10.47*/("""
    <fieldset>
		<legend>"""),_display_(Seq[Any](/*12.12*/title)),format.raw/*12.17*/("""</legend>

        <input type="hidden" name="id" value=""""),_display_(Seq[Any](/*14.48*/rId)),format.raw/*14.51*/("""" />
		"""),_display_(Seq[Any](/*15.4*/inputText(
			rForm("name"),
			'_label -> "饭店名",
			'_help -> "请输入饭店名"			
		))),format.raw/*19.4*/("""
		"""),_display_(Seq[Any](/*20.4*/inputText(
			rForm("phone1"),
			'_label -> "电话1",
			'_help -> "请输入一个电话号码"			
		))),format.raw/*24.4*/("""
		"""),_display_(Seq[Any](/*25.4*/inputText(
			rForm("phone2"),
			'_label -> "电话2",
			'_help -> "请输入另一个电话号码"			
		))),format.raw/*29.4*/("""
		"""),_display_(Seq[Any](/*30.4*/inputFile(
			rForm("pic"),
			'_label -> "图片",
			'_help -> "该饭店的宣传菜单"			
		))),format.raw/*34.4*/("""
		"""),_display_(Seq[Any](/*35.4*/textarea(
			rForm("others"),
			'_label -> "备注",
			'_help -> "如有其他信息，请输入"	,
			'rows -> 3,
			'cols -> 50		
		))),format.raw/*41.4*/("""
	</fieldset>
	<div class="actions">
		<input type="submit" value="修改" class="btn btn-primary" />
		<a class="btn" href="javascript:;" onClick="javascript:history.back(-1)">返回</a>
	</div>
	""")))})),format.raw/*47.3*/("""   
	</div>
	<script type="text/javascript">
		$(document).ready(function()"""),format.raw/*50.31*/("""{"""),format.raw/*50.32*/("""
			$('#name').focus()
		"""),format.raw/*52.3*/("""}"""),format.raw/*52.4*/(""")
	</script>
""")))})),format.raw/*54.2*/("""
"""))}
    }
    
    def render(title:String,rForm:Form[models.URestaurant],rId:String): play.api.templates.Html = apply(title)(rForm)(rId)
    
    def f:((String) => (Form[models.URestaurant]) => (String) => play.api.templates.Html) = (title) => (rForm) => (rId) => apply(title)(rForm)(rId)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jul 26 11:20:48 CST 2013
                    SOURCE: /opt/dacOrder.git/app/views/admin/updateRestaurant.scala.html
                    HASH: dc692f75768d75d1f3e955b67d928df2d4f0f018
                    MATRIX: 585->1|773->62|801->115|837->117|856->128|895->130|932->133|972->152|1035->180|1049->186|1094->222|1134->224|1197->251|1224->256|1318->314|1343->317|1386->325|1485->403|1524->407|1628->490|1667->494|1772->578|1811->582|1910->660|1949->664|2083->777|2304->967|2407->1042|2436->1043|2488->1068|2516->1069|2561->1083
                    LINES: 20->1|26->1|28->5|29->6|29->6|29->6|30->7|30->7|33->10|33->10|33->10|33->10|35->12|35->12|37->14|37->14|38->15|42->19|43->20|47->24|48->25|52->29|53->30|57->34|58->35|64->41|70->47|73->50|73->50|75->52|75->52|77->54
                    -- GENERATED --
                */
            