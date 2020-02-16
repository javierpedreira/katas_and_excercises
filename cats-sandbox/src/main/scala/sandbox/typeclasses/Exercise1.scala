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

  def run_1_5_5(): Unit = {
    import cats.syntax.eq._
    import cats.instances.option._
    import Cat.equalCats

    val cat1 = Cat("Garfield", 38, "orange and black")
    val cat2 = Cat("Heathcliff", 33, "orange and black")

    println(s"cat1 vs cat1 ${cat1 === cat1}")
    println(s"cat1 vs cat2 ${cat1 === cat2}")

    val optionCat1 = Option(cat1)
    val optionCat2 = Option.empty[Cat]

    println(s"optioncat1 vs optioncat1 ${optionCat1 === optionCat1}")
    println(s"optioncat1 vs optioncat2 ${optionCat1 === optionCat2}")
  }
}
