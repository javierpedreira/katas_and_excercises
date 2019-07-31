import org.scalatest._
import Chapter2._

class Chapter2Spec extends FunSpec with Matchers {
  describe("Fibonacci sequence") {
    it("fibonacci 0 should be 0") {
      fib(0) should be(0)
    }

    it("fibonacci 1 should be 1") {
      fib(1) should be(1)
    }

    it("fibonacci 2 should be 1") {
      fib(2) should be(1)
    }

    it("fibonacci 3 should be 2") {
      fib(3) should be(2)
    }

    it("fibonacci 5 should be 5") {
      fib(5) should be(5)
    }

    it("fibonacci 6 should be 8") {
      fib(6) should be(8)
    }
  }

  describe("Polymorphic isSorted") {
    describe("isSorted with Ints") {
      it("[1,2,3,4,5] is an increasing sequence") {
        isSorted[Int](Array[Int](1, 2, 3, 4), (x: Int, y: Int) => x <= y) should be (true)
      }

      it("[1, 3, 2, 5, 6] is not an increasing sequence") {
        isSorted[Int](Array[Int](1, 3, 2, 5, 6), (x: Int, y: Int) => x <= y) should be (false)
      }

      it("[100, 50, 25] is a decreasing sequence") {
        isSorted[Int](Array[Int](100, 50, 25), (x: Int, y: Int) => x >= y) should be (true)
      }

      it("[100, 50, 25, 200] is not a decreasing sequence") {
        isSorted[Int](Array[Int](100, 50, 25, 200), (x: Int, y: Int) => x >= y) should be (false)
      }
    }

    describe("isSorted with Strings") {
      it("[a, aa, aaa, bb, ccc] is an ordered sequence") {
        isSorted[String](Array[String]("a", "aa", "aaa", "bb", "ccc"), (x: String, y: String) => x <= y) should be (true)
      }

      it("[a, aa, zzz , aaa, bb, ccc] is not an ordered sequence") {
        isSorted[String](Array[String]("a", "aa", "zzz", "aaa", "bb", "ccc"), (x: String, y: String) => x <= y) should be (false)
      }
    }

    describe("isSorted with some class") {
      class SomeTypeClass(var elem: String)

      object SomeTypeClass {
        def apply(elem: String): SomeTypeClass = new SomeTypeClass(elem)
        def ordered(a: SomeTypeClass, b: SomeTypeClass): Boolean = a.elem < b.elem
      }

      isSorted[SomeTypeClass](Array[SomeTypeClass](SomeTypeClass("aa"), SomeTypeClass("bb"), SomeTypeClass("ccc")), SomeTypeClass.ordered) should be (true)

    }

    describe("currying exercise") {
      it("weird concat implemented with a curried method should concat 2 Lists ") {
        val partial: List[Int] => List[String] => List[String] = curry[List[Int], List[String], List[String]]((a: List[Int], b: List[String]) => (a ++ b).map(_.toString))

        partial(List(1, 2, 3, 4))(List("a", "b", "c")) should be(List("1", "2", "3", "4", "a", "b", "c"))
      }

    }

  }
}
