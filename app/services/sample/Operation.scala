package services.sample

/**
 * Created by caowenjun763 on 2016/7/7.
 */
abstract class Operation {

  type Environment = String => Int


}

case class Sum(l: Operation, r: Operation) extends Operation

case class Minus(l: Operation, r: Operation) extends Operation
