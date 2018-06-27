package learn.EOP

import scala.collection.mutable.ArrayBuffer

/**
 * 闭包测试
 * 在计算机科学中，闭包(语法闭包和函数闭包)是一个函数连同该函数的非局部变量的引用环境。闭包允许函数访问其直接语法作用域之外的变量
 */
object ClosureExample extends App {
  val name = "jack"
  val hello = "hello"
  val f: (String) => Unit = (str) => { //这就是一个闭包
    println(s"$hello, $name")
  }

  val foo = new Foo()
  foo.exec(f, name)//hello, jack
  //*******************************************************  
  val fruits = ArrayBuffer("apple")
  val addToBasket = (s: String) => { //这就是一个闭包，一个函数连同该函数的非局部变量的引用环境
    fruits += s
    println(fruits.mkString(", "))
  }

  foo.buyStuff(addToBasket, "origss")//apple, orig

}

class Foo {
  //a method that takes function and a String,and passes the string into the function,and then executes the function
  def exec(f: (String) => Unit, name: String) {
    f(name)
  }
  def buyStuff(f: String => Unit, s: String) {
    f(s)
  }
}

