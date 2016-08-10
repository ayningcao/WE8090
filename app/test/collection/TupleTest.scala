package test.collection

/**
 * Scala Tuple, Scala元组
 *xz
 * Created by caowenjun763 on 2016/7/14.
 */
object TupleTest {

  def basic(firstName: String, lastName: String, age: Int): (String, String, Int) = (firstName, lastName, age)

  def main(args: Array[String]) {
    val member = basic("alex", "cao", 22)
    println("Hello, my name is " + member._1 + " " + member._2 + ", and I am " + member._3 + " years old")
  }
}