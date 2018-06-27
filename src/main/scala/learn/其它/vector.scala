package com.wdcloud.scalaDemo

object vector {
  def main(args: Array[String]): Unit = {
    var v: Vector[Int] = Vector(1,2,3)
    v = v.+:(4)
    println(v.mkString(","))
  }
}