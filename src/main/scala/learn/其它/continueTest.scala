package learn.其它

object continueTest {

  def main(args: Array[String]): Unit = {
    val a = Array.range(0, 11)
    println(sumToMax(a, 10)) //10

  }
  
  /*
   * 将算法放在函数中，当期望的条件被满足后，从函数中返回。
   * 下边的例子，如果sum值超过limit，sumToMax函数将提前返回
   */
  def sumToMax(arr: Array[Int], limit: Int): Int = {
    var sum = 0
    for (i <- arr) {
      sum += i
      if (sum > limit) return limit
    }
    sum
  }

  /*
   * 递归算法是函数式编程常见的解决问题的方法，下边的就是一个递归算法，当n==1时，递归跳出
   */
  def factorial1(n: Int): Int = {
    if(n == 1) 1
    else n * factorial1(n-1)
  }
  
  /*
   * 上边的递归例子没有使用尾递归，因此不是最佳解法，尤其是当初始值n非常大时，优化的解法是使用下边的尾递归
   * 
   * 对于这种尾递归的情况，可以使用@tailrec注解来强调算法是尾递归的。如果算法中没有尾递归而错误的使用了注解，编译器会报警。
   * 
   * 尾递归：
   * 	尾递归就是操作的最后一步调用自身的递归。
   *  尾递归的判断标准是函数运行最后一步是否调用自身，而不是是否在函数的最后一行调用自身
   */
  import scala.annotation.tailrec
  def factorial2(n: Int): Int = {
    @tailrec def factorialAcc(acc: Int, n: Int): Int = {
      if(n <= 1) acc
      else factorialAcc(n*acc, n-1)
    }
    factorialAcc(1, n)
  }  
}














