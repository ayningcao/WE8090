package test

/**
 * Created by caowenjun763 on 2016/8/10.
 */
class ImplictTest {

}

object ImplictTest {

  def main(args: Array[String]) {
    implicit def add(x: Apple): Int = {
      x.money
    }

    val x: Int = 10
    val y: Apple = new Apple(100)
    val a: Int = y + x
    println(a)
  }

}

class Apple(val money: Int) {

}
