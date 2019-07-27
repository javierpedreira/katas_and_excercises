import scala.collection.mutable

object Factoriser {
  def factorise(number: Int): Seq[Int] = {
    def innerFact(partialFactorisedNumber: Int, maybeFactor: Int): Seq[Int] = {

      val accum = Seq[Int]()

      if(partialFactorisedNumber == maybeFactor) return accum ++ Seq(maybeFactor)
      val res = partialFactorisedNumber % maybeFactor match {
        case 0 => Seq(maybeFactor) ++ innerFact(partialFactorisedNumber / maybeFactor, maybeFactor)
        case _ => innerFact(partialFactorisedNumber, maybeFactor + 1)
      }

      accum ++ res
    }

    innerFact(number, 2)
  }
}
