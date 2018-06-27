package learn.EOP

/**
 * 匿名函数(函数字面量)
 */
object 匿名函数 {
  def main(args: Array[String]): Unit = {

  }

  /*
   * 测试基本的匿名函数
   */
  def test1() {
    val list = List.range(1, 10)
    //下边的(i:Int) => i%2 == 0就是一个匿名函数
    val events1 = list.filter { (i: Int) => i % 2 == 0 }
    //因为scala可以推断出i的类型，所以类型可以省略
    val events2 = list.filter { i => i % 2 == 0 }
    //当参数在函数中只出现一次的时候，scala运行使用"_"通配符来替换变量名
    val events3 = list.filter { _ % 2 == 0 }

    //*************************************
    list.foreach { (i: Int) => println(i) }

    list.foreach { i => println(i) }

    list.foreach { println(_) }
    //如果函数字面量只有一条语句，并且该语句接收一个参数，那么参数不需要特别指定，也不需要显示声明
    list.foreach { println }
  }

  /*
   * 将函数作为变量进行传递
   */
  def test2() {
    val double = (i: Int) => { i * 2 }
    double(2) //4
    double(3) //6
    val list = List.range(1, 10)
    list.map { double }
  }

  /*
   * 匿名函数返回值
   */
  def test3() {
    val f1 = (i: Int) => { i % 2 == 0 } //通过隐式推断返回值类型是Boolean
    val f2: (Int) => Boolean = i => { i % 2 == 0 } //指定返回值
    val f3: Int => Boolean = i => { i % 2 == 0 }
    val f4: Int => Boolean = i => i % 2 == 0 //当函数包含一个以上的表达式的时候必须使用大括号
    val f5: Int => Boolean = _ % 2 == 0

    //有多个参数
    val addThenDouble1: (Int, Int) => Int = (x, y) => {
      val a = x + y
      2 * a
    }
    val addThenDouble2 = (x: Int, y: Int) => {
      val a = x + y
      2 * a
    }
  }
  
  /*
   * 像匿名函数一样使用方法
   */
  def test4(){
    def modMethod(i: Int) = i % 2 == 0
    val list = List.range(1, 10)
    list.filter(modMethod)
    
    val modFunction: (Int) => Boolean = (i) => {i % 2 == 0}
    list.filter { modFunction }
  }
  
  /*
   * 将已存在的函数赋给函数变量
   */
  def test5(){
    val c = scala.math.cos(_)
    c(9)
  }
}












