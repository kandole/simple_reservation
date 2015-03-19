
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
object saveUser extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Form[models.User],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(message: String)(userForm: Form[models.User]):play.api.templates.Html = {
        _display_ {import helper._

import helper.twitterBootstrap._


Seq[Any](format.raw/*1.48*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main(message)/*6.15*/ {_display_(Seq[Any](format.raw/*6.17*/("""

	"""),_display_(Seq[Any](/*8.3*/adminNavbar("nav4"))),format.raw/*8.22*/("""
	<div class="form-sub">
    """),_display_(Seq[Any](/*10.6*/helper/*10.12*/.form(action = routes.Admin.saveU)/*10.46*/ {_display_(Seq[Any](format.raw/*10.48*/("""
    <fieldset>
		<legend>"""),_display_(Seq[Any](/*12.12*/message)),format.raw/*12.19*/("""</legend>
		"""),_display_(Seq[Any](/*13.4*/inputText(
			userForm("login_id"),
			'_label -> "登录名",
			'_help -> "请输入登录名"
			
		))),format.raw/*18.4*/("""
		"""),_display_(Seq[Any](/*19.4*/inputPassword(
			userForm("passwd"),
			'_label -> "密码",
			'_help -> "请输入密码"
		))),format.raw/*23.4*/("""
		"""),_display_(Seq[Any](/*24.4*/inputText(
			userForm("name"),			
			'_label -> "姓名",
			'_help -> "请填写真实姓名"
		))),format.raw/*28.4*/("""
		"""),_display_(Seq[Any](/*29.4*/select(
			userForm("authority"),
			options = options(List("普通用户", "管理员")),
			'_label -> "权限",
			'_help -> "请选择权限"
		))),format.raw/*34.4*/("""
		"""),_display_(Seq[Any](/*35.4*/inputText(
			userForm("balance"),
			'_label -> "金额",
			'_help -> "请输入金额"
		))),format.raw/*39.4*/("""
	</fieldset>
	<div class="actions">
		<input type="submit" value="添加" class="btn btn-primary" />
	</div>
	""")))})),format.raw/*44.3*/("""   
	</div>
	<script type="text/javascript">
		$(document).ready(function()"""),format.raw/*47.31*/("""{"""),format.raw/*47.32*/("""
			$('#login_id').focus()
		"""),format.raw/*49.3*/("""}"""),format.raw/*49.4*/(""")
	</script>
""")))})),format.raw/*51.2*/("""
"""))}
    }
    
    def render(message:String,userForm:Form[models.User]): play.api.templates.Html = apply(message)(userForm)
    
    def f:((String) => (Form[models.User]) => play.api.templates.Html) = (message) => (userForm) => apply(message)(userForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jul 17 08:04:59 CST 2013
                    SOURCE: /opt/dacOrder.git/app/views/admin/saveUser.scala.html
                    HASH: 263b23ce7e7247af49922f831c426b8cbb5c8a74
                    MATRIX: 563->1|736->47|764->100|800->102|821->115|860->117|898->121|938->140|1003->170|1018->176|1061->210|1101->212|1164->239|1193->246|1241->259|1348->345|1387->349|1490->431|1529->435|1631->516|1670->520|1812->641|1851->645|1951->724|2090->832|2193->907|2222->908|2278->937|2306->938|2351->952
                    LINES: 20->1|26->1|28->5|29->6|29->6|29->6|31->8|31->8|33->10|33->10|33->10|33->10|35->12|35->12|36->13|41->18|42->19|46->23|47->24|51->28|52->29|57->34|58->35|62->39|67->44|70->47|70->47|72->49|72->49|74->51
                    -- GENERATED --
                */
            