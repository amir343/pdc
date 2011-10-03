import akka.actor.Actor._

/**
 * @author Amir Moulavi
 */

case class Node(address:String = "localhost", port:Int = 2552)

object HPC {
  def main(args:Array[String]) {
    remote.start("localhost", 2552)
    val nodes:List[Node] =
      List (
        Node( port = 2552)
      )
    val masterActor = actorOf(new Master(nodes))
    masterActor.start()
    masterActor ! Calculate
  }
}