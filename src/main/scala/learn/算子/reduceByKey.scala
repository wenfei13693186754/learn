package com.wdcloud.scalaDemo

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object reduceByKey {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("graphDemo")
	  val sc = new SparkContext(conf)
	
    val a = sc.parallelize(List((1,2),(1,3),(1,4),(3,2),(3,4)))
    val b = a.reduceByKey((x,y) => 1+1)
    b.foreach(x => println(x._1+"  "+x._2))
  }
  
}