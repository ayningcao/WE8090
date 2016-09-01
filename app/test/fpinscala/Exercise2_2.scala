package test.fpinscala

import java.util.Date

/**
 * Created by caowenjun763 on 2016/8/10.
 */
object Exercise2_2 {
  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    require(as != null)
    require(as.length >= 2)

    def loop(n: Int): Boolean = {
      if (n >= as.length - 1) true
      else if (ordered(as(n), as(n + 1))) loop(n + 1)
      else false
    }

    loop(0)
  }

  def main(args: Array[String]) {
    val before = new Date
    Thread.sleep(1000)
    val after = new Date()

    val arr = Array(new Item(after, 11, "Alex"), new Item(after, 13, "James"), new Item(before, 13, "Zames"))
    println(isSorted(arr, compare))

    val intArr = Array(222, 122, 18, 9, 6)
    println(isSorted(intArr, (x: Int, y: Int) => x >= y))

    val reverseIntArr = Array(9, 12, 88, 231, 2321)
    println(isSorted(reverseIntArr, (x: Int, y: Int) => x <= y))
  }

  //  def compare
  //  }(x: Int, y: Int): Boolean = {
  //    x <= y

  /**
   * 依次按照date, age和name排序
   *
   * @param x
   * @param y
   * @return
   */
  def compare(x: Item, y: Item): Boolean = {
    x.date.compareTo(y.date) match {
      case 0 => x.age.compareTo(y.age) match {
        case 0 => x.name.compareTo(y.name) >= 0
        case x => x >= 0
      }
      case x => x >= 0
    }
  }
}


class Item(val date: Date, val age: Int, val name: String) {}