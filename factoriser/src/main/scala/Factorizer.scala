import scala.collection.mutable

object Factoriser {
  def factorise(number: Int): Seq[Int] = {
    def innerFact(partialFactorisedNumber: Int, maybeFactor: Int): Seq[Int] = {
      Seq(number).foldRight(Seq[Int]())((numFromSeq: Int, accum: Seq[Int]) => {
        if (maybeFactor > 0 && partialFactorisedNumber > 0) {
          val divisionRest  = numFromSeq % maybeFactor
          divisionRest match {
            case 0 => innerFact(partialFactorisedNumber - maybeFactor, maybeFactor) ++ Seq(maybeFactor) ++ accum
            case 1 => innerFact(partialFactorisedNumber, maybeFactor + 1) ++ accum
          }
        } else {
          return accum
        }
      })

      }

    println(s"Factorising $number")
    innerFact(number, 2)
  }
}
