package test.http

/**
  * Created by caowenjun763 on 2016/9/2.
  */
class Banks(val bankNo: String, val name: String, val phone: String, val address: String) {

   override def toString = s"Banks($bankNo, $name, $phone, $address)"
 }
