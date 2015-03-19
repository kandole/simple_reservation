
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
object updateFood extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[String,Form[models.Food],String,String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(foodForm: Form[models.Food])(fId: String)(rId: String):play.api.templates.Html = {
        _display_ {import helper._

import helper.twitterBootstrap._


Seq[Any](format.raw/*1.72*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main(title)/*6.13*/ {_display_(Seq[Any](format.raw/*6.15*/("""
	"""),_display_(Seq[Any](/*7.3*/adminNavbar("nav2"))),format.raw/*7.22*/("""
	<div class="form-sub">
    
	"""),_display_(Seq[Any](/*10.3*/helper/*10.9*/.form(action = routes.Admin.updateF)/*10.45*/ {_display_(Seq[Any](format.raw/*10.47*/("""
    <fieldset>
		<legend>添加菜品</legend>
		<input type="hidden" name="id" value=""""),_display_(Seq[Any](/*13.42*/fId)),format.raw/*13.45*/("""" />
		"""),_display_(Seq[Any](/*14.4*/inputText(
			foodForm("name"),
			'_label -> "菜名",
			'_help -> "请输入菜名"			
		))),format.raw/*18.4*/("""
		"""),_display_(Seq[Any](/*19.4*/inputText(
			foodForm("price"),
			'_label -> "价格,单位：元",
			'_help -> "请输入价格"			
		))),format.raw/*23.4*/("""
		<input type="hidden" name="restaurant" value=""""),_display_(Seq[Any](/*24.50*/rId)),format.raw/*24.53*/("""" />
	</fieldset>
	
	<div class="actions">
		<input type="submit" value="修改" class="btn btn-primary" />
		<a class="btn" href="javascript:;" onClick="javascript:history.back(-1)">返回</a>
	</div>
	""")))})),format.raw/*31.3*/("""
	</div>
	<script type="text/javascript">
		$(document).ready(function()"""),format.raw/*34.31*/("""{"""),format.raw/*34.32*/("""
			$('#name').focus()
		"""),format.raw/*36.3*/("""}"""),format.raw/*36.4*/(""")
	</script>

""")))})))}
    }
    
    def render(title:String,foodForm:Form[models.Food],fId:String,rId:String): play.api.templates.Html = apply(title)(foodForm)(fId)(rId)
    
    def f:((String) => (Form[models.Food]) => (String) => (String) => play.api.templates.Html) = (title) => (foodForm) => (fId) => (rId) => apply(title)(foodForm)(fId)(rId)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jul 17 08:05:00 CST 2013
                    SOURCE: /opt/dacOrder.git/app/views/admin/updateFood.scala.html
                    HASH: 5a7a1618c98ba47ab52cbc9b9cb86072dc0a8d96
                    MATRIX: 579->1|776->71|804->124|840->126|859->137|898->139|935->142|975->161|1042->193|1056->199|1101->235|1141->237|1258->318|1283->321|1326->329|1426->408|1465->412|1571->497|1657->547|1682->550|1909->746|2009->818|2038->819|2090->844|2118->845
                    LINES: 20->1|26->1|28->5|29->6|29->6|29->6|30->7|30->7|33->10|33->10|33->10|33->10|36->13|36->13|37->14|41->18|42->19|46->23|47->24|47->24|54->31|57->34|57->34|59->36|59->36
                    -- GENERATED --
                */
            