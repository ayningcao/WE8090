package test.collection

/**
 * Created by caowenjun763 on 2016/7/14.
 */
class ListTest {




}

object ListTest {
  def main(args: Array[String]) {
    val a = Nil
    val b = List("Hello", "world")
    for (s <- b) {
      println(s)
    }
  }
}