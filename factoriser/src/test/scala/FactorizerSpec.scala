import org.scalatest._

import collection.immutable.Seq

class FactorizerSpec extends FunSpec with Matchers {
  it ("factor of 2 should be [2]") {
    Factoriser.factorise(2) should be (Seq(2))
  }

  it ("factor of 3 should be [3]") {
    Factoriser.factorise(3) should be (Seq(3))
  }

  it ("factor of 4 should be [2, 2]") {
    Factoriser.factorise(4) should be (Seq(2, 2))
  }
}
