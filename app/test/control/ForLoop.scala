package test.control

/**
 * 演示如何使用Scala for
 *
 * Created by caowenjun763 on 2016/8/8.
 */
object ForLoop {

  def main(args: Array[String]) {
    basic(7)
  }

  def basic(count: Int): Unit = {
    println("for i <- 0 to count output: ")
    for (i <- 0 to count) {
      print(i)
      print(if (i == count) "\n" else ", ")
    }

    println("for i <- 0 until count output: ")
    for (i <- 0 until count) {
      print(i)
      print(if (i == count - 1) "\n" else ", ")
    }
  }
}
