package learn.算子

object forTest {
	val a = Array("apple", "banana", "orange")
  def main(args: Array[String]): Unit = {
    //for循环计数器
    forCircleCounter
    
    //创建for表达式（for/yield组合）
    //forExpression
    
    //遍历map
    //throughMap
    
    //for循环中嵌入if语句（卫语句）
    letWeiLanguageIntoFor
  }
  
  //for循环计数器
  def forCircleCounter(){
    
    //通过计数器访问数组元素
    for(i <- 0 until a.length){
      println(s"$i is ${a(i)}")
      /*
       *  0 is apple
          1 is banana
          2 is orange
       */
    }
    
    //scala还提供了一个zipWithIndex的方法，用来创建一个循环计数器
    for((e, count) <- a.zipWithIndex){
      println(s"$count is $e")
      /*
       *  0 is apple
          1 is banana
          2 is orange	
       */
    }
    
    //在for循环中使用多个计数器
    for{
      i <- 1 to 2
      j <- 1 to 2
    } println(s"i = $i, j = $j")
    /*
     *  i = 1, j = 1
        i = 1, j = 2
        i = 2, j = 1
        i = 2, j = 2
     */
    
    //使用三个计数器
    for{
      i <- 1 to 2
      j <- 1 to 2
      k <- 1 to 2
    }println(s"i = $i, j = $j, k = $k")
    
    //for循环遍历二维数组
    val array = Array.ofDim[Int](2,2)
    array(0)(0) = 0
    array(0)(1) = 1
    array(1)(0) = 2
    array(1)(1) = 3
    for{
      i <- 0 to 1
      j <- 0 to 1
    }println(s"($i)($j) = ${array(i)(j)}")
  }
  
  /*
   * 创建for表达式（for/yield组合）
   * 对一个已有的集合中的每个元素应用一个算法(可能包含多个卫语句)，从而生成一个新的集合
   * 
   * 除了极个别情况，for推导不会改变集合的返回类型，例如遍历的集合是Array，那么返回的还是Array类型的，如果遍历的集合是List，那么返回的也是List
   */
  def forExpression(){
    val newArray1 = for(e <- a) yield e.toUpperCase//这里返回的是a数组中所有元素的大些形式
    
    //当算法需要多行代码才能解决的时候，可以将其放入到yield关键字后边的代码块中
    val newArray2 = for (e <- a) yield {
      val s = e.toUpperCase()
      s
    }
  }
  
  //遍历map
  def throughMap(){
	  val names = Map("fname" -> "Robert", "lname" -> "Goren")
	  for((k, v) <- names) println(s"key: $k, value: $v")
    /*
     * key: fname, value: Robert
			 key: lname, value: Goren
     */
  }
  
  /*
   * for循环中嵌入if语句（卫语句）
   * 这些if语句称为过滤器，过滤表达式或者卫语句，代码中使用卫语句会使得代码更加简洁可读
   * 
   * 一旦习惯了scala的for循环，会发现代码更加可读，因为它分离了循环和业务逻辑
   */
  def letWeiLanguageIntoFor(){
	  for(i <- 0 to 10 if i%2 == 0) println(i)
	  
	  //或者使用大括号
	  for{
	    i <- 1 to 10
	    if i%2 == 0
	  }println(i)
	  
	  //或者使用传统方式
	  for(i <- 0 to 10){
	    if(i%2 == 0){
	      println(i)
	    }
	  }
  }
  
}















