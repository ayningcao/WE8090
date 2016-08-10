package test.fpinscala

/**
 * Created by caowenjun763 on 2016/8/10.
 */
object Exercise2_1 {

  def fib(n: Int): Int = n match {
    case 0 => 0
    case 1 => 1
    case _ => fib(n - 1) + fib(n - 2)
  }


  def main(args: Array[String]) {
    for (i <- 0 to 10) {
      println(i + ", " + fib(i))
    }
  }
}
