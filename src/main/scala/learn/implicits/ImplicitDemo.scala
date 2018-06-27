package learn.implicits

/**
 * implicit关键字定义隐式转换函数
 */
object ImplicitDemo {
  
  def display(input: String): Unit = println(input)
  
  implicit def typeConvertor(input: Int): String = input.toString()
  
  implicit def typeConvertor(input: Boolean): String = if(input) "true" else "false"
  
  def main(args: Array[String]): Unit = {
    display("asdf")
    display(1)
    display(true)
  }
}