package learn.算子

/*
 * 像三元运算符一样使用if
 */
object ifTest {
  def main(args: Array[String]): Unit = {
    val a = 1
    val absValue = if (a < 0) -a else a
    
    //if表达式可返回值，所以可以将其嵌入到打印语句中
    println(if(a == 0) "a" else "b")
  }
}