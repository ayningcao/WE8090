package test.fpinscala

/**
 * Created by caowenjun763 on 2016/8/10.
 */
object Exercise2_2 {
  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    require(as != null)
    require(as.length >= 2)

    def loop(n: Int): Boolean = {
      if (n >= as.length) true
      else if (ordered(as(n), as(n + 1))) loop(n + 1)
      else false
    }

    loop(0)
  }

  def main(args: Array[String]) {
    val a = Array(1)
    println(isSorted(Array(1), compare))
  }

  def compare(x: Int, y: Int): Boolean = {
    x >= y
  }
}
