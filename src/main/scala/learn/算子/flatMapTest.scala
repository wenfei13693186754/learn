package learn.算子

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

/**
 * flatMap测试
 */
object flatMapTest {
  def main(args: Array[String]): Unit = {
	  val conf = new SparkConf().setAppName("test").setMaster("local[*]")
	  val sc = new SparkContext(conf)
	  
    val rdd = sc.makeRDD(List("hadoop spark", "spark hive"));
    val fm = rdd.flatMap{ x => x.split(" ") }  
    
    fm.foreach { x => println(x) } 
    /*
     *  spark
        hive
        hadoop
        spark
     */
  }
}