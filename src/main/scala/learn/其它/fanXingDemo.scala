package com.wdcloud.scalaDemo
/**
 * scala中的泛型
 * Reference类有一个叫做T的类型参数用来表示它所引用的对象的类型，这个类型在Reference中作为了变量和函数的参数或者返回值类型
 */
class Reference[T]{
  //给contents赋予的初始值：_,表示的是一个默认值，对于数字来说是0，对于boolean来说是false,
  //对于Unit(函数签名)来说是()(无参数)，对于其它来说是null
  private var contents:T=_
  def set(value:T)={
    contents = value
  }
  def get:T = contents
}

/**
 * 要使用这个类型参数，你需要制定它的类型参数，来告知这个引用到底引用了什么类型
 * 比如要创建一个指向Int的引用，可以如下写法
 */
object IntegerReference{
  def main(args: Array[String]): Unit = {
    val cell = new Reference[Int]()
    cell.set(12)
    println(cell.get)
  }
}
