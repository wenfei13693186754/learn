package learn.javaWithScala

/**
 * 在java应用程序中调用一个已经完成了的Scala特质与实现的方法，需要把特质包装到一个类中
 * 
 * java类是JavaMath
 */
trait MathTrait {
  def sum(x: Int, y: Int) = x+y
}

class MathTraitWrapper extends MathTrait