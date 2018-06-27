package learn.EOP

/**
 * 各种方法函数
 */
object method {
  def main(args: Array[String]): Unit = {
    
  }
  
  /*
   * 定义接收多个参数作为参数的方法
   */
  def test1(){
    def executeAndPrint(f:(Double, Double) => Double, x: Double, y: Double){
      val result = f(x, y)
      println(result)
    }
    
    val f = (x: Double, y: Double) => {
      x + y
    }
    
    executeAndPrint(f, 1.0, 2.0)
    val c = scala.math.pow(_, _)
    executeAndPrint(c, 1.0, 2.0)
  }
}