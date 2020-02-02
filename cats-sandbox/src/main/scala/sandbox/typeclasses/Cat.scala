package sandbox.typeclasses

import PrintableInstances.{formatInts, formatStrings}

final case class Cat(name: String, age: Int, color: String)
object Cat {

  implicit val catPrintable = new Printable[Cat] {
    def format(cat: Cat) = {
      val name  = Printable.format(cat.name)
      val age   = Printable.format(cat.age)
      val color = Printable.format(cat.color)
      s"$name is a $age year-old $color cat."
    }
  }
}


