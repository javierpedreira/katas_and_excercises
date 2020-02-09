package sandbox.typeclasses

trait Printable[A] {
  def format(value: A): String
}

object PrintableInstances {
  implicit val formatInts: Printable[Int] = new Printable[Int] {
    def format(value: Int): String = value.toString
  }
  implicit val formatStrings: Printable[String] = new Printable[String] {
    def format(value: String): String = value
  }
}

object Printable {
  def format[A](value: A)(implicit printable: Printable[A]): String = printable.format(value)
  def print[A](value: A)(implicit printable: Printable[A]): Unit = println(format(value))
}


object PrintableSyntax {

  implicit class PrintableOps[A](value: A) {
    def format(implicit printer: Printable[A]): String = printer.format(value)
    def print(implicit printer: Printable[A]): Unit = println(printer.format(value))
  }
}
