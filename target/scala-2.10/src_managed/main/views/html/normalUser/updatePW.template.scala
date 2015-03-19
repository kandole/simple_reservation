
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
object updatePW extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[String,models.User,Form[scala.Tuple3[String, String, scala.Tuple2[String, String]]],Flash,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(user: models.User)(passwdUForm: Form[(String, String, (String, String))])(implicit flash: Flash):play.api.templates.Html = {
        _display_ {import helper._

import helper.twitterBootstrap._


Seq[Any](format.raw/*1.114*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main(title)/*6.13*/ {_display_(Seq[Any](format.raw/*6.15*/("""
	"""),_display_(Seq[Any](/*7.3*/nuMain(user)/*7.15*/("nav-changePasswd")/*7.35*/ {_display_(Seq[Any](format.raw/*7.37*/("""
		<div class="form-sub">
			<form action="/nuUpdatePasswd" method="post">
		    	<input type="hidden" name="uId" value=""""),_display_(Seq[Any](/*10.48*/user/*10.52*/.id.toString)),format.raw/*10.64*/("""" />
		    	"""),_display_(Seq[Any](/*11.9*/inputPassword(
		    		passwdUForm("old_passwd"),
		    		'_label -> "原密码", 
	                '_help -> "请输入原密码.",
	                '_error -> passwdUForm.globalError
		    	))),format.raw/*16.9*/(""" 
		        """),_display_(Seq[Any](/*17.12*/inputPassword(
		    		passwdUForm("new_passwd.main"),
		    		'_label -> "新密码", 
	                '_help -> "请输入新密码."
		    	))),format.raw/*21.9*/("""
		    	"""),_display_(Seq[Any](/*22.9*/inputPassword(
		    		passwdUForm("new_passwd.confirm"),
		    		'_label -> "新密码确认", 
	                '_help -> "请再次输入新密码.",
	                '_error -> passwdUForm.error("new_passwd")
		    	))),format.raw/*27.9*/("""
		  	  
			    <button class="btn btn-primary" type="submit">提交修改</button>

			</form>
			<a class="btn" href="/normalUser">返回</a>
		</div>
		<script type="text/javascript">
			$(document).ready(function()"""),format.raw/*35.32*/("""{"""),format.raw/*35.33*/("""
				$('#old_passwd').focus()
			"""),format.raw/*37.4*/("""}"""),format.raw/*37.5*/(""")
		</script>
	""")))}/*39.3*/(flash))),format.raw/*39.10*/("""
""")))})),format.raw/*40.2*/("""

			  """))}
    }
    
    def render(title:String,user:models.User,passwdUForm:Form[scala.Tuple3[String, String, scala.Tuple2[String, String]]],flash:Flash): play.api.templates.Html = apply(title)(user)(passwdUForm)(flash)
    
    def f:((String) => (models.User) => (Form[scala.Tuple3[String, String, scala.Tuple2[String, String]]]) => (Flash) => play.api.templates.Html) = (title) => (user) => (passwdUForm) => (flash) => apply(title)(user)(passwdUForm)(flash)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jul 17 08:04:58 CST 2013
                    SOURCE: /opt/dacOrder.git/app/views/normalUser/updatePW.scala.html
                    HASH: cf0e433a5d9bc1f9fa62c06d1e591fbe73a77ef8
                    MATRIX: 633->1|873->113|901->166|937->168|956->179|995->181|1032->184|1052->196|1080->216|1119->218|1277->340|1290->344|1324->356|1372->369|1568->544|1617->557|1765->684|1809->693|2025->888|2259->1094|2288->1095|2348->1128|2376->1129|2410->1145|2439->1152|2472->1154
                    LINES: 20->1|26->1|28->5|29->6|29->6|29->6|30->7|30->7|30->7|30->7|33->10|33->10|33->10|34->11|39->16|40->17|44->21|45->22|50->27|58->35|58->35|60->37|60->37|62->39|62->39|63->40
                    -- GENERATED --
                */
            