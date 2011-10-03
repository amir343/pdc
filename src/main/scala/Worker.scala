import akka.actor.Actor

/**
 * @author Amir Moulavi
 */

class Worker extends Actor {

  println("Worker %s is started!".format(self.uuid))

  def receive = {
    case Calculation =>
      // TODO: do the calculation
      self.reply(Result)
  }

  def calculate(c:Calculation) {

  }
}