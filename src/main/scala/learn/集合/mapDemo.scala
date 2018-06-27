package com.wdcloud.scalaDemo

/*
 * map操作
 */
object mapDemo {
  def main(args: Array[String]): Unit = {
    var map:Map[Char,Int] = Map()
    val map1 = Map("red" -> "123456", "blue" -> "123123", "black" -> "432423")
    val str = map1.mkString
    println(str)//red -> 123456blue -> 123123black -> 432423  
    
    //在集合中添加元素
    map += ('A' -> 1)
    map += ('B' -> 2)
    map += ('C' -> 3)
    map.+('D' -> 4)
    println("\\\\"+map.mkString)//A -> 1B -> 2C -> 3
    
    println("keys in map : "+map.keys)//keys in map : Set(A, B, C)
    println("values in map : "+map.values)//values in map : MapLike(1, 2, 3)
    println("check map1 empty : "+map1.isEmpty)//check map1 empty : false
    
    //映射的连接
    //使用++方法实现。这个方法用来连接两个或者更多的映射，但同时增加了映射，将删除重复的键
    val colors1 = Map("red" -> "#FF0000",
                        "azure" -> "#F0FFFF",
                        "peru" -> "#CD853F")
    val colors2 = Map("blue" -> "#0033FF",
                      "yellow" -> "#FFFF00",
                      "red" -> "#FF0010")
                      
    var colors = colors1 ++ colors2
    println("colors1++colors2: "+colors)
    //colors1++colors2: Map(blue -> #0033FF, azure -> #F0FFFF, peru -> #CD853F, yellow -> #FFFF00, red -> #FF0000)
    val aa = colors1.toList.++(colors2.toList)
    println("colors1.++(colors2): "+aa)
    //colors1.++(colors2): Map(blue -> #0033FF, azure -> #F0FFFF, peru -> #CD853F, yellow -> #FFFF00, red -> #FF0000)
 
    //遍历映射的键值
    //Key = red Value = #FF0000
    //Key = azure Value = #F0FFFF
    //Key = peru Value = #CD853F
    val c0 = Map("red" -> "#FF0000",
                       "azure" -> "#F0FFFF",
                       "peru" -> "#CD853F")
    c0.keys.foreach { x => 
      print("Key = "+x) 
      println(" Value = "+c0(x))
      }
    
    //检查映射中的键
    //Red key exists with value :#FF0000
    //Maroon key does not exist
    val c1 = Map("red" -> "#FF0000",
                       "azure" -> "#F0FFFF",
                       "peru" -> "#CD853F")

      if( c1.contains( "red" )){
           println("Red key exists with value :"  + c1("red"))
      }else{
           println("Red key does not exist")
      }
      if( c1.contains( "maroon" )){
           println("Maroon key exists with value :"  + c1("maroon"))
      }else{
           println("Maroon key does not exist")
      }
  }
}












