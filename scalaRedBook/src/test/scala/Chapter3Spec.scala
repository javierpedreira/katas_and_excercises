import org.scalatest.{FunSpec, Matchers}
import Chapter3.MyList
import Chapter3.MyList.{product, sum, tail}
import com.sun.javaws.exceptions.InvalidArgumentException

class Chapter3Spec extends FunSpec with Matchers {
  describe("MyList sum") {
    it("should return 0 for an empty List") {
      sum(MyList()) should be(0)
    }

    it("should return x if the List only contains x") {
      sum(MyList(1000000)) should be(1000000)
    }

    it("should sum elements of a List") {
      sum(MyList(1, 2, 3)) should be(6)
    }

  }

  describe("MyList product") {
    it("should return 1 for an empty list") {
      product(MyList()) should be(1)
    }

    it("should return 0 if there is at least a 0 in the list") {
      product(MyList(1, 100, 20000, 0, 5, -999)) should be(0)
    }

    it("should return the product of the elements of the list") {
      product(MyList(4, 5, 10)) should be(200)
    }
  }

  describe("MyList tail") {
    it("tail(MyList(1,4,5,6)) should return 1") {
      tail(MyList(1,4,5,6)) should be(MyList(4,5,6))
    }

    it("tail(MyList(200)) should return 200") {
      tail(MyList(200)) should be(MyList())
    }
  }
}
