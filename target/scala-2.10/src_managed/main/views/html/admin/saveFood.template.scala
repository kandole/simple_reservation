
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
object saveFood extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[String,Form[models.Food],String,Flash,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(foodForm: Form[models.Food])(rId: String)(implicit flash: Flash):play.api.templates.Html = {
        _display_ {import helper._

import helper.twitterBootstrap._


Seq[Any](format.raw/*1.82*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main(title)/*6.13*/ {_display_(Seq[Any](format.raw/*6.15*/("""
	"""),_display_(Seq[Any](/*7.3*/adminNavbar("nav2"))),format.raw/*7.22*/("""
	<div class="form-sub">
	"""),_display_(Seq[Any](/*9.3*/flash/*9.8*/.get("food").map/*9.24*/ {message =>_display_(Seq[Any](format.raw/*9.36*/("""
        <div class="alert alert-success">"""),_display_(Seq[Any](/*10.43*/message)),format.raw/*10.50*/("""</div>
        <a class="btn btn-warning" href="/RFmanager">结束</a>
    """)))})),format.raw/*12.6*/("""
    
	"""),_display_(Seq[Any](/*14.3*/helper/*14.9*/.form(action = routes.Admin.saveF)/*14.43*/ {_display_(Seq[Any](format.raw/*14.45*/("""
    <fieldset>
		<legend>添加菜品</legend>
		"""),_display_(Seq[Any](/*17.4*/inputText(
			foodForm("name"),
			'_label -> "菜名",
			'_help -> "请输入菜名"			
		))),format.raw/*21.4*/("""
		"""),_display_(Seq[Any](/*22.4*/inputText(
			foodForm("price"),
			'_label -> "价格,单位：元",
			'_help -> "请输入价格"			
		))),format.raw/*26.4*/("""
	</fieldset>
	<input type="hidden" name="restaurant" value=""""),_display_(Seq[Any](/*28.49*/rId)),format.raw/*28.52*/("""" />
	<div class="actions">
		<input type="submit" value="添加" class="btn btn-primary" />
		<a class="btn" href="javascript:;" onClick="javascript:history.back(-1)">返回</a>
	</div>
	""")))})),format.raw/*33.3*/("""
	</div>
	<script type="text/javascript">
		$(document).ready(function()"""),format.raw/*36.31*/("""{"""),format.raw/*36.32*/("""
			$('#name').focus()
		"""),format.raw/*38.3*/("""}"""),format.raw/*38.4*/(""")
	</script>

""")))})))}
    }
    
    def render(title:String,foodForm:Form[models.Food],rId:String,flash:Flash): play.api.templates.Html = apply(title)(foodForm)(rId)(flash)
    
    def f:((String) => (Form[models.Food]) => (String) => (Flash) => play.api.templates.Html) = (title) => (foodForm) => (rId) => (flash) => apply(title)(foodForm)(rId)(flash)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jul 17 08:05:00 CST 2013
                    SOURCE: /opt/dacOrder.git/app/views/admin/saveFood.scala.html
                    HASH: 4acfda2ac98054478997bbb1ff663c6b309655f4
                    MATRIX: 576->1|783->81|811->134|847->136|866->147|905->149|942->152|982->171|1043->198|1055->203|1079->219|1128->231|1207->274|1236->281|1339->353|1382->361|1396->367|1439->401|1479->403|1557->446|1657->525|1696->529|1802->614|1900->676|1925->679|2137->860|2237->932|2266->933|2318->958|2346->959
                    LINES: 20->1|26->1|28->5|29->6|29->6|29->6|30->7|30->7|32->9|32->9|32->9|32->9|33->10|33->10|35->12|37->14|37->14|37->14|37->14|40->17|44->21|45->22|49->26|51->28|51->28|56->33|59->36|59->36|61->38|61->38
                    -- GENERATED --
                */
            