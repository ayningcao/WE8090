package test.collection.list

/**
 * Created by caowenjun763 on 2016/8/11.
 */
object Basic {

  def append(): Unit = {
    val l1 = "a" :: List("b", "c", "d")
    println(l1)
    println(l1.head)
    println(l1.tail)
  }

  def concate(): List[Int] = {
    val l1 = List(1, 2, 5)
    val l2 = List(7, 8, 9)
    l1 ::: l2
  }

  def flatten(): Unit = {
    val a = List(List(List("1", "2", "3"), List("4", "5")), List(List("1", "2", "3"), List("4", "5")), List(List("1", "2", "3"), List("4", "5")))
    println(a.flatten.mkString)
  }

  def zip(): Unit = {
    val a = List("1", "2", "3")
  }

  def map(): Unit = {
    val l = List("1", "2", "3")
    val l2 = l.map(_ + 1)
    println(l2)
  }

  def main(args: Array[String]) {
    map()
  }

}