package com.wdcloud.scalaDemo

object preDemo {
  def main(args: Array[String]): Unit = {
    val x:Double=>Unit=(a:Double)=>println(a)
    x(11.0)
    
 
    def high(list:List[Int],f:(Int,Int,Int)=>Int)={
      println("高阶函数"+f(list(0),list(1),list(2)))
    }
    high(List(1,2,3),(a,b,c)=>(a+b+c))
    high(List(3,4,5),_+_+_)
    
    def high1[T](list:List[T],f:(T,T,T)=>T)={
      println(f(list(0),list(1),list(2)))
    }
    //high1(List("1","2","3"),(a,b,c)=>a+b+c)//报错
    
    def high2[T](list:List[T])=(f:(T,T,T)=>T)=>{
      println(f(list(0),list(1),list(2)))
    }
    high2(List(1,2,3))(_+_+_)
    
    //闭包
    def add(more:Int) = (x:Int)=>x+more
    //给more赋值
    val add1 = add(1)
    println(add1)
    //调用add函数
    println(add1(100))
    
    def a(a:Int)={a+3}
    println(a(1))
    def addByName(a: Int, b:Int => Int)={
    	println(a+":"+b)
    }  
    addByName(5,a=>2)
    def addByValue(a:Int, b:Int =>Int) = {
      a +""+ b
    } 
    println(addByValue(1,a=>2))		
  }
  

}