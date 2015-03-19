package models

import com.novus.salat._
import com.novus.salat.dao.{ SalatDAO, ModelCompanion }
import com.novus.salat.annotations._
import com.mongodb.casbah.Imports._

import mongoContext._

import se.radley.plugin.salat._
import se.radley.plugin.salat.Binders._
import play.api.Play.current

case class Restaurant(
	@Key("_id") id: ObjectId = new ObjectId,
	name: String,
	isSeted: Boolean,
	phone1: String,
	phone2: String,
	others: String
	// pic: String
)

case class URestaurant(
	id: String,
	name: String,
	phone1: String,
	phone2: String,
	others: String
	// pic: String
)

object Restaurant extends ModelCompanion[Restaurant, ObjectId] {
	val collection = mongoCollection("Restaurant")
	val dao = new SalatDAO[Restaurant, ObjectId](collection = collection) {}
}