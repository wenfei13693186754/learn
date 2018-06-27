package jvm;

/**
 * 验证jvm栈溢出问题
 * 
 * java栈溢出
 * 在java虚拟机规范中对这个区域规定了两种异常情况，分别是StackOverflowErro和OutOfMemory异常
 * 
 * 1.StackOverflowErro异常
 * 		每当java程序代码启动一个新线程时，java虚拟机都会为它分配一个java栈，java栈以帧为单位保存线程的运行
 * 状态。当线程调用java方法时，虚拟机压入一个新的栈帧到该线程的java栈中。只要这个方法还没有返回，它就一直存在。
 * 如果线程的方法嵌套调用层次太多（如递归调用），随着java栈中帧的逐渐增加，最终会由于该线程java栈中所有栈帧的
 * 大小总和大小大于-Xss设置的值，而产生StackOverflowErro内存溢出异常。
 * -Xss是每个线程java栈的大小
 * 当设置-Xss为128k的时候，count最大为969；
 * 当设置-Xss为1280k的时候，count最大为14380.
 * @author hadoop
 *
 */
public class StackOverflowError {
	
	private int count = 0;
	
	public static void main(String[] args) {
		new StackOverflowError().method();
	}
	
	public void method(){
		System.out.println(++count);
		method();
	}
}
