package learn.集合

import scala.collection.mutable.HashMap
import scala.collection.mutable.SynchronizedMap
import java.util.Random

object mapjiheDemo {
  def main(args: Array[String]): Unit = {
    delete()
    //threadSafetyMap1
  }
  /**
   * 验证map中是否可以放key相同的元素，结果是不可以
   */
  def mapTest() {
    val m1 = Map("a" -> 1)
    val m2 = Map("b" -> 1)
    val m3 = Map("c" -> 1)
    val m4 = Map("a" -> 1)
    val m5 = Map("a" -> 1)
    val m7 = Map(1 -> "asdf")
    val m8 = Map("dsf" -> "fff")
    val m6 = m1.++:(m4).++:(m2).++:(m3).++:(m5).++:(m7).++:(m8)
    println(m6.mkString(","))
  }

  /*
   * 看map在循环过程中是否可以删除自己的元素
   * 结果是可以的
   */
  def delete() {
    val m1 = new HashMap[String, Int]()
    m1.+=("a" -> 1)
    m1.+=("b" -> 2)
    m1.+=("c" -> 3)
    m1.foreach { x =>
      if (m1.contains(x._1)) {
        m1.-=(x._1)
      }
    }

    println("**"+m1.mkString(","))

  }
  

  def threadSafetyMap1(){
    val info = mapContainer.getMiddelMap()
    val ran = new Random
    var k = 0
    while(true){
      k = k+1
      val v = ran.nextInt(10000)
      info.+=(k->v)
      //println("add---->"+k)
    }
  }  
}


