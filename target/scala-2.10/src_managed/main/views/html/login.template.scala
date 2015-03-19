
package views.html

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
object login extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[scala.Tuple3[String, String, String]],Flash,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(form: Form[(String, String, String)])(implicit flash: Flash):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.63*/("""

<!DOCTYPE html>

<html>
    <head>
        <title>DACOrder Login</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.54*/routes/*8.60*/.Assets.at("stylesheets/bootstrap.min.css"))),format.raw/*8.103*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*9.54*/routes/*9.60*/.Assets.at("stylesheets/main.css"))),format.raw/*9.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*10.59*/routes/*10.65*/.Assets.at("images/favicon.png"))),format.raw/*10.97*/("""">
        <script src=""""),_display_(Seq[Any](/*11.23*/routes/*11.29*/.Assets.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*11.74*/("""" type="text/javascript"></script>
        <!-- <script src=""""),_display_(Seq[Any](/*12.28*/routes/*12.34*/.Assets.at("javascripts/main.js"))),format.raw/*12.67*/("""" type="text/javascript"></script> -->
    </head>
    <body>
        <div class="container-fluid">
        <!-- <div class="keepCenter">   -->
        
            <form class="form-signin" action=""""),_display_(Seq[Any](/*18.48*/routes/*18.54*/.Application.authenticate)),format.raw/*18.79*/("""" method="post">
                <h1 class="form-signin-heading">
                        DAC Order
                </h1>
                <h3 class="form-signin-heading">
                        Just for 饭
                </h3>
            """),_display_(Seq[Any](/*25.14*/form/*25.18*/.globalError.map/*25.34*/ {error =>_display_(Seq[Any](format.raw/*25.44*/("""
                <div class="alert alert-error">"""),_display_(Seq[Any](/*26.49*/error/*26.54*/.message)),format.raw/*26.62*/("""</div>
            """)))})),format.raw/*27.14*/("""
            """),_display_(Seq[Any](/*28.14*/flash/*28.19*/.get("logoutSuccess").map/*28.44*/ {message =>_display_(Seq[Any](format.raw/*28.56*/("""
                <div class="alert alert-success">"""),_display_(Seq[Any](/*29.51*/message)),format.raw/*29.58*/("""</div>
            """)))})),format.raw/*30.14*/("""
                
                <div>
                    <label>登录名</label>
                    <div>
                        <input autofocus type="text" name="login_id" id="login_id" />
                    </div>
                </div>
                <div>
                    <label>密码</label>
                    <div>
                        <input type="password" name="passwd" id="passwd" />
                    </div>
                </div>
                <div>
                    <label>权限</label>
                    <div>
                        <label class="select">
                        <select name="authority" id="authority">
                          <option value ="普通用户">普通用户</option>
                          <option value ="管理员">管理员</option>
                        </select>
                        </label>
                        <button type="submit" class="btn btn-large">登录</button>
                    </div>
                </div>
            </form>
        <!-- </div> -->
        </div>
    </body>
</html>
"""))}
    }
    
    def render(form:Form[scala.Tuple3[String, String, String]],flash:Flash): play.api.templates.Html = apply(form)(flash)
    
    def f:((Form[scala.Tuple3[String, String, String]]) => (Flash) => play.api.templates.Html) = (form) => (flash) => apply(form)(flash)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jul 17 08:04:56 CST 2013
                    SOURCE: /opt/dacOrder.git/app/views/login.scala.html
                    HASH: 56ad3a5f1d3da5bd03c82dc0768b8a18af3bdfe3
                    MATRIX: 578->1|716->62|879->190|893->196|958->239|1049->295|1063->301|1118->335|1215->396|1230->402|1284->434|1345->459|1360->465|1427->510|1525->572|1540->578|1595->611|1831->811|1846->817|1893->842|2170->1083|2183->1087|2208->1103|2256->1113|2341->1162|2355->1167|2385->1175|2437->1195|2487->1209|2501->1214|2535->1239|2585->1251|2672->1302|2701->1309|2753->1329
                    LINES: 20->1|23->1|30->8|30->8|30->8|31->9|31->9|31->9|32->10|32->10|32->10|33->11|33->11|33->11|34->12|34->12|34->12|40->18|40->18|40->18|47->25|47->25|47->25|47->25|48->26|48->26|48->26|49->27|50->28|50->28|50->28|50->28|51->29|51->29|52->30
                    -- GENERATED --
                */
            