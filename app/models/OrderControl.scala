package models

import com.novus.salat._
import com.novus.salat.dao.{ SalatDAO, ModelCompanion }
import com.novus.salat.annotations._
import com.mongodb.casbah.Imports._

import mongoContext._

import se.radley.plugin.salat._
import se.radley.plugin.salat.Binders._
import play.api.Play.current

//分为三种status:open，finished，cancled；其中finished，cancled都属于closed

case class OrderControl(
	@Key("_id") id: String,
	rId: String,
	status: String,
	endTime: String,
	date: String
)

object OrderControl extends ModelCompanion[OrderControl, ObjectId] {
	val collection = mongoCollection("OrderControl")
	val dao = new SalatDAO[OrderControl, ObjectId](collection = collection) {}
}