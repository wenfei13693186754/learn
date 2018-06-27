package learn.staticClass

object PizzaTest {
  
  {
    println("object中的代码块")  
    block()
  }
  
  def main(args: Array[String]): Unit = {
    val pizza = new Pizza("hahah")
    println("执行完成了")
  }
  
  def block(){
    println("方法")
  }
}