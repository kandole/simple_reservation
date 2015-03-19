package views

import models._
import play.api.templates.Html

object ViewHelper {
	
	def showActiveNav(nav: String): Html = {
		nav match {
			case "nav1" => {
				Html("""<li class="active"><a href="/admin">订单一览</a></li>
	      <li><a href="/RFmanager">饭店及菜品管理</a></li>
	      <li><a href="/orderRecords">订单记录</a></li>
	      <li><a href="/userManager">用户管理</a></li>""")
			}
			case "nav2" => {
				Html("""<li><a href="/admin">订单一览</a></li>
	      <li class="active"><a href="/RFmanager">饭店及菜品管理</a></li>
	      <li><a href="/orderRecords">订单记录</a></li>
	      <li><a href="/userManager">用户管理</a></li>""")
			}
			case "nav3" => {
				Html("""<li><a href="/admin">订单一览</a></li>
	      <li><a href="/RFmanager">饭店及菜品管理</a></li>
	      <li class="active"><a href="/orderRecords">订单记录</a></li>
	      <li><a href="/userManager">用户管理</a></li>""")
			}
			case "nav4" => {
				Html("""<li><a href="/admin">订单一览</a></li>
	      <li><a href="/RFmanager">饭店及菜品管理</a></li>
	      <li><a href="/orderRecords">订单记录</a></li>
	      <li class="active"><a href="/userManager">用户管理</a></li>""")
			}


		}
		
	}

	def showActiveNavForNU(nav: String, user: User): Html = {
		val balanceMessage = if(user.balance > 0) {
							"""<li class="nav-message disabled"><a href="#">账户余额 """ + user.balance + """ 元</a></li>"""
						  } else {
						  	"""<li class="nav-message-danger disabled"><a href="#">账户余额 """ + user.balance + """ 元</a></li>"""
						  }
		nav match {
			case "nav1" => {
				Html("""<ul class="nav pull-left">
					   	  <li class="active"><a href="/normalUser">今日推荐</a></li>
					   	  <li><a href="/showUserHistory">订餐历史</a></li>
					    </ul>
				    	<ul class="nav pull-right">
						  <li><a href="#userInfo" role="button" data-backdrop="true" data-toggle="modal">""" + user.name + """</a></li>""" +
					balanceMessage +
						  """<li><a href="/nuUpdatePasswd">修改密码</a></li>
						</ul>""")
			}
			case "nav-changePasswd" => {
				Html("""<ul class="nav pull-left">
					   	  <li><a href="/normalUser">今日推荐</a></li>
					   	  <li><a href="/showUserHistory">订餐历史</a></li>
					    </ul>
				    	<ul class="nav pull-right">
						  <li><a href="#userInfo" role="button" data-backdrop="true" data-toggle="modal">""" + user.name + """</a></li>""" +
					balanceMessage +
						  """<li class="active"><a href="/nuUpdatePasswd">修改密码</a></li>
						</ul>""")

			}
			case "nav-showHistory" => {
				Html("""<ul class="nav pull-left">
					   	  <li><a href="/normalUser">今日推荐</a></li>
					   	  <li class="active"><a href="/showUserHistory">订餐历史</a></li>
					    </ul>
				    	<ul class="nav pull-right">
						  <li><a href="#userInfo" role="button" data-backdrop="true" data-toggle="modal">""" + user.name + """</a></li>""" +
					balanceMessage +
						  """<li><a href="/nuUpdatePasswd">修改密码</a></li>
						</ul>""")
			}	
		}
		
	}

	def showStatusZHCN(status: String): String = {
		status match {
			case "finished" => "已完成"
			case "cancled" => "被取消"
			//submited
			case "open" => "已提交，待处理"
		}
	}

	def totalBalance(uList: List[User]) = {
		var total = 0.0;
		for (u <- uList) {
			total = total + u.balance
		}
		total
	}

}