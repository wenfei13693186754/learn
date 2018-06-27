package learn.lazyLoad

/**
 * scala使用lazy来定义惰性变量，实现延迟加载(懒加载)
 * 
 * 惰性变量只能是不可变变量，并且只有在调用惰性变量时，才回去实例化这个变量
 * java中的单例模式(懒汉式)就使用了这种思路
 * public class LazyDemo {

      private String property;
    
    public String getProperty() {
      if (property == null) {//如果没有初始化过，那么进行初始化
        property = initProperty();
      }
      return property;
    }
    
      private String initProperty() {
        return "property";
      }
    }
    
   而在Scala中对延迟加载这一特性提供了语法级别的支持:
    
    lazy val property = initProperty()
    
        1
    
        1
    
    使用lazy关键字修饰变量后，只有在使用该变量时，才会调用其实例化方法。也就是说在定义property=initProperty()时并不会调用initProperty()方法，只有在后面的代码中使用变量property时才会调用initProperty()方法。
    
    如果不使用lazy关键字对变量修饰，那么变量property是立即实例化的:
 */
object LazyTest {
  def init(): String = {
    println("call init()")
    return ""
  }  
  
  def main(args: Array[String]): Unit = {
    val property1 = init()//没有使用lazy修饰
    lazy val property2 = init()//使用lazy修饰
    println("after init()")
    println(property1)
    /*
     * 没有使用lazy修饰：
     * 打印结果：
     * call init()
       after init()
               可以发现，property申明时，立即进行了实例化，调用了init()方法
               
                  使用了lazy修饰：
                  打印结果：
        after init()
        call init() 
     	   可以发现，property在使用的时候，才会调用init()方法进行实例化
     */
  }
}








