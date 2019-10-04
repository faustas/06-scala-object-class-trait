import io.circe._
import io.circe.generic.semiauto._

/**
 * A simple trait that is the parent of a diversity of informations.
 */
sealed trait Level

object LevelTypes {
  /**
   * A normal info.
   */
  final case object Info extends Level
  /**
   * A warning info.
   */
  final case object Warning extends Level
  /**
   * An error info.
   */
  final case object Error extends Level
}

/**
 * A trait that just defines a title of the objects.
 */
trait Thing {
  def title: String
}

/**
 * A human person where the title is equal to the family name.
 *
 * @param title The family name of the human person.
 * @param age   The age of the person in years.
 */
final case class Human(title: String, age: Int) extends Thing

/**
 * An animal where the title is the species of the animal.
 *
 * @param title The species of the animal.
 * @param name  The name of the animal that was given by a human person.
 */
final case class Animal(title: String, name: String) extends Thing

/**
 * A car where the name is the type name of the car.
 *
 * @param title  The type name of the car.
 */
final case class Car(title: String) extends Thing

/**
 * Object singleton
 */
object Thing {

  /**
   * Method that prints the title of the Thing.
   *
   * @param t An object of the Thing class.
   */
  def printTitle(t: Thing): Unit = println(s"The title is: ${t.title}")

}

/**
 * Companion object of the Human class
 */
object Human {

  /**
   * Circe decoder for the Human class to decode JSON.
   * The compiler will automatically search for this decoder in the companion object.
   */
  implicit val decode: Decoder[Human] = deriveDecoder[Human]

  /**
   * Circe encoder for the Human class to encode into JSON.
   * The compiler will automatically search for this encoder in the companion object.
   */
  implicit val encode: Encoder[Human] = deriveEncoder[Human]

}
