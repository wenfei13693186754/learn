package learn.其它

import util.control.Breaks._

/*
 * Scala中没有break和continue关键字，但是scala.util.control.Breaks类提供了类似的功能
 * 
 * 在这种情况下，当i值大于4时，轮到break“关键字”执行。此时，一个异常抛出，for循环结束。breakable“关键字”会捕获异常，
 * 控制流继续执行被打断的代码块后的其它代码
 * 
 * 其实，break和breakable实际上不是关键字，它们是util.control.Breaks类的方法，
 * 	break方法会抛出BreakControl异常的一个实例，方法定义如下;
 * 		private val breakException = new BreakControl
 * 		def break(): Nothing = {throw breakException}
 *  
 *  breakable方法在定义时会去捕获一个BreakControl异常，如下;
 *  	def breakable(){
 *  		try {
 *  			op
 *  		}catch{
 *  			case ex； BreakControl =>
 *  				if (ex ne breakException) throw ex
 *  		}
 *  }
 */
object breakTest extends App{
  breakable{
    for(i <- 1 to 10){
      println(i)
      if(i>4) break//break out of the for loop
    }
  }
}