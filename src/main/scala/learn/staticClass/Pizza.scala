package learn.staticClass

/**
 * 使用类创建非静态的实例成员，使用伴生类创建静态成员
 * 并验证在类创建的时候，伴生类中的方法是不是会执行
 * 
 * 结果：不会执行，类中的方法和伴生类中的方法都不会执行，但是代码块中的会执行
 */
class Pizza(var name: String) {
  
  {
    println("代码块"+Pizza.pizzaName)
  }
  
  def test(){
    println("类中的方法被触发了")
  }
  
  override def toString = "name is "+ name
}

//伴生类
object Pizza {
  val pizzaName = "hahhaha"
  
  def test(){
    
    println("伴生类的方法被触发了")
  }
}