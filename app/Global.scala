import play.api._
import models._
import com.mongodb.casbah.Imports._
import org.joda.time._

object Global extends GlobalSettings {

  override def onStart(app: Application) {
    Logger.info("Application has started")
    val ocOption = OrderControl.findOne(MongoDBObject("status" -> "closed"))
    ocOption match {
    	case Some(oc) => {
    		val oc = OrderControl("oc001", "", "closed", "off", LocalDate.now().toString)
		    OrderControl.save(oc)
		    Logger.info("New oc001 has saved")
    	}
    	case None => {
    		Logger.info("oc001 has existed.")
    	}
    }
    
  }  
  
  override def onStop(app: Application) {
    Logger.info("Application shutdown...")
  }  
    
}

// object InitialData {
// 	def setCache() = {
// 		val cp = new EhCachePlugin(current)
// 		cp.api.set("orderIsOpen", false, 0)
// 		cp
// 	}
// }
