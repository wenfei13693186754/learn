package com.wdcloud.scalaDemo

import scala.math._
import java.io.PrintWriter

/**
 * 高阶函数练习
 */
object FunDemo {
  def main(args: Array[String]): Unit = {
    index()
    
  }
  
  //ceil和floor操作
  def ceilAndFloor(){
    val fun1 = ceil _//"上取整"，即取大于x的最小整数
    val fun2 = floor _//“下取整”，即取不大于x的最大整数
    val num = 3.14
    val data1 = fun1(num)
    val data2 = fun2(num)
    println(data1)//4.0
    println(data2)//3.0
  }
  
  //指数操作
  def index () {
    val FileName = "Index"
    val path = "E:\\"+FileName+".txt"
    val out = new PrintWriter(path)
    for(i <- 0 to 20)
      out.println(OutIndex(i))
    out.close()
  }
  
  def OutIndex(n: Int): String = {
    val value = math.pow(2, n)
    println(value+" "+math.pow(2, -n))
    ""*4+value.toInt+"  "*(11-value.toString().size)+math.pow(2, -n)
  }
}









