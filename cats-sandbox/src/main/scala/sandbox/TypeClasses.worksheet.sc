// Type Class
// We can understand Type Classes as some kind of contract or interface
// to expose all the things we can do in a certain context.
// Type Classes accept a Type (A) as a parameter because the strategy
// to implement those methods will be implemented around an specific type
// providing the ability to know WHAT we want to do and leave the HOW we
// we will do it for later.

// the following trait shows what can be done in a Bakery
trait Bakery[A] {
  def toOven(value: A): A
  def toFryPan(value: A): A
  def sell(value: A): A
}

//- Type Class Instances

//  Type classes instances contain the specific implementation
//  for different type of "A"s for the methods listed in the interface

// Given the following type of Cakes
case class MeatCake(name: String)
case class CheeseCake(name: String)

// We implement different baking techniques, for this example we won't
// implement anything hence the (???)
object CakeInstances {
  implicit val bakeCheeseCake: Bakery[CheeseCake] =
    new Bakery[CheeseCake] {
      def toOven(value: CheeseCake): CheeseCake = ???
      def toFryPan(value: CheeseCake): CheeseCake = ???
      def sell(value: CheeseCake): CheeseCake = ???
    }

  implicit val bakeMeatCake: Bakery[MeatCake] =
    new Bakery[MeatCake] {
      def toOven(value: MeatCake): MeatCake = ???
      def toFryPan(value: MeatCake): MeatCake = ???
      def sell(value: MeatCake): MeatCake = ???
    }
}

// Since users of the Bakery don't care about how we want to bake the cakes
// we only want to tell them that the bakery bakes a cake.
// We will create an interface with a generic method with the method
// "bake" and will leave the decision of picking the specific implementation
// to the compiler, this is called "Type Class Interfaces", and there
// are 2 different ways of achieving this.

// 1- Interface Objects
// We will create a generic bake method that will receive as a parameter
// an specific cake to bake.
object Bakery {
  def bake[A](value: A)(implicit w: Bakery[A]): A = w.toOven(value)
}


// The way to use this is to import the object and use the method directly
// Make sure there is a Type Instance defined for the Type defined
import CakeInstances.bakeMeatCake
import CakeInstances.bakeCheeseCake
import Bakery.bake

// The compiler will detect the correct strategy to bake each cake (implicits)
bake(CheeseCake("cake1"))
bake(MeatCake("cake2"))

// 2- Interface Syntax
// We also can extend the Cake types with the bake method so we can call it
// directly from the object
object BakerySyntax {
  implicit class BakeryOps[A](value: A) {
    def bake(implicit w: Bakery[A]): A = w.toOven(value)
  }
}

// We use it by importing the instances and the method extensions. The compiler will
// detect the implicit automatically
import CakeInstances.{bakeCheeseCake, bakeMeatCake}
import BakerySyntax.BakeryOps

MeatCake("cake1").bake
CheeseCake("cake2").bake

// Implicitly

// Summoning instances can be done by using the implicitly method
// from the scala default library
// This is useful for debugging purposes to check if the compilir is finding
// an instance and there are no ambiguous errors
val x: Bakery[MeatCake] = implicitly[Bakery[MeatCake]]


// Packaging Implicits
// We can create the Type Classes and pack the Instances in a
// Companion Object this is useful within the implicit scope
case class Computer(name: String)

trait Store[A] {
  def sell(v: A): A
}

object Store {
  implicit val sellElectronics: Store[Computer] =
    new Store[Computer] {
      def sell(v: Computer): Computer = ???
    }
}



