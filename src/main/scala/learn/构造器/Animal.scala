package learn.构造器

class Animal(var void: String) {
  var eat: String = null
  println("animal void "+void)
}

class dog(void: String) extends Animal(void){
  def p(){
    println(void)
  }
  println("dog void "+void)
}

class mao(void: String) extends Animal(void){
  def p(){
    println(void)
  }
  println("mao void "+void)
}

object test{
  def main(args: Array[String]): Unit = {
    val a = new Animal("hahah")
    a.eat = "sss"
    val d = new dog("wangwangwang")
    d.eat = "sdsd"
    println("dog eat "+d.eat)
    val m = new mao("miaomiao")
    println("mao eat "+m.eat)
    d.p()
    m.p()
  }
}