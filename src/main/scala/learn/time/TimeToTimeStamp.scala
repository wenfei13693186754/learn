package learn.time

import java.text.SimpleDateFormat
import java.sql.Timestamp
import java.util.Date


/**
 * 时间和时间戳的相互转化
 */
object TimeToTimeStamp {
  def main(args: Array[String]): Unit = {
    getTimeStamp("2017-09-08 19:47:56")
    getTime("1511772993484")
  }  

  /**
   * 时间转化为时间戳
   */
  def getTimeStamp(time: String) {    
    val sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val d = sdf.parse(time)
    println(time + "----" + d.getTime)
  }
  
  /**
   * 将时间戳转化为时间  
   */
  def getTime(ts: String){
    val sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val date = new Date(ts.toLong)
    val time = sdf.format(date)
    println(ts+"----"+time)
  }
}