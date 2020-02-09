package sandbox.typeclasses

import cats.Show
import cats.instances.all._
import cats.syntax.show._

final case class CatShow(name: String, age: Int, color: String)
object CatShow {

  implicit val catPrintable: Show[CatShow] = Show.show { cat =>
    s"${cat.name.show} is a ${cat.age.show} years old ${cat.color.show} cat"
  }
}
