package learn.ObjectConstructionFactory

object Test {
  def main(args: Array[String]): Unit = {
    val cat = Animal("cat")
    cat.speak
  }
}