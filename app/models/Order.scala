package models

import com.novus.salat._
import com.novus.salat.dao.{ SalatDAO, ModelCompanion }
import com.novus.salat.annotations._
import com.mongodb.casbah.Imports._

import mongoContext._
import org.joda.time._

import se.radley.plugin.salat._
import se.radley.plugin.salat.Binders._
import play.api.Play.current

case class Order(
	@Key("_id") id: ObjectId = new ObjectId,
	user: String,
	restaurant: String,
	food: String,
	date: String,
	number: Int,
	status: String
)

object Order extends ModelCompanion[Order, ObjectId] {
	val collection = mongoCollection("Order")
	val dao = new SalatDAO[Order, ObjectId](collection = collection) {}
}

class OrderReal(val user: User, val restaurant: Restaurant, val food: List[(Food, Int)]) {

}

case class OrderFinish(
	uIds: List[String],
	pays: List[String]
)

case class OrderHistory(
	id: String,
	food: Food,
	restaurant: Restaurant,
	num: Int,
	status: String,
	date: String
)