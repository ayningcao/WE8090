package learn.genericity

/**
 * Created by caowenjun763 on 2016/7/7.
 */
class Refence[T] {

  private var content: T = _

  def set(c: T) = this.content = c

  def get(): T = content

}

object Refence {

  def main(args: Array[String]): Unit = {
    val r1 = new Refence[Int]
    r1.set(10)
    println(r1.get() * 10)

    val r2 = new Refence[String]
    r2.set("Hello")
    println(r2.get() + r1.get())
  }

}
