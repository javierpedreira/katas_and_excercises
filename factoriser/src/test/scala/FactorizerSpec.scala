import org.scalatest._

import collection.immutable.Seq

class FactorizerSpec extends FunSpec with Matchers {
  it ("factor of 2 should be [2]") {
    new Factorizer(2).factorise should be (Seq(2))
  }

  it ("factor of 3 should be [3]") {
    new Factorizer(3).factorise should be (Seq(3))
  }
}
