
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
object main extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(content: Html):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""

<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(Seq[Any](/*7.17*/title)),format.raw/*7.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.54*/routes/*8.60*/.Assets.at("stylesheets/bootstrap.min.css"))),format.raw/*8.103*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*9.54*/routes/*9.60*/.Assets.at("stylesheets/main.css"))),format.raw/*9.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*10.59*/routes/*10.65*/.Assets.at("images/favicon.png"))),format.raw/*10.97*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*11.54*/routes/*11.60*/.Assets.at("stylesheets/Pager.css"))),format.raw/*11.95*/("""" />
        <script src=""""),_display_(Seq[Any](/*12.23*/routes/*12.29*/.Assets.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*12.74*/("""" type="text/javascript"></script>
        <!-- <script src=""""),_display_(Seq[Any](/*13.28*/routes/*13.34*/.Assets.at("javascripts/main.js"))),format.raw/*13.67*/("""" type="text/javascript"></script> -->
        <script src=""""),_display_(Seq[Any](/*14.23*/routes/*14.29*/.Assets.at("javascripts/bootstrap.min.js"))),format.raw/*14.71*/("""" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">
            <div>
              <h1>DAC Order <small>Just for 饭</small></h1>
            </div>
        """),_display_(Seq[Any](/*21.10*/content)),format.raw/*21.17*/("""
        </div>
    </body>
</html>
"""))}
    }
    
    def render(title:String,content:Html): play.api.templates.Html = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.Html) = (title) => (content) => apply(title)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Oct 21 16:30:55 CST 2013
                    SOURCE: /opt/dacOrder.git/app/views/main.scala.html
                    HASH: 11a1481bcc4d00f6cda11a08b6a0769e58884ec0
                    MATRIX: 540->1|647->31|735->84|761->89|858->151|872->157|937->200|1028->256|1042->262|1097->296|1194->357|1209->363|1263->395|1355->451|1370->457|1427->492|1490->519|1505->525|1572->570|1670->632|1685->638|1740->671|1837->732|1852->738|1916->780|2147->975|2176->982
                    LINES: 20->1|23->1|29->7|29->7|30->8|30->8|30->8|31->9|31->9|31->9|32->10|32->10|32->10|33->11|33->11|33->11|34->12|34->12|34->12|35->13|35->13|35->13|36->14|36->14|36->14|43->21|43->21
                    -- GENERATED --
                */
            