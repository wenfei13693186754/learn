package learn.继承

/**
 * 在一个抽象类中定义抽象或者有实现的属性，让子类可以引用
 * 
 * 1. 抽象类中的val字段或var字段
 * 			抽象基类中定义的初始化好的val或var类型的变量，不会被子类所复写，因为反编译后该变量是final类型的，所以当new Dog("dog")的时候会输出父类的animal和子类的doganimal。
 */
abstract class Animal(name: String) {
  val gender = {println("animal")}
  var height = {println("身高是180")}
  val greeting: String
  var age: Int
  def sayHello {println(greeting)}
  override def toString = s"I say $greeting, and I am $age"
}

class Dog(name: String) extends Animal(name){
  override val gender = {println("doganimal")}
  height = {println("身高是130")}
  val greeting = "Woof"
  var age = 20
}

class Cat(name: String) extends Animal(name){
  override val gender = {println("catanimal")}  
  height = {println("身高是100")}
  val greeting = "Meow"
  var age = 28
}

object AbstractFieldsDemo extends App{
  val dog = new Dog("dog")
  //animal  
  //身高是180
  //doganimal
  val cat = new Cat("cat")
  println(dog)//I say Woof, and I am 20
  println(cat)//I say Meow, and I am 28
}