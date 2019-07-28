import org.scalatest._

class Chapter2Spec extends FunSpec with Matchers {
  describe("Fibonacci sequence") {
    it("fibonacci 0 should be 0") {
      Chapter2.fib(0) should be(0)
    }

    it("fibonacci 1 should be 1") {
      Chapter2.fib(1) should be(1)
    }

    it("fibonacci 2 should be 1") {
      Chapter2.fib(2) should be(1)
    }

    it("fibonacci 3 should be 2") {
      Chapter2.fib(3) should be(2)
    }

    it("fibonacci 5 should be 5") {
      Chapter2.fib(5) should be(5)
    }

    it("fibonacci 6 should be 8") {
      Chapter2.fib(6) should be(8)
    }
  }
}
