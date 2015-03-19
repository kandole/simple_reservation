package views.normalUser

import models._

object NUIndexHelper {
	
	def showTable(orderList: List[models.Order], fId: String): (String, Int) = {
		var oId: String = "none"
		var number: Int = 0
		for(o <- orderList) {
			if(o.food.equals(fId)) {
				number = o.number
				oId = o.id.toString
			}
		}
		(oId, number)
	}

	def onesMoney(or: OrderReal): Double = {
		var total: Double = 0.0 
		for ((f, n) <- or.food) {
			total += f.price * n
		}
		total
	}

	def totalMoney(orList: List[OrderReal]): Double = {
		var total: Double = 0.0
		for (or <- orList) {
			for ((f, n) <- or.food) {
				total += f.price * n
			}
		}
		total
	}

	def totalNum(orList: List[OrderReal]): Int = {
		var total: Int = 0
		for (or <- orList) {
			for ((f, n) <- or.food) {
				total += n
			}
		}
		total
	}

}