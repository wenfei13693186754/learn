package learn.reflect.scala_java

/**
 * scala 调用java反射API实现反射
 */
//RefTest.scala,主程序入口
object RefTest extends App {
  //*****************使用反射来创建并使用类A
  val className = "learn.reflect.scala_java.A"
  //返回与给定字符串名称的类或接口相关联的{@code Class}对象
  val classA = Class.forName(className)
  //返回指定的方法对象，“fun1”参数是指定的方法名，classOf[String]是方法的参数类型
  val method = classA.getDeclaredMethod("fun1", classOf[String])
  //使用反射调用类classA对象的method方法，并传参数是5
  method.invoke(classA.newInstance(), "5") // 如果是Int的话,要用new Integer(5)

  //****************使用反射来创建并使用类B
  val cnb = "learn.reflect.scala_java.B"
  val cb = Class.forName(cnb)
  //添加反射时候的构造器
  val cons = cb.getConstructors
  val inst = cons(0).newInstance("你好")
  val mbf1 = cb.getDeclaredMethod("fun1", classOf[String])
  mbf1.invoke(inst, "哈哈")
  
  //*********************************************************
  val clazz = classOf[learn.reflect.scala_java.B]
  val a = clazz.getName
  println(a)//learn.reflect.scala_java.B
  val b = clazz.getAnnotations
  val c = clazz.getMethods
  val d = clazz.getMethod("fun1", classOf[String])
  val e = clazz.getConstructors
  val f = clazz.getDeclaredField("t")
//......
}

class A {
  def fun1(a: String) = println(a)
  def fun2() = print("fun2")
  val t = 1
}

class B(a: String) {
  def fun1(b: String) = println(a + "" + b)
  def fun2() = print("fun2")
  var t = 1
}












