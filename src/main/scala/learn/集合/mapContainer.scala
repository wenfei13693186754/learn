package learn.集合

import scala.collection.mutable.HashMap
import scala.collection.mutable.SynchronizedMap

object mapContainer {
  @volatile private var info = new HashMap[Int, Int]() with SynchronizedMap[Int, Int]
  def getMiddelMap(): HashMap[Int, Int] = {
    if (info == null) {
      synchronized {
        if (info == null) {
          info = new HashMap[Int, Int]() with SynchronizedMap[Int, Int]
        }
      }  
    }
    info
  }
}