package learn.reflect.scala

/**
 * scala反射
 */
object RefTest extends App{
//  import scala.reflect.runtime.universe
//  import scala.reflect.runtime.universe._
//   
//  case class MyClass(x: Int)
//   
//  val myRuntimeMirror: RuntimeMirror = universe.runtimeMirror(getClass.getClassLoader)
//   
//  val classSymbol: ClassSymbol = typeOf[MyClass].typeSymbol.asClass
//  val classMirror: ClassMirror = myRuntimeMirror.reflectClass(classSymbol)
//   
//  val methodSymbol: MethodSymbol = typeOf[MyClass].declaration(universe.termNames.CONSTRUCTOR).asMethod
//  val constructorMethod: MethodMirror = classMirror.reflectConstructor(methodSymbol)
//   
//  val res = constructorMethod(4)
//   
//  println(res)  // MyClass(4)   
}