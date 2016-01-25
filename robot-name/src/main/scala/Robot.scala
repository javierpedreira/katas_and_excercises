import scala.collection.mutable

class Robot(letters: Int = 2, numbers: Int = 3) {
  var name: String = NamesCache.validate(generateName(), generateName)

  private def randomiser(length: Int, seeds: Seq[String]): String = {
    val r = new scala.util.Random
    val sb = new StringBuilder

    for (_ <- 1 to length) sb.append(seeds(r.nextInt(seeds.length)))

    sb.toString
  }

  private def randomLetters: String = randomiser(letters, ('A' to 'Z').map(_.toString))

  private def randomNumbers: String = randomiser(numbers, (0 to 9).map(_.toString))

  def generateName(): String = s"$randomLetters$randomNumbers"

  def reset(): Unit = this.name = NamesCache.validate(generateName(), generateName)

}

object NamesCache {
  val names: mutable.Set[String] = mutable.HashSet.empty[String]

  def validate(name: String, nameBuilder: () => String): String = {
    if (names contains name) NamesCache.validate(nameBuilder(), nameBuilder)
    else {
      NamesCache.append(name)
      name
    }
  }

  def append(name: String): mutable.Set[String] = names += name
}
