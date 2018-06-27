package learn.ObjectConstructionFactory

/**
 * 创建Animal工厂类，让其返回Cat和Dog类的实例
 */
trait Animal {
  def speak
}

object Animal{
  private class Dog extends Animal{
    override def speak{
      println("dog speak wowowowo")
    }
  }
  
  private class Cat extends Animal{
    override def speak{
      println("Cat speak memememe")
    }
  }
  
  //the factory method
  def apply(s: String): Animal = {
    if(s == "dog") new Dog
    else new Cat
  }
}




















