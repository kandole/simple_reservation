
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
object RFmanager extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[String,List[models.Restaurant],models.OrderControl,Flash,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(rList: List[models.Restaurant])(oc: models.OrderControl)(implicit flash: Flash):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.97*/("""


"""),_display_(Seq[Any](/*4.2*/main(title)/*4.13*/ {_display_(Seq[Any](format.raw/*4.15*/("""
	"""),_display_(Seq[Any](/*5.3*/adminNavbar("nav2"))),format.raw/*5.22*/("""

	<!-- <div class="row"> -->
		<a class="btn btn-primary" href=""""),_display_(Seq[Any](/*8.37*/routes/*8.43*/.Admin.saveRestaurant)),format.raw/*8.64*/("""">添加饭店</a>
	<!-- </div> -->

	"""),_display_(Seq[Any](/*11.3*/flash/*11.8*/.get("updateRestaurantSuccess").map/*11.43*/ {message =>_display_(Seq[Any](format.raw/*11.55*/("""
        <div class="alert alert-success">"""),_display_(Seq[Any](/*12.43*/message)),format.raw/*12.50*/("""</div>
    """)))})),format.raw/*13.6*/("""
    """),_display_(Seq[Any](/*14.6*/flash/*14.11*/.get("noRestaurantSeted").map/*14.40*/ {message =>_display_(Seq[Any](format.raw/*14.52*/("""
        <div class="alert alert-success">"""),_display_(Seq[Any](/*15.43*/message)),format.raw/*15.50*/("""</div>
    """)))})),format.raw/*16.6*/("""

	<!-- <div class="row"> -->
		<table class="table">
			<caption>饭店列表</caption>
			<thead>
				<tr>
					<th>饭店名</th>
					<th>电话</th>
					<th>备注</th>
					<th>操作</th>
					<th>今日指定</th>
				</tr>
			</thead>
			<tbody>
				"""),_display_(Seq[Any](/*31.6*/for(r <- rList) yield /*31.21*/ {_display_(Seq[Any](format.raw/*31.23*/("""
					"""),_display_(Seq[Any](/*32.7*/if(r.isSeted == false)/*32.29*/ {_display_(Seq[Any](format.raw/*32.31*/("""
					<tr>
						<td>
							<a href="/showFood?rId="""),_display_(Seq[Any](/*35.32*/r/*35.33*/.id.toString)),format.raw/*35.45*/("""">"""),_display_(Seq[Any](/*35.48*/r/*35.49*/.name)),format.raw/*35.54*/("""</a>
						</td>
						<td>
							<p>"""),_display_(Seq[Any](/*38.12*/r/*38.13*/.phone1)),format.raw/*38.20*/("""</p>
							<p>"""),_display_(Seq[Any](/*39.12*/r/*39.13*/.phone2)),format.raw/*39.20*/("""</p>
						</td>
						<td>
							<p>"""),_display_(Seq[Any](/*42.12*/r/*42.13*/.others)),format.raw/*42.20*/("""</p>
						</td>
						<td>
							<a class="btn btn-warning" href="/updateRestaurant?rId="""),_display_(Seq[Any](/*45.64*/r/*45.65*/.id.toString)),format.raw/*45.77*/("""">修改</a>
							<a id="deleteRLink_"""),_display_(Seq[Any](/*46.28*/r/*46.29*/.id.toString)),format.raw/*46.41*/("""" class="btn btn-danger" href="#">删除</a>
							<script type="text/javascript">
								$(document).ready(function()"""),format.raw/*48.37*/("""{"""),format.raw/*48.38*/("""
								  $('#deleteRLink_"""),_display_(Seq[Any](/*49.28*/r/*49.29*/.id.toString)),format.raw/*49.41*/("""').click(function()"""),format.raw/*49.60*/("""{"""),format.raw/*49.61*/("""
								  	var r = confirm("确定要删除该饭店？")
								  	if (r==true) """),format.raw/*51.25*/("""{"""),format.raw/*51.26*/("""
								  		window.location.href = "/deleteRestaurant?rId="""),_display_(Seq[Any](/*52.60*/r/*52.61*/.id.toString)),format.raw/*52.73*/(""""
								  	"""),format.raw/*53.12*/("""}"""),format.raw/*53.13*/("""

								  """),format.raw/*55.11*/("""}"""),format.raw/*55.12*/(""")
								"""),format.raw/*56.9*/("""}"""),format.raw/*56.10*/(""");
							</script>
						</td>
						"""),_display_(Seq[Any](/*59.8*/if(oc.status == "open")/*59.31*/ {_display_(Seq[Any](format.raw/*59.33*/("""
							<td><a class="btn disabled" href="#">指定</a></td>
						""")))}/*61.9*/else/*61.14*/{_display_(Seq[Any](format.raw/*61.15*/("""
							<td><a class="btn" href="/setRestaurant?rId="""),_display_(Seq[Any](/*62.53*/r/*62.54*/.id.toString)),format.raw/*62.66*/("""">指定</a></td>
						""")))})),format.raw/*63.8*/("""
							
					</tr>
					""")))}/*66.8*/else/*66.13*/{_display_(Seq[Any](format.raw/*66.14*/("""
						"""),_display_(Seq[Any](/*67.8*/if(oc.status == "open")/*67.31*/ {_display_(Seq[Any](format.raw/*67.33*/("""
							<tr>
								<td>
									<a href="/justShowFood?rId="""),_display_(Seq[Any](/*70.38*/r/*70.39*/.id.toString)),format.raw/*70.51*/("""">"""),_display_(Seq[Any](/*70.54*/r/*70.55*/.name)),format.raw/*70.60*/("""</a>
								</td>
								<td>
									<p>"""),_display_(Seq[Any](/*73.14*/r/*73.15*/.phone1)),format.raw/*73.22*/("""</p>
									<p>"""),_display_(Seq[Any](/*74.14*/r/*74.15*/.phone2)),format.raw/*74.22*/("""</p>
								</td>
								<td>
									<p>"""),_display_(Seq[Any](/*77.14*/r/*77.15*/.others)),format.raw/*77.22*/("""</p>
								</td>
								<td>
									<a class="btn btn-warning disabled" href="#">修改</a>
									<a class="btn btn-danger disabled" href="#">删除</a>
								</td>
								<td><a class="btn btn-success disabled" href="#">已指定</a></td>
							</tr>
						""")))}/*85.9*/else/*85.14*/{_display_(Seq[Any](format.raw/*85.15*/("""
							<tr>
								<td>
									<a href="/showFood?rId="""),_display_(Seq[Any](/*88.34*/r/*88.35*/.id.toString)),format.raw/*88.47*/("""">"""),_display_(Seq[Any](/*88.50*/r/*88.51*/.name)),format.raw/*88.56*/("""</a>
								</td>
								<td>
									<p>"""),_display_(Seq[Any](/*91.14*/r/*91.15*/.phone1)),format.raw/*91.22*/("""</p>
									<p>"""),_display_(Seq[Any](/*92.14*/r/*92.15*/.phone2)),format.raw/*92.22*/("""</p>
								</td>
								<td>
									<p>"""),_display_(Seq[Any](/*95.14*/r/*95.15*/.others)),format.raw/*95.22*/("""</p>
								</td>
								<td>
									<a class="btn btn-warning" href="/updateRestaurant?rId="""),_display_(Seq[Any](/*98.66*/r/*98.67*/.id.toString)),format.raw/*98.79*/("""">修改</a>
									<a id="deleteRLink_"""),_display_(Seq[Any](/*99.30*/r/*99.31*/.id.toString)),format.raw/*99.43*/("""" class="btn btn-danger" href="#">删除</a>
									<script type="text/javascript">
										$(document).ready(function()"""),format.raw/*101.39*/("""{"""),format.raw/*101.40*/("""
										  $('#deleteRLink_"""),_display_(Seq[Any](/*102.30*/r/*102.31*/.id.toString)),format.raw/*102.43*/("""').click(function()"""),format.raw/*102.62*/("""{"""),format.raw/*102.63*/("""
										  	var r = confirm("确定要删除该饭店？")
										  	if (r==true) """),format.raw/*104.27*/("""{"""),format.raw/*104.28*/("""
										  		window.location.href = "/deleteRestaurant?rId="""),_display_(Seq[Any](/*105.62*/r/*105.63*/.id.toString)),format.raw/*105.75*/(""""
										  	"""),format.raw/*106.14*/("""}"""),format.raw/*106.15*/("""

										  """),format.raw/*108.13*/("""}"""),format.raw/*108.14*/(""")
										"""),format.raw/*109.11*/("""}"""),format.raw/*109.12*/(""");
									</script>
								</td>
								<td><a class="btn btn-success disabled" href="#">已指定</a></td>
							</tr>

						""")))})),format.raw/*115.8*/("""

					""")))})),format.raw/*117.7*/("""
				""")))})),format.raw/*118.6*/("""
			</tbody>
		</table>
	<!-- </div> -->
	<!-- <div class="row"> -->
		"""),_display_(Seq[Any](/*123.4*/if(oc.status == "open")/*123.27*/ {_display_(Seq[Any](format.raw/*123.29*/("""
		<div class="input-prepend input-append">
			<span class="add-on">订饭截止时间</span>
			<div class="input-prepend input-append">
				<select class="input-mini" disabled="disabled">
					<option>"""),_display_(Seq[Any](/*128.15*/oc/*128.17*/.endTime.split(':')/*128.36*/(0))),format.raw/*128.39*/("""</option>
				</select>
				<span class="add-on">时</span>
				<div class="input-append">
					<select class="input-mini" disabled="disabled">
						<option>"""),_display_(Seq[Any](/*133.16*/oc/*133.18*/.endTime.split(':')/*133.37*/(1))),format.raw/*133.40*/("""</option>
					</select>
					<span class="add-on">分</span>
				</div>
			</div>
			<a id="closeOrder" class="btn btn-danger" href="#">关闭订饭</a>
		</div>
		
		<script type="text/javascript">
			$(document).ready(function()"""),format.raw/*142.32*/("""{"""),format.raw/*142.33*/("""
			  $('#closeOrder').click(function()"""),format.raw/*143.39*/("""{"""),format.raw/*143.40*/("""
			  	var r = confirm("还未划账，确定要关闭订饭？")
			  	if (r==true) """),format.raw/*145.20*/("""{"""),format.raw/*145.21*/("""
			  		window.location.href = "/orderOpenControl?status=open&endTime=off"
			  	"""),format.raw/*147.7*/("""}"""),format.raw/*147.8*/("""

			  """),format.raw/*149.6*/("""}"""),format.raw/*149.7*/(""")
			"""),format.raw/*150.4*/("""}"""),format.raw/*150.5*/(""");
		</script>
		""")))}/*152.5*/else/*152.10*/{_display_(Seq[Any](format.raw/*152.11*/("""
		<div class="input-prepend input-append">
			<span class="add-on">订饭截止时间</span>
			<div class="input-prepend input-append">
				<select id="hour" class="input-mini">
					"""),_display_(Seq[Any](/*157.7*/for(i <- 8 to 12 ) yield /*157.25*/ {_display_(Seq[Any](format.raw/*157.27*/("""
						"""),_display_(Seq[Any](/*158.8*/if(i < 10)/*158.18*/ {_display_(Seq[Any](format.raw/*158.20*/("""
							<option>0"""),_display_(Seq[Any](/*159.18*/i)),format.raw/*159.19*/("""</option>
						""")))}/*160.9*/else/*160.14*/{_display_(Seq[Any](format.raw/*160.15*/("""
							"""),_display_(Seq[Any](/*161.9*/if(i == 10)/*161.20*/ {_display_(Seq[Any](format.raw/*161.22*/("""
								<option selected="selected">10</option>
							""")))}/*163.10*/else/*163.15*/{_display_(Seq[Any](format.raw/*163.16*/("""
								<option>"""),_display_(Seq[Any](/*164.18*/i)),format.raw/*164.19*/("""</option>
							""")))})),format.raw/*165.9*/("""
						""")))})),format.raw/*166.8*/("""
					""")))})),format.raw/*167.7*/("""	
				</select>
				<span class="add-on">时</span>
				<div class="input-append">
					<select id="minute" class="input-mini">
						"""),_display_(Seq[Any](/*172.8*/for(i <- 0 to 50 if (i % 10 == 0)) yield /*172.42*/ {_display_(Seq[Any](format.raw/*172.44*/("""
							"""),_display_(Seq[Any](/*173.9*/if(i < 10)/*173.19*/ {_display_(Seq[Any](format.raw/*173.21*/("""
								<option>0"""),_display_(Seq[Any](/*174.19*/i)),format.raw/*174.20*/("""</option>
							""")))}/*175.10*/else/*175.15*/{_display_(Seq[Any](format.raw/*175.16*/("""
								<option>"""),_display_(Seq[Any](/*176.18*/i)),format.raw/*176.19*/("""</option>
							""")))})),format.raw/*177.9*/("""
						""")))})),format.raw/*178.8*/("""	
					</select>
					<span class="add-on">分</span>
				</div>
			</div>
			<a id="openOrder" class="btn btn-success" href="#">开启订饭</a>
			<script type="text/javascript">
				$(document).ready(function()"""),format.raw/*185.33*/("""{"""),format.raw/*185.34*/("""
				  $('#openOrder').click(function()"""),format.raw/*186.39*/("""{"""),format.raw/*186.40*/("""
				  	var hour = $('#hour').val()
				  	var minute = $('#minute').val()
				  	var time = hour + ':' + minute
				  	// alert("endTime:" + time)
				  	window.location.href = "/orderOpenControl?status=closed&endTime=" + time
				  """),format.raw/*192.7*/("""}"""),format.raw/*192.8*/(""")
				"""),format.raw/*193.5*/("""}"""),format.raw/*193.6*/(""");
			</script>
		</div>
		""")))})),format.raw/*196.4*/("""
	<!-- </div> -->


		

""")))})))}
    }
    
    def render(title:String,rList:List[models.Restaurant],oc:models.OrderControl,flash:Flash): play.api.templates.Html = apply(title)(rList)(oc)(flash)
    
    def f:((String) => (List[models.Restaurant]) => (models.OrderControl) => (Flash) => play.api.templates.Html) = (title) => (rList) => (oc) => (flash) => apply(title)(rList)(oc)(flash)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jul 17 12:23:03 CST 2013
                    SOURCE: /opt/dacOrder.git/app/views/admin/RFmanager.scala.html
                    HASH: cf99a73ebe857bf1099c74e44ffd4f90f38a6b66
                    MATRIX: 596->1|768->96|806->100|825->111|864->113|901->116|941->135|1042->201|1056->207|1098->228|1164->259|1177->264|1221->299|1271->311|1350->354|1379->361|1422->373|1463->379|1477->384|1515->413|1565->425|1644->468|1673->475|1716->487|1978->714|2009->729|2049->731|2091->738|2122->760|2162->762|2251->815|2261->816|2295->828|2334->831|2344->832|2371->837|2446->876|2456->877|2485->884|2537->900|2547->901|2576->908|2651->947|2661->948|2690->955|2817->1046|2827->1047|2861->1059|2933->1095|2943->1096|2977->1108|3121->1224|3150->1225|3214->1253|3224->1254|3258->1266|3305->1285|3334->1286|3427->1351|3456->1352|3552->1412|3562->1413|3596->1425|3637->1438|3666->1439|3706->1451|3735->1452|3772->1462|3801->1463|3875->1502|3907->1525|3947->1527|4029->1592|4042->1597|4081->1598|4170->1651|4180->1652|4214->1664|4266->1685|4310->1712|4323->1717|4362->1718|4405->1726|4437->1749|4477->1751|4576->1814|4586->1815|4620->1827|4659->1830|4669->1831|4696->1836|4777->1881|4787->1882|4816->1889|4870->1907|4880->1908|4909->1915|4990->1960|5000->1961|5029->1968|5304->2226|5317->2231|5356->2232|5451->2291|5461->2292|5495->2304|5534->2307|5544->2308|5571->2313|5652->2358|5662->2359|5691->2366|5745->2384|5755->2385|5784->2392|5865->2437|5875->2438|5904->2445|6037->2542|6047->2543|6081->2555|6155->2593|6165->2594|6199->2606|6348->2726|6378->2727|6445->2757|6456->2758|6491->2770|6539->2789|6569->2790|6667->2859|6697->2860|6796->2922|6807->2923|6842->2935|6886->2950|6916->2951|6959->2965|6989->2966|7030->2978|7060->2979|7219->3106|7259->3114|7297->3120|7405->3192|7438->3215|7479->3217|7708->3409|7720->3411|7749->3430|7775->3433|7969->3590|7981->3592|8010->3611|8036->3614|8286->3835|8316->3836|8384->3875|8414->3876|8502->3935|8532->3936|8641->4017|8670->4018|8705->4025|8734->4026|8767->4031|8796->4032|8833->4051|8847->4056|8887->4057|9097->4231|9132->4249|9173->4251|9217->4259|9237->4269|9278->4271|9333->4289|9357->4290|9393->4308|9407->4313|9447->4314|9492->4323|9513->4334|9554->4336|9631->4394|9645->4399|9685->4400|9740->4418|9764->4419|9814->4437|9854->4445|9893->4452|10062->4585|10113->4619|10154->4621|10199->4630|10219->4640|10260->4642|10316->4661|10340->4662|10378->4681|10392->4686|10432->4687|10487->4705|10511->4706|10561->4724|10601->4732|10833->4935|10863->4936|10931->4975|10961->4976|11223->5210|11252->5211|11286->5217|11315->5218|11375->5246
                    LINES: 20->1|23->1|26->4|26->4|26->4|27->5|27->5|30->8|30->8|30->8|33->11|33->11|33->11|33->11|34->12|34->12|35->13|36->14|36->14|36->14|36->14|37->15|37->15|38->16|53->31|53->31|53->31|54->32|54->32|54->32|57->35|57->35|57->35|57->35|57->35|57->35|60->38|60->38|60->38|61->39|61->39|61->39|64->42|64->42|64->42|67->45|67->45|67->45|68->46|68->46|68->46|70->48|70->48|71->49|71->49|71->49|71->49|71->49|73->51|73->51|74->52|74->52|74->52|75->53|75->53|77->55|77->55|78->56|78->56|81->59|81->59|81->59|83->61|83->61|83->61|84->62|84->62|84->62|85->63|88->66|88->66|88->66|89->67|89->67|89->67|92->70|92->70|92->70|92->70|92->70|92->70|95->73|95->73|95->73|96->74|96->74|96->74|99->77|99->77|99->77|107->85|107->85|107->85|110->88|110->88|110->88|110->88|110->88|110->88|113->91|113->91|113->91|114->92|114->92|114->92|117->95|117->95|117->95|120->98|120->98|120->98|121->99|121->99|121->99|123->101|123->101|124->102|124->102|124->102|124->102|124->102|126->104|126->104|127->105|127->105|127->105|128->106|128->106|130->108|130->108|131->109|131->109|137->115|139->117|140->118|145->123|145->123|145->123|150->128|150->128|150->128|150->128|155->133|155->133|155->133|155->133|164->142|164->142|165->143|165->143|167->145|167->145|169->147|169->147|171->149|171->149|172->150|172->150|174->152|174->152|174->152|179->157|179->157|179->157|180->158|180->158|180->158|181->159|181->159|182->160|182->160|182->160|183->161|183->161|183->161|185->163|185->163|185->163|186->164|186->164|187->165|188->166|189->167|194->172|194->172|194->172|195->173|195->173|195->173|196->174|196->174|197->175|197->175|197->175|198->176|198->176|199->177|200->178|207->185|207->185|208->186|208->186|214->192|214->192|215->193|215->193|218->196
                    -- GENERATED --
                */
            