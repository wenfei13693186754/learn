package com.wdcloud.scalaDemo

import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks._

object arrayBuffer {
  def main(args: Array[String]): Unit = {
    
    
    var arr1 = Array(-1.0,-1.1,-1.3,-0.3)
    
    var num = 0
    breakable{
    	for(x <- arr1){
      	if(0.9>x){
      		arr1(num)=0.9
      		println("***"+arr1.mkString(","))
      				break
      	}  
      	num = num+1
    	}
    }
    val d = arr1.indexOf(-1.3)
    println("下标是："+d+"*****"+arr1.mkString(","))
  }  
}