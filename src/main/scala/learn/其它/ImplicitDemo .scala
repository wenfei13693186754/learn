package com.wdcloud.scalaDemo

/**
 * 关键字implicit用来标记一个隐式定义，编译器踩可以选择他作为隐式变化的的候选项。
 * 你可以使用implicit来标记任意变量，函数或者对象
 */
object ImplicitDemo  {
  /*
   * implicit 实现隐式参数
   */
  object Context {
    implicit val str: String = "implicit parameter"
  }
  object Parameter {
    def print(context: String)(implicit prefix: String): Unit = {
      println(prefix+":"+context)
    }
  }
  
  def main(args: Array[String]): Unit = {  
    Parameter.print("Hello")("Scala")
    //在此使用隐式参数
    import Context._
    Parameter.print("Scala")
  }
}