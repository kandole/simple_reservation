
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
object updateUser extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Form[models.UUser],String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(message: String)(userForm: Form[models.UUser])(uId: String):play.api.templates.Html = {
        _display_ {import helper._

import helper.twitterBootstrap._


Seq[Any](format.raw/*1.62*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main(message)/*6.15*/ {_display_(Seq[Any](format.raw/*6.17*/("""

	"""),_display_(Seq[Any](/*8.3*/adminNavbar("nav4"))),format.raw/*8.22*/("""
	<div class="form-sub">
    """),_display_(Seq[Any](/*10.6*/helper/*10.12*/.form(action = routes.Admin.updateU)/*10.48*/ {_display_(Seq[Any](format.raw/*10.50*/("""
    <fieldset>
		<legend>"""),_display_(Seq[Any](/*12.12*/message)),format.raw/*12.19*/("""</legend>
			<input type="hidden" name="id" value=""""),_display_(Seq[Any](/*13.43*/uId)),format.raw/*13.46*/("""" />

		"""),_display_(Seq[Any](/*15.4*/inputText(
			userForm("login_id"),
			'_label -> "登录名",
			'_help -> "请输入登录名"		
		))),format.raw/*19.4*/("""
		"""),_display_(Seq[Any](/*20.4*/inputText(
			userForm("name"),			
			'_label -> "姓名",
			'_help -> "请填写真实姓名"
		))),format.raw/*24.4*/("""
		"""),_display_(Seq[Any](/*25.4*/select(
			userForm("authority"),
			options = options(List("普通用户", "管理员")),
			'_label -> "权限",
			'_help -> "请选择权限"
		))),format.raw/*30.4*/("""
	</fieldset>
	<div class="actions">
		<input type="submit" value="修改" class="btn btn-primary" />
		<a class="btn" href="javascript:;" onClick="javascript:history.back(-1)">返回</a>
	</div>
	""")))})),format.raw/*36.3*/("""   
	</div>
	<script type="text/javascript">
		$(document).ready(function()"""),format.raw/*39.31*/("""{"""),format.raw/*39.32*/("""
			$('#login_id').focus()
		"""),format.raw/*41.3*/("""}"""),format.raw/*41.4*/(""")
	</script>
""")))})),format.raw/*43.2*/("""
"""))}
    }
    
    def render(message:String,userForm:Form[models.UUser],uId:String): play.api.templates.Html = apply(message)(userForm)(uId)
    
    def f:((String) => (Form[models.UUser]) => (String) => play.api.templates.Html) = (message) => (userForm) => (uId) => apply(message)(userForm)(uId)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jul 17 08:05:00 CST 2013
                    SOURCE: /opt/dacOrder.git/app/views/admin/updateUser.scala.html
                    HASH: 95d07662392b09566de8d5ea9a840ae4a32d7f13
                    MATRIX: 573->1|760->61|788->114|824->116|845->129|884->131|922->135|962->154|1027->184|1042->190|1087->226|1127->228|1190->255|1219->262|1307->314|1332->317|1376->326|1481->410|1520->414|1622->495|1661->499|1803->620|2024->810|2127->885|2156->886|2212->915|2240->916|2285->930
                    LINES: 20->1|26->1|28->5|29->6|29->6|29->6|31->8|31->8|33->10|33->10|33->10|33->10|35->12|35->12|36->13|36->13|38->15|42->19|43->20|47->24|48->25|53->30|59->36|62->39|62->39|64->41|64->41|66->43
                    -- GENERATED --
                */
            