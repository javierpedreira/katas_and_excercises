import scala.annotation.tailrec

object Chapter2 {
  // exercise 2.1 tail recs
  def fib(n: Int): Int = {
    @tailrec
    /*
    * This method is a tailRec because the recursive call only returns the
    * result.
    * */
    def fibTailRec(index: Int, current: Int, prev: Int): Int = {
      if(index <= 0) current
      else fibTailRec(index -1, current = prev, prev = prev + current)
    }

    fibTailRec(n, prev = 1, current = 0)
  }

  //exercise 2.2 HOF
  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    /* isSorted is a generic and can be used with any type of Array of a given object
       in order to work it'll need an external ordered method belonging to the A type
       that helps to decide if the array is sorted
    * */
    @tailrec
    def sortedTailRec(current: Int): Boolean = {
      if(current == as.length -1) true
      else {
        if(ordered(as(current), as(current + 1))) sortedTailRec(current + 1)
        else false
      }
    }

    sortedTailRec(0)
  }

  // exercicse 2.3 currying
  // We have a polymorphic function that can only receive an specific implementation
  def curry[A, B, C](f: (A, B) => C): A => B => C = (a: A) => (b: B) => f(a, b)

  // exercicse 2.4 uncurrying
  // This is a reverse method of the curry function
  // This exercise needs more clarification
  def uncurry[A, B, C](f: A => B => C):(A, B) => C = ???

  // exercise 2.5 composition
  // We feed the output of a function as the input of another one
  def compose[A, B, C](f: B => C, g: A => B): A => C = (x: A) => f(g(x))

}
