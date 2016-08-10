package test.control

/**
 * Created by caowenjun763 on 2016/8/8.
 */
class MidStream {

}

object MidStream {

  def getString(): Unit = {
    val list = Seq("Hello", "World", "I", "am", "Alex")
    for (i <- 0 until list.length; s = list(i) if !s.equals("I")) {

      println(i + ", " + s)
    }
  }

  def main(args: Array[String]) {
    getString()
  }

}