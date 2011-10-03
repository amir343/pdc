
/**
 * @author Amir
 */


sealed trait Message
case class Calculate() extends Message
case class Calculation() extends Message
case class Result() extends Message

