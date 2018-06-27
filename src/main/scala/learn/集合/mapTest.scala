package learn.集合
import scala.collection.mutable.HashMap
import scala.collection.mutable.SynchronizedMap
import java.util.Random
import scala.collection.concurrent.TrieMap

object mapTest {
  def main(args: Array[String]): Unit = {
    //threadSafetyMap2()
    val info = TrieMap[String,Int]()
    info.+=("a"->1)
    info.+=("b"->2)
    if(info.contains("c")){
      println("**")
    }
  }
  def threadSafetyMap2(){
    val ran = new Random
    var k = 0
    while(true){
    	val info = mapContainer.getMiddelMap()
      if(info.contains(k)){
    	  info.-=(k)
        println(k)
      }
    	k = k+1
    	Thread.sleep(1000)
    }
  }  
}