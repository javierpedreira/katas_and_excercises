import scala.annotation.tailrec

object Chapter2 {
  // exercise 2.1
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
}
