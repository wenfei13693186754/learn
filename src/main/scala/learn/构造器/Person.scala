package learn.构造器

/**
 * 主构造器、辅助构造器
 */
class Person1(val name: String, val age: Int = 20) {
  //这里(val name: String, val age: Int)的含义类似于java中的构造方法
  //name和age类似于java中的成员变量，在scala中称为member
  //如果不加val，表示此member是私有的。如果加var代表这个成员变量是可变的，并且可以get和set.这里是val，代表只能get
  //它在scala中称为主构造器
  //成员变量可以有默认值，如age = 20
}

/**
 * 辅助构造器
 */
class Person2(val name: String, val age: Int){
  def this(name: String) = this(name, 20)
}

/**
 * 继承
 * 	下边extends Person1(name, age)的含义类似于java的super(name, age)
 */
class Teacher1(name: String, age: Int, val gender: String) extends Person1(name, age){
  
}

/**
 *定义member
 * 	可以不经过主构造器或者辅助构造器来定义member
 */
class Teacher2(name: String, age: Int, val gender: String) extends Person1(name, age){
  val birthday = new java.util.Date
}

class Test{
  //使用主构造器构造
	val stu1 = new Person1("zhangsan", 20)
	//也可以采用默认值来构建对象
	val stu11 = new Person1("zhangsan")
	
	//使用辅助构造器构造
	val stu2 = new Person2("lisi")
	//也可以使用主构造器构造
	val stu21 = new Person2("lisi", 30)
}