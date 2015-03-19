
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
object saveRestaurant extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Form[models.Restaurant],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(rForm: Form[models.Restaurant]):play.api.templates.Html = {
        _display_ {import helper._

import helper.twitterBootstrap._


Seq[Any](format.raw/*1.49*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main(title)/*6.13*/ {_display_(Seq[Any](format.raw/*6.15*/("""
	"""),_display_(Seq[Any](/*7.3*/adminNavbar("nav2"))),format.raw/*7.22*/("""

	<div class="form-sub">
	"""),_display_(Seq[Any](/*10.3*/helper/*10.9*/.form(action = routes.Admin.saveR)/*10.43*/ {_display_(Seq[Any](format.raw/*10.45*/("""
    <fieldset>
		<legend>添加饭店</legend>

		"""),_display_(Seq[Any](/*14.4*/rForm/*14.9*/.globalError.map/*14.25*/ {error =>_display_(Seq[Any](format.raw/*14.35*/("""
                <div class="alert alert-error">"""),_display_(Seq[Any](/*15.49*/error/*15.54*/.message)),format.raw/*15.62*/("""</div>
        """)))})),format.raw/*16.10*/("""
		"""),_display_(Seq[Any](/*17.4*/inputText(
			rForm("name"),
			'_label -> "饭店名",
			'_help -> "请输入饭店名"			
		))),format.raw/*21.4*/("""
		"""),_display_(Seq[Any](/*22.4*/inputText(
			rForm("phone1"),
			'_label -> "电话1",
			'_help -> "请输入一个电话号码"			
		))),format.raw/*26.4*/("""
		"""),_display_(Seq[Any](/*27.4*/inputText(
			rForm("phone2"),
			'_label -> "电话2",
			'_help -> "请输入另一个电话号码"			
		))),format.raw/*31.4*/("""
		"""),_display_(Seq[Any](/*32.4*/inputFile(
			rForm("pic"),
			'_label -> "图片",
			'_help -> "该饭店的宣传"			
		))),format.raw/*36.4*/("""
		"""),_display_(Seq[Any](/*37.4*/textarea(
			rForm("others"),
			'_label -> "备注",
			'_help -> "如有其他信息，请输入"	,
			'rows -> 3,
			'cols -> 50		
		))),format.raw/*43.4*/("""
		<input type="hidden" name="isSeted" value="false" />
	</fieldset>
	<div class="actions">
		<input type="submit" value="添加" class="btn btn-primary" />
		<a class="btn" href="javascript:;" onClick="javascript:history.back(-1)">返回</a>
	</div>
	""")))})),format.raw/*50.3*/("""
	</div>
	<script type="text/javascript">
		$(document).ready(function()"""),format.raw/*53.31*/("""{"""),format.raw/*53.32*/("""
			$('#name').focus()
		"""),format.raw/*55.3*/("""}"""),format.raw/*55.4*/(""")
	</script>
""")))})))}
    }
    
    def render(title:String,rForm:Form[models.Restaurant]): play.api.templates.Html = apply(title)(rForm)
    
    def f:((String) => (Form[models.Restaurant]) => play.api.templates.Html) = (title) => (rForm) => apply(title)(rForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jul 26 11:20:47 CST 2013
                    SOURCE: /opt/dacOrder.git/app/views/admin/saveRestaurant.scala.html
                    HASH: ad45857db0d748ff8e280bf384bf24bc5faec8f0
                    MATRIX: 575->1|749->48|777->101|813->103|832->114|871->116|908->119|948->138|1011->166|1025->172|1068->206|1108->208|1187->252|1200->257|1225->273|1273->283|1358->332|1372->337|1402->345|1450->361|1489->365|1588->443|1627->447|1731->530|1770->534|1875->618|1914->622|2011->698|2050->702|2184->815|2460->1060|2560->1132|2589->1133|2641->1158|2669->1159
                    LINES: 20->1|26->1|28->5|29->6|29->6|29->6|30->7|30->7|33->10|33->10|33->10|33->10|37->14|37->14|37->14|37->14|38->15|38->15|38->15|39->16|40->17|44->21|45->22|49->26|50->27|54->31|55->32|59->36|60->37|66->43|73->50|76->53|76->53|78->55|78->55
                    -- GENERATED --
                */
            