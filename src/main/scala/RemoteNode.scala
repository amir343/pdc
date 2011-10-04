
import akka.actor.Actor._

/**
 * @author Amir Moulavi
 */

object RemoteNode {
  def apply(ipAddress:String = "127.0.0.1") = {
    ipAddress match {
      case null => println("Failed to bring up the remote node. You have to specify IP address of this host")
      case m if m != null => remote.start(m, 2552)
    }
  }

}