
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
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template7[String,User,models.Restaurant,List[models.Food],List[models.Order],String,Flash,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(user: User)(r: models.Restaurant)(fList: List[models.Food])(orderList: List[models.Order])(endTime: String)(implicit flash: Flash):play.api.templates.Html = {
        _display_ {import views.normalUser.NUIndexHelper


Seq[Any](format.raw/*1.148*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/main(title)/*4.13*/ {_display_(Seq[Any](format.raw/*4.15*/("""
	"""),_display_(Seq[Any](/*5.3*/nuMain(user)/*5.15*/("nav1")/*5.23*/ {_display_(Seq[Any](format.raw/*5.25*/("""
	<table class="table">
		<caption>
			饭店：<a href="#rInfo" role="button" data-backdrop="true" data-toggle="modal">"""),_display_(Seq[Any](/*8.80*/r/*8.81*/.name)),format.raw/*8.86*/("""</a>
			<p class="text-warning">本次订餐截止时间：<strong>"""),_display_(Seq[Any](/*9.46*/endTime)),format.raw/*9.53*/("""</strong></p>
		</caption>
		<thead>
			<tr>
				<th>菜品</th>
				<th>价格</th>
				<th>数量</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			"""),_display_(Seq[Any](/*20.5*/for(f <- fList) yield /*20.20*/ {_display_(Seq[Any](format.raw/*20.22*/("""
			<form action="/orderFood" method="post">
				<input type="hidden" name="uId" value=""""),_display_(Seq[Any](/*22.45*/user/*22.49*/.id.toString)),format.raw/*22.61*/("""" />
				<input type="hidden" name="rId" value=""""),_display_(Seq[Any](/*23.45*/r/*23.46*/.id.toString)),format.raw/*23.58*/("""" />
				<input type="hidden" name="fId" value=""""),_display_(Seq[Any](/*24.45*/f/*24.46*/.id.toString)),format.raw/*24.58*/("""" />
				<input type="hidden" name="status" value="open" />
			<tr>
				<td>"""),_display_(Seq[Any](/*27.10*/f/*27.11*/.name)),format.raw/*27.16*/("""</td>
				<td>"""),_display_(Seq[Any](/*28.10*/f/*28.11*/.price)),format.raw/*28.17*/(""" 元</td>
				
					"""),_display_(Seq[Any](/*30.7*/if(!orderList.isEmpty)/*30.29*/{_display_(Seq[Any](format.raw/*30.30*/("""
						"""),_display_(Seq[Any](/*31.8*/defining(NUIndexHelper.showTable(orderList, f.id.toString))/*31.67*/ { t =>_display_(Seq[Any](format.raw/*31.74*/("""
							"""),_display_(Seq[Any](/*32.9*/if(t._1 != "none")/*32.27*/ {_display_(Seq[Any](format.raw/*32.29*/("""
								<td>
									<select class="input-mini" disabled="disabled" name="number">
								   	  <option>"""),_display_(Seq[Any](/*35.24*/t/*35.25*/._2)),format.raw/*35.28*/("""</option>
									</select>
								</td>
								<td>
									<a id="btn-ordered" class="btn btn-success" data-toggle="tooltip" data-placement="left" title="点击取消" href="/cancleOrder?oId="""),_display_(Seq[Any](/*39.135*/t/*39.136*/._1)),format.raw/*39.139*/("""">已订</a>
									<script type="text/javascript">
										$(document).ready(function()"""),format.raw/*41.39*/("""{"""),format.raw/*41.40*/("""
											$('#btn-ordered').mouseover(function()"""),format.raw/*42.50*/("""{"""),format.raw/*42.51*/("""
												$(this).tooltip('show')
											"""),format.raw/*44.12*/("""}"""),format.raw/*44.13*/(""")
										"""),format.raw/*45.11*/("""}"""),format.raw/*45.12*/(""")
									</script>
								</th>
							""")))}/*48.10*/else/*48.15*/{_display_(Seq[Any](format.raw/*48.16*/("""
								<td>
									<select class="input-mini" name="number">
								   	  <option>1</option>
									  <option>2</option>
									  <option>3</option>
									  <option>4</option>
									  <option>5</option>
									</select>
								</td>
								<td><button type="submit" class="btn">订餐</button></th>
							""")))})),format.raw/*59.9*/("""
						""")))})),format.raw/*60.8*/("""
					""")))}/*61.8*/else/*61.13*/{_display_(Seq[Any](format.raw/*61.14*/("""
						<td>
							<select class="input-mini" name="number">
						   	  <option>1</option>
							  <option>2</option>
							  <option>3</option>
							  <option>4</option>
							  <option>5</option>
							</select>
						</td>
						<td><button type="submit" class="btn">订餐</button></th>
					""")))})),format.raw/*72.7*/("""
				
			</tr>
			</form>
			""")))})),format.raw/*76.5*/("""
		</tbody>
	</table>

	<!-- rInfo --> 
	<div id="rInfo" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="rInfoLabel" aria-hidden="true">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	    <h3>饭店信息</h3>
	  </div>
	  <div class="modal-body"> 
	      <table class="table table-hover table-condensed">
	      	<tbody>
	      		<tr>
	      			<td>名称</td>
	      			<td>"""),_display_(Seq[Any](/*91.16*/r/*91.17*/.name)),format.raw/*91.22*/("""</td>
	      		</tr>
	      		<tr>
	      			<td>电话</td>
	      			<td>
	      				<p>"""),_display_(Seq[Any](/*96.16*/r/*96.17*/.phone1)),format.raw/*96.24*/("""</p>
	      				<p>"""),_display_(Seq[Any](/*97.16*/r/*97.17*/.phone2)),format.raw/*97.24*/("""</p>
	      			</td>
	      		</tr>
	      		<tr>
	      			<td>备注</td>
	      			<td>"""),_display_(Seq[Any](/*102.16*/r/*102.17*/.others)),format.raw/*102.24*/("""</td>
	      		</tr>
	      	</tbody>
	      </table>
	  </div>
      <div class="modal-footer">
	    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
	  </div>
	</div>
	
	""")))}/*112.3*/(flash))),format.raw/*112.10*/("""
""")))})))}
    }
    
    def render(title:String,user:User,r:models.Restaurant,fList:List[models.Food],orderList:List[models.Order],endTime:String,flash:Flash): play.api.templates.Html = apply(title)(user)(r)(fList)(orderList)(endTime)(flash)
    
    def f:((String) => (User) => (models.Restaurant) => (List[models.Food]) => (List[models.Order]) => (String) => (Flash) => play.api.templates.Html) = (title) => (user) => (r) => (fList) => (orderList) => (endTime) => (flash) => apply(title)(user)(r)(fList)(orderList)(endTime)(flash)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jul 17 08:04:58 CST 2013
                    SOURCE: /opt/dacOrder.git/app/views/normalUser/index.scala.html
                    HASH: 37f00d2f78daf14106117baf929fceedc9c80177
                    MATRIX: 620->1|882->147|909->187|945->189|964->200|1003->202|1040->205|1060->217|1076->225|1115->227|1265->342|1274->343|1300->348|1385->398|1413->405|1591->548|1622->563|1662->565|1787->654|1800->658|1834->670|1919->719|1929->720|1963->732|2048->781|2058->782|2092->794|2205->871|2215->872|2242->877|2293->892|2303->893|2331->899|2385->918|2416->940|2455->941|2498->949|2566->1008|2611->1015|2655->1024|2682->1042|2722->1044|2866->1152|2876->1153|2901->1156|3128->1346|3139->1347|3165->1350|3281->1438|3310->1439|3388->1489|3417->1490|3493->1538|3522->1539|3562->1551|3591->1552|3653->1596|3666->1601|3705->1602|4058->1924|4097->1932|4122->1940|4135->1945|4174->1946|4505->2246|4566->2276|5064->2738|5074->2739|5101->2744|5224->2831|5234->2832|5263->2839|5319->2859|5329->2860|5358->2867|5482->2954|5493->2955|5523->2962|5738->3158|5768->3165
                    LINES: 20->1|24->1|25->3|26->4|26->4|26->4|27->5|27->5|27->5|27->5|30->8|30->8|30->8|31->9|31->9|42->20|42->20|42->20|44->22|44->22|44->22|45->23|45->23|45->23|46->24|46->24|46->24|49->27|49->27|49->27|50->28|50->28|50->28|52->30|52->30|52->30|53->31|53->31|53->31|54->32|54->32|54->32|57->35|57->35|57->35|61->39|61->39|61->39|63->41|63->41|64->42|64->42|66->44|66->44|67->45|67->45|70->48|70->48|70->48|81->59|82->60|83->61|83->61|83->61|94->72|98->76|113->91|113->91|113->91|118->96|118->96|118->96|119->97|119->97|119->97|124->102|124->102|124->102|134->112|134->112
                    -- GENERATED --
                */
            