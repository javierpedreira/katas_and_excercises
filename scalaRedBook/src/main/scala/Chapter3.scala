object Chapter3 {

  // +A id as variance annotiation that signals that A is a covariant of List
  // that means that if a Type X is subtype of Y then MyList[X] is subtype of MyList[Y]
  sealed trait MyList[+A]
  case object Nil extends MyList[Nothing]
  case class Cons[+A](head: A, tail: MyList[A]) extends MyList[A]

  object MyList {
    def sum(ints: MyList[Int]): Int = ints match {
      case Nil => 0
      case Cons(x, xs) => x + sum(xs)
    }

    def product(ds: MyList[Double]): Double = ds match {
      case Nil => 1.0
      case Cons(0.0, _) => 0.0
      case Cons(x, xs) => x * product(xs)
    }

    // exercise 3.2 Remove the first element of the list
    def tail[A](ls: MyList[A]): MyList[A] =
      ls match {
        case Cons(_, xs) => xs
        case Nil => throw new EmptyMyListException(s"tail of an empty list is not possible")
      }

    // exercise 3.3: Replaces the head of the list with a new element
    def setHead[A](elem: A, myList: MyList[A]): MyList[A] =
    myList match {
      case Nil => throw new EmptyMyListException(s"set head $elem of an empty list is not possible")
      case Cons(_, xs) => Cons(elem, xs)
    }

    def apply[A](as: A*): MyList[A] =
      if(as.isEmpty) Nil
      else Cons(as.head, apply(as.tail: _*))
  }

  case class EmptyMyListException(msg: String) extends Exception

}
