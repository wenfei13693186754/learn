package learn.future

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
 * scala.concurrent.Future是Scala提供的一个并发工具，其中的API是使用隐含参数来减少代码冗余的。
 * 当你将任务封装到Future中执行时，该任务的执行时异步的，
 *
 * Future API允许我们通过ExecutionContext来配置并发操作的执行，上边import语句导入了默认的ExecutionoContext，使用
 * 了java的ForkJoinPool设置来管理java线程池
 */
object FutureDemo extends App {
  def sleep(mills: Long) {
    Thread.sleep(mills)
  }

  //繁忙的处理工作
  def doWork(index: Int) = {
    sleep((math.random * 1000).toLong)
    index
  }

  (1 to 5) foreach { index =>
    val future = Future {
      doWork(index)
    }

    future.onSuccess {
      case answer: Int => println(s"Success! returned: $answer current thread is ${Thread.currentThread().getId}")
    }

    future.onFailure {
      case th: Throwable => println(s"FAILURE! returned: $th current thread is ${Thread.currentThread().getId}")
    }
  }

  sleep(1000)
  println("Finito")
}



