package learn.构造器

class Person3(var firstName: String, var lastName: String) {
    println("the constructor begins")
    
    //some class fields
    private val HOME = System.getProperty("user.home")
    var age = 0
    
    //some methods
    override def toString = s"$firstName $lastName is $age years old"
    def printHome{println(s"HOME = $HOME")}
    def printlnFullName{println(this)}//users toString
    
    printHome
    printlnFullName
    println("still in the constructor")
}

object Person3{
  def main(args: Array[String]): Unit = {  
    val p = new Person3("zhangsan", "lisi")  
    /**
     *  the constructor begins
        HOME = C:\Users\Administrator
        zhangsan lisi is 0 years old
        still in the constructor
     */
  }
}
