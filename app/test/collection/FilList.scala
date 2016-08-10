package test.collection

/**
 * Created by caowenjun763 on 2016/8/10.
 */
object FilList {

  def main(args: Array[String]) {
    val l: List[(String, Int)] = List.fill(10)(("Hello World", 2))
    println(l)
    l.unzip
  }


}
