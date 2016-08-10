package test.implicitLearn

/**
 * Created by caowenjun763 on 2016/8/10.
 */
class ImplicitParameters {}

object ImplicitParameters {
  def main(args: Array[String]) {
    implicit val color: String = "red"
    implicit val car: Car = new Car("Benz", color)

    println(want(1000))
  }

  def want(price: Long)(implicit car: Car, color: String): Car = {
    car
  }
}

class Car(val brand: String, val color: String) {
  override def toString = {
    "car[brand: " + brand + ", color:" + color + "]"
  }
}
