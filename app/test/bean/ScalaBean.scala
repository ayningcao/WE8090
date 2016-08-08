package test.bean

import scala.beans.BeanProperty

/**
 * 创建JavaBean风格Scala bean的几种方式
 *
 * Created by caowenjun763 on 2016/8/8.
 */
object ScalaBean {
  def main(args: Array[String]) {
    val orange: Orange = new Orange("red", 20)
    val apple: Apple = new Apple("yellow", 20.3d)
    val waterMelon: WaterMelon = new WaterMelon("green")

    val banana: Banana = new Banana
    banana.setColor("green")
    banana.setLength(10)

    println("Orange: " + orange.color)
    println("Apple: " + apple.color)
    // 无法访问waterMelon.color
    println("WaterMelon: " + waterMelon)
    println("Banana: " + banana.color)

  }
}

/**
 * 默认类型为val
 *
 * @param color
 * @param weight
 */
class Orange(val color: String, val weight: Int) {}

class WaterMelon(color: String)

/**
 * case class, 构造函数的参数默认类型为val
 *
 * @param color
 * @param weight
 */
case class Apple(color: String, weight: Double)

/**
 * 通过@BeanProperty注解实现
 */
class Banana() {
  @BeanProperty
  var color: String = _
  @BeanProperty
  var length: Double = _
}
