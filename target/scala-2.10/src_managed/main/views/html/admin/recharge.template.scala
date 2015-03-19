
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
object recharge extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,models.User,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(user: models.User):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.36*/("""

"""),_display_(Seq[Any](/*3.2*/main(title)/*3.13*/ {_display_(Seq[Any](format.raw/*3.15*/("""

    """),_display_(Seq[Any](/*5.6*/adminNavbar("nav4"))),format.raw/*5.25*/("""
        
        <form class="form-sub" action="/recharge" method="post">
            <p>用户： """),_display_(Seq[Any](/*8.21*/user/*8.25*/.name)),format.raw/*8.30*/("""</p>
            <div class="control-group">
                <label class="control-label" for="balance">当前金额</label>
                <div class="controls input-append">
                    <span class="uneditable-input">"""),_display_(Seq[Any](/*12.53*/user/*12.57*/.balance)),format.raw/*12.65*/("""</span>
                    <span class="add-on">元</span>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="reMoney">充值金额</label>
                <div class="controls input-append">
                	<input type="hidden" name="uId" value=""""),_display_(Seq[Any](/*19.58*/user/*19.62*/.id.toString)),format.raw/*19.74*/("""" />
                    <input autofocus type="text" name="reMoney" id="reMoney" />
                    <span class="add-on">元</span>
                </div>
            </div>
            <button class="btn btn-primary" type="submit">充值</button>
            <a class="btn" href="javascript:;" onClick="javascript:history.back(-1)">返回</a>
        </form>

""")))})),format.raw/*28.2*/(""" """))}
    }
    
    def render(title:String,user:models.User): play.api.templates.Html = apply(title)(user)
    
    def f:((String) => (models.User) => play.api.templates.Html) = (title) => (user) => apply(title)(user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jul 17 08:05:00 CST 2013
                    SOURCE: /opt/dacOrder.git/app/views/admin/recharge.scala.html
                    HASH: 8ebbac486bfc11414781183ec5c38cb13629ec6a
                    MATRIX: 557->1|668->35|705->38|724->49|763->51|804->58|844->77|974->172|986->176|1012->181|1269->402|1282->406|1312->414|1669->735|1682->739|1716->751|2104->1108
                    LINES: 20->1|23->1|25->3|25->3|25->3|27->5|27->5|30->8|30->8|30->8|34->12|34->12|34->12|41->19|41->19|41->19|50->28
                    -- GENERATED --
                */
            