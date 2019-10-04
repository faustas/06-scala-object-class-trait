import Human.encode
import io.circe.syntax._

object Main {

  def main(args: Array[String]): Unit = {

    val human = Human(title = "Foo", age = 99)
    val animal = Animal(title = "spider", name = "Fred")
    val car = Car(title = "Ford Mustang")

    Thing.printTitle(human)   //  The title is: Foo
    Thing.printTitle(animal)  //  The title is: spider
    Thing.printTitle(car)     //  The title is: Ford Mustang

    println(human.asJson)
    // {
    //   "title" : "Foo",
    //   "age" : 99
    // }

  }

}
