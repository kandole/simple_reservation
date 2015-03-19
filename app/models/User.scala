package models

import com.novus.salat._
import com.novus.salat.dao.{ SalatDAO, ModelCompanion }
import com.novus.salat.annotations._
import com.mongodb.casbah.Imports._

import mongoContext._

import se.radley.plugin.salat._
import se.radley.plugin.salat.Binders._
import play.api.Play.current

case class User(
	@Key("_id") id: ObjectId = new ObjectId,
	login_id: String,
	passwd: String, 
	name: String, 
	authority: String,
	balance: Double
	)

case class UUser(
	id: String,
	login_id: String, 
	name: String, 
	authority: String
	)

object User extends ModelCompanion[User, ObjectId] {
	val collection = mongoCollection("User")
	val dao = new SalatDAO[User, ObjectId](collection = collection) {}

	// def add(login_id: String, passwd: String, name: String, authority: String) = {
	// 	val u = MongoDBObject("login_id" -> login_id, "passwd" -> passwd, "name" -> name, "authority" -> authority)
	// 	dao.insert(u)
	// }
	// 登陆认证
	def authenticate(login_id: String, passwd: String, authority: String): Option[User] = {
		// println("login_id:" + login_id + " passwd: " + passwd + " authority: " + authority)
		val r: Option[User] = User.findOne(MongoDBObject("login_id" -> login_id, "passwd" -> passwd, "authority" -> authority))
		r
	}

	def checkPasswd(uId: String, passwd: String): Option[User] = {
		// println("passwd: " + passwd)
		User.findOne(MongoDBObject("_id" -> new ObjectId(uId), "passwd" -> passwd))

	}

}