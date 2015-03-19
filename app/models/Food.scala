package models

import com.novus.salat._
import com.novus.salat.dao.{ SalatDAO, ModelCompanion }
import com.novus.salat.annotations._
import com.mongodb.casbah.Imports._

import mongoContext._

import se.radley.plugin.salat._
import se.radley.plugin.salat.Binders._
import play.api.Play.current

case class Food(
	@Key("_id") id: ObjectId = new ObjectId,
	name: String,
	price: Double,
	restaurant: String
)

object Food extends ModelCompanion[Food, ObjectId] {
	val collection = mongoCollection("Food")
	val dao = new SalatDAO[Food, ObjectId](collection = collection) {}
}

case class FoodOrder(
	name: String,
	num: Int,
	price: Double
)

