package sandbox.typeclasses



object Exercise1 {
  def run1_3_1(): Unit = {
    import sandbox.typeclasses.Printable.print

    val c = Cat("MISSIFUAS", 1, "black")
    print(c)
  }

  def run1_3_2(): Unit = {
    import sandbox.typeclasses.PrintableSyntax.PrintableOps
    val c = Cat("MR BUB", 2, "white")

    c.print
  }

  def run1_4(): Unit = {
    import cats.syntax.show._

    println(CatShow("MrChopper", 3, "yellow").show)

  }
}
