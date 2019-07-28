object Factoriser {
  def factorise(number: Int): Seq[Int] = {
    def innerFact(partialFactorisedNumber: Int, maybeFactor: Int): Seq[Int] = {
      val accum = Seq[Int]()

      if(partialFactorisedNumber == maybeFactor) return Seq(maybeFactor)

      (partialFactorisedNumber % maybeFactor match {
        case 0 => Seq(maybeFactor) ++ innerFact(partialFactorisedNumber / maybeFactor, maybeFactor)
        case _ => innerFact(partialFactorisedNumber, maybeFactor + 1)
      }) ++ accum

    }

    innerFact(number, 2)
  }
}
