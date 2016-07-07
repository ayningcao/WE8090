package learn.traits

/**
 * 演示Scala Traits
 *
 * Created by caowenjun763 on 2016/7/7.
 */
class Date(y: Int, m: Int, d: Int) extends Ord {
  def year = y

  def month = m

  def day = d

  override def toString() = year + "/" + month + "/" + day

  override def equals(that: Any): Boolean =
    that.isInstanceOf[Date] && {
      val o = that.asInstanceOf[Date]
      o.day == this.day && o.month == this.month && o.year == this.year
    }

  override def <(that: Any): Boolean = {
    if (!that.isInstanceOf[Date]) {
      sys.error("not a date")
    }
    val t = that.asInstanceOf[Date]
    (year < t.year) || (year == year && (month < t.month || (month == t.month && day < t.day)))
  }
}

object Date {
  def main(args: Array[String]) {
    val today = new Date(2016, 7, 7)
    val yesterday = new Date(2016, 7, 6)

    println(today + " is before than " + yesterday + "? " + (today < yesterday))
  }
}
