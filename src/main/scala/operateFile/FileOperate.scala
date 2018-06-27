package operateFile

import java.io.BufferedWriter
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.FileWriter
import java.io.IOException
import java.io.PrintWriter

import scala.io.BufferedSource
import scala.io.Source

import akka.event.slf4j.Logger

/**
 * file文件读写操作
 */
object FileOperate {

  def main(args: Array[String]): Unit = {
    //bytesReadAndWrite
    //writeFileByPrintWriter
    //writeFileByFileWriter
    //writeFileByBufferedWriter
    val path = "E:\\实时在线系统\\实时用户统计\\test.txt"
    //readTextFile(path)
    deleteFile(new File(path))
  }

  val logger = Logger(this.getClass.getName)

  /**
   * 读取text文件模板
   * 本模板根据输入文件的路径，读取文件，具体处理逻辑在内部自己写
   */
  def readTextFile(path: String) {
    var bs: BufferedSource = null
    try {
      bs = Source.fromFile(path)
      val lines = bs.getLines()

      //{这里写方法体}
      while(lines.hasNext){
        println(lines.next().split(",").size)
      }
    } catch {
      case e: FileNotFoundException => logger.error("{" + path + "} file not found")
      case e: IOException           => logger.error("Got a IOException")
    } finally {
      bs.close
    }
  }

  /**
   * 实现向文件中写文件的时候追加内容
   */
  def writeFileByFileWriter() {
    val path = "offLineUsers.txt"
    val fw = new FileWriter(path, true)
    (11 to 20).foreach { x =>
      fw.append(s"$x").write(",")
    }
    fw.flush()
    fw.close()
  }

  /**
   * scala不提供任何特殊文件写入能力，所以使用的是java的api
   * 	这里使用PrintWwriter写纯文本文件
   *这里PrintWriter第二个参数，如果是false，也就是不自动刷新，那么会导致部分数据丢失。所以一般设置为true
   */
  def writeFileByPrintWriter() {
    val path = "E:\\实时在线系统\\实时用户统计\\test.txt"
    val fos = new FileOutputStream(path)
    val pw = new PrintWriter(fos, false)
    (1 to 10).foreach {
      x =>
        pw.append(s"$x").write(",")
    }
    pw.flush()
    pw.close()
  }

  /**
   * scala不提供任何特殊文件写入能力，所以使用的是java的api
   * 	这里使用FileWwriter写纯文本文件
   */
  def writeFileByBufferedWriter() {
    val path = "../offLineUsers.txt"
    val bw = new BufferedWriter(new FileWriter(new File(path)))
//    (0 to 10).foreach { x =>
//      bw.append(s"data: $x").write("\n")
//    }
    
    val set = Set[String]("a","b","c事实上 ","d","e")
    bw.append(set.mkString(",")).write("\n")
    bw.flush
    bw.close
  }

  /**
   * 二进制文件的读写
   */
  def bytesReadAndWrite() {
    var in = None: Option[FileInputStream]
    var out = None: Option[FileOutputStream]

    try {
      in = Some(new FileInputStream("D:\\workplace-scala\\recBasedGraphxWithCombine\\target\\classes\\com\\wdcloud\\graphx\\recommend\\ReadData.class"))
      out = Some(new FileOutputStream("D:\\workplace-scala\\scala\\copyReadData.class"))
      var c = 0
      while ({ c = in.get.read; c != -1 }) {
        out.get.write(c)
      }
    } catch {
      case e: IOException => e.printStackTrace()
    } finally {
      logger.warn("entered finally...")
      if (in.isDefined) in.get.close()
      if (out.isDefined) out.get.close()
    }

    logger.warn("二进制文件读写完成")
  }
  
  //文件或者文件夹的删除
  //需要注意的是，删掉文件之前，要保证文件没有被正在使用。比如，
  //使用val source = Source.fromFile(file),读取文件内容，
  //操作完成后，如果没有进行source.close(),那么后边调用file.delete()就会失败
  def deleteFile(path: File){
     if (!path.exists())  
      return  
    else if (path.isFile()) {  
      path.delete()  
      println(path + ":  文件被删除")  
      return  
    }  
  
    val file: Array[File] = path.listFiles()  
    for (d <- file) {  
      deleteFile(d)  
    }  
  
    path.delete()  
    println(path + ":  目录被删除")  
  
  }
}

















