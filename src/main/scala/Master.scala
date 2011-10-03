import akka.actor.{PoisonPill, ActorRef, Actor}

/**
 * @author Amir Moulavi
 */

class Master(val nodes:List[Node]) extends Actor {

  require ( nodes.size != 0 )

  val timeout:Long = 5000

  println("Master is started!")

  val actors : List[ActorRef] =
    (for {
      node <- nodes
      val actor = self.spawnRemote[Worker](node.address, node.port, timeout)
    } yield actor).toList

  def receive = {

    case Calculate =>
      for { actor <- actors } actor ! Calculation

    case Result =>
      println("Received result")
      self.reply(PoisonPill)
      self.stop()
  }

}
