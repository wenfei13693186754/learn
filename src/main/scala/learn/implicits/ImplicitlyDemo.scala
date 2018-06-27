package learn.implicits

/**
 * Predef对象定义了一个名为implicitly的方法,如果将implicitly方法与附加类型签名（type signature addition）相结合，
 * 便能以一种有用且快捷的方式定义一个接收参数化类型隐式参数的函数
 */
object ImplicitlyDemo extends App{
  val list = MyList(List(1,6,2,9,5))
  println("sortBy1: "+list.sortBy1 { x => -x })
  println("sortBy2: "+list.sortBy2 { x => -x })
}

case class MyList[A](list: List[A]){
  def sortBy1[B](f: A=>B)(implicit ord: Ordering[B]): List[A]={ 
    list.sortBy(f)(ord)
  }
  
  def sortBy2[B: Ordering](f:A=>B):List[A]={
    list.sortBy(f)(implicitly[Ordering[B]])
  }
}