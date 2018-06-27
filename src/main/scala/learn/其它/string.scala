package com.wdcloud.scalaDemo

object string {
  def main(args: Array[String]): Unit = {
    val str = "asdasd"
    val aa = "hello"
    val index = str.lastIndexOf("a")
    //val ss = str.updated(index, aa+" "+aa.charAt(0)).mkString
    val ss = str.replaceFirst("as", aa)
    //val ss = str.updated(index, "d")
    println(ss.split(",").size)
    println(aa.length())
    val str1 = "  "
    println(str1.trim().isEmpty())
  }
}