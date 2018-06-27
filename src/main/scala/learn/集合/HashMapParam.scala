package com.wdcloud.scalaDemo

import org.apache.spark.{AccumulableParam, SparkConf}
import org.apache.spark.serializer.JavaSerializer
import scala.collection.mutable.{HashMap => MutableHashMap}
import org.apache.spark.Accumulable

/*
 * Allows a mutable HashMap[String, Int] to be used as an accumulator in Spark.
 * Whenever we try to put (k, v2) into an accumulator that already contains (k, v1), the result
 * will be a HashMap containing (k, v1 + v2).
 *
 * Would have been nice to extend GrowableAccumulableParam instead of redefining everything, but it's
 * private to the spark package.(相对于完全自己写实现，通过继承GrowableAccumulableParam来实现累加器功能是不错的，但是对于spark工程的包是私有的)
 */
class HashMapParam extends AccumulableParam[MutableHashMap[String, Double], (String, Double)] {

  def addAccumulator(acc: MutableHashMap[String, Double], elem: (String, Double)): MutableHashMap[String, Double] = {
    println(elem+"***"+acc.keySet)
    val (k1, v1) = elem
    val kmin = acc.minBy(x => x._2)._1
    println("最小的键值对的键是："+kmin)
    acc += acc.find(_._1 == kmin).map {
      case (k2, v2) => k2 -> v1  
    }.getOrElse(elem)
    
    acc
  }

  /*
   * This method is allowed to modify and return the first value for efficiency.
   * 允许此方法修改和返回效率的第一个值。
   * 这个方法就是将一个MutableHashMap与另一个进行累加的
   *
   * @see org.apache.spark.GrowableAccumulableParam.addInPlace(r1: R, r2: R): R
   */
  def addInPlace(acc1: MutableHashMap[String,Double], acc2: MutableHashMap[String, Double]): MutableHashMap[String, Double] = {
    acc2.foreach(elem => addAccumulator(acc1, elem))
    acc1
  }

  /*
   * @see org.apache.spark.GrowableAccumulableParam.zero(initialValue: R): R
   * 初始化一个HashMap
   */
  def zero(initialValue: MutableHashMap[String, Double]): MutableHashMap[String, Double] = {
    val ser = new JavaSerializer(new SparkConf(false)).newInstance()
    val copy = ser.deserialize[MutableHashMap[String, Double]](ser.serialize(initialValue))
    copy.clear()
    copy  
  }
}
