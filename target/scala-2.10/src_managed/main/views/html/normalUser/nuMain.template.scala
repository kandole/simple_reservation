
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
object nuMain extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[models.User,String,Html,Flash,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(user: models.User)(nav: String)(content: Html)(implicit flash: Flash):play.api.templates.Html = {
        _display_ {import helper._

import helper.twitterBootstrap._


Seq[Any](format.raw/*1.72*/("""

"""),format.raw/*5.1*/("""
	"""),_display_(Seq[Any](/*6.3*/nuNavbar(nav, user))),format.raw/*6.22*/("""
	"""),_display_(Seq[Any](/*7.3*/content)),format.raw/*7.10*/("""


	<!-- userInfo --> 
	<div id="userInfo" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="userInfoLabel" aria-hidden="true">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	    <h3>用户信息</h3>
	  </div>
	  <div class="modal-body"> 
	      <table class="table table-hover table-condensed">
	      	<tbody>
	      		<tr>
	      			<td>登录名</td>
	      			<td>"""),_display_(Seq[Any](/*21.16*/user/*21.20*/.login_id)),format.raw/*21.29*/("""</td>
	      		</tr>
	      		<tr>
	      			<td>姓名</td>
	      			<td>"""),_display_(Seq[Any](/*25.16*/user/*25.20*/.name)),format.raw/*25.25*/("""</td>
	      		</tr>
	      		<tr>
	      			<td>权限</td>
	      			<td>"""),_display_(Seq[Any](/*29.16*/user/*29.20*/.authority)),format.raw/*29.30*/("""</td>
	      		</tr>
	      		<tr>
	      			<td>账户余额</td>
	      			<td>"""),_display_(Seq[Any](/*33.16*/user/*33.20*/.balance)),format.raw/*33.28*/(""" 元</td>
	      		</tr>
	      	</tbody>
	      </table>
	  </div>
      <div class="modal-footer">
	    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
	  </div>
	</div>

	<!-- updatePasswd --> 
	<div id="updatePasswd" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="updatePasswdLabel" aria-hidden="true">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	    <h3>修改密码</h3>
	  </div>
	  <div class="modal-body"> 
	      <!-- remotePage -->
	  </div>
      <div class="modal-footer">
	    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
	  </div>
	</div>

	<!-- <button class="btn" id="testModel">testModel</button> -->

	<!-- 弹出式通知 -->

	"""),_display_(Seq[Any](/*61.3*/flash/*61.8*/.get("updatePWSuccess").map/*61.35*/ {message =>_display_(Seq[Any](format.raw/*61.47*/("""
	<div id="upSuccess" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="upSuccessLabel" aria-hidden="true">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	    
	  </div>
	  <div class="modal-body"> 
	      <h3 class="alert alert-success">"""),_display_(Seq[Any](/*68.41*/message)),format.raw/*68.48*/("""</h3>
	  </div>
      <div class="modal-footer">
	    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
	  </div>
	</div>
	<script type="text/javascript">
		$(document).ready(function()"""),format.raw/*75.31*/("""{"""),format.raw/*75.32*/("""
		  $('#upSuccess').modal("""),format.raw/*76.27*/("""{"""),format.raw/*76.28*/("""
		  	backdrop: false
		  """),format.raw/*78.5*/("""}"""),format.raw/*78.6*/(""")
		"""),format.raw/*79.3*/("""}"""),format.raw/*79.4*/(""");
	</script>
    """)))})),format.raw/*81.6*/("""
    """),_display_(Seq[Any](/*82.6*/flash/*82.11*/.get("noOrderOpen").map/*82.34*/ {message =>_display_(Seq[Any](format.raw/*82.46*/("""
	<div id="noOrderOpenM" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="noOrderOpenMLabel" aria-hidden="true">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	    
	  </div>
	  <div class="modal-body"> 
	      <h3 class="alert alert-success">"""),_display_(Seq[Any](/*89.41*/message)),format.raw/*89.48*/("""</h3>
	  </div>
      <div class="modal-footer">
	    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
	  </div>
	</div>
	<script type="text/javascript">
		$(document).ready(function()"""),format.raw/*96.31*/("""{"""),format.raw/*96.32*/("""
		  $('#noOrderOpenM').modal("""),format.raw/*97.30*/("""{"""),format.raw/*97.31*/("""
		  	backdrop: false
		  """),format.raw/*99.5*/("""}"""),format.raw/*99.6*/(""")
		"""),format.raw/*100.3*/("""}"""),format.raw/*100.4*/(""");
	</script>
    """)))})))}
    }
    
    def render(user:models.User,nav:String,content:Html,flash:Flash): play.api.templates.Html = apply(user)(nav)(content)(flash)
    
    def f:((models.User) => (String) => (Html) => (Flash) => play.api.templates.Html) = (user) => (nav) => (content) => (flash) => apply(user)(nav)(content)(flash)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jul 17 12:23:00 CST 2013
                    SOURCE: /opt/dacOrder.git/app/views/normalUser/nuMain.scala.html
                    HASH: 545fa9af56626c8a6eacd117e2bdcda69a4c473d
                    MATRIX: 571->1|768->71|796->124|833->127|873->146|910->149|938->156|1426->608|1439->612|1470->621|1578->693|1591->697|1618->702|1726->774|1739->778|1771->788|1881->862|1894->866|1924->874|2740->1655|2753->1660|2789->1687|2839->1699|3209->2033|3238->2040|3473->2247|3502->2248|3557->2275|3586->2276|3639->2302|3667->2303|3698->2307|3726->2308|3776->2327|3817->2333|3831->2338|3863->2361|3913->2373|4289->2713|4318->2720|4553->2927|4582->2928|4640->2958|4669->2959|4722->2985|4750->2986|4782->2990|4811->2991
                    LINES: 20->1|26->1|28->5|29->6|29->6|30->7|30->7|44->21|44->21|44->21|48->25|48->25|48->25|52->29|52->29|52->29|56->33|56->33|56->33|84->61|84->61|84->61|84->61|91->68|91->68|98->75|98->75|99->76|99->76|101->78|101->78|102->79|102->79|104->81|105->82|105->82|105->82|105->82|112->89|112->89|119->96|119->96|120->97|120->97|122->99|122->99|123->100|123->100
                    -- GENERATED --
                */
            