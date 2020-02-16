package sandbox.typeclasses

import PrintableInstances.{formatInts, formatStrings}

final case class Cat(name: String, age: Int, color: String)
object Cat {

  implicit val catPrintable: Printable[Cat] = new Printable[Cat] {
    def format(cat: Cat): String = {
      val name = Printable.format(cat.name)
      val age = Printable.format(cat.age)
      val color = Printable.format(cat.color)
      s"$name is a $age year-old $color cat."
    }
  }

  import cats.Eq
  import cats.syntax.eq._
  import cats.instances.string._
  import cats.instances.int._

  implicit val equalCats: Eq[Cat] = Eq.instance[Cat] { (cat1, cat2) =>
    (cat1.name === cat2.name) && (cat1.age === cat2.age) && (cat1.color === cat2.color)
  }
}
