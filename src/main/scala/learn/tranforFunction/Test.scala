package learn.tranforFunction

import org.apache.spark.rdd.RDD

/**
 * 在scala中，我们可以把定义的内联函数、方法的引用或静态方法传递给Spark，就想scala的其它函数式API一样。但是需要注意两点：
		a. 所传递的函数及其一弄的数据需要是可序列化的(实现了Serializable接口)；
		b. 当我们仅仅是传递一个对象的方法或字段的时候，可以将需要的字段放到一个局部变量中来避免传递包含该字段的整个对象
		
		如下边的例子，前两个get函数都引用了整个对象，导致引用的东西冗余，最后一个合适，只引用了需要的字段
 */
object Test {
}

class SearchFunctions(val query: String){
  def isMatch(s: String): Boolean = {
    s.contains(query)
  }
  
  def getMatchesFunctionReference(rdd: RDD[String]): RDD[Boolean] = {
    //问题："isMatch"表示“this.isMatch”,因此我们要传递整个this
    rdd.map(isMatch)
  }
  
  def getMatchesFieldReferencd(rdd: RDD[String]): RDD[Array[String]] = {
    //问题：“query”表示“this.query”,因此我们要传递整个this
    rdd.map { x => x.split(query) }
  }
  
  def getMatchesNoReference(rdd: RDD[String]): RDD[Array[String]] = {
    //安全：只把我们需要的字段拿出来放入局部变量中
    val query_ = this.query
    rdd.map { x => x.split(query_) }
  }
}