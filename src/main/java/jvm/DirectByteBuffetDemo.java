package jvm;

import java.nio.ByteBuffer;

/**
 * 用来测试jvm的对外内存的使用
 * 
 * @author hadoop
 *
 */
public class DirectByteBuffetDemo {

	// jvm参数：-verbose:gc -XX:PrintGCDetails -XX:MaxDirectMemorySize=40m
	public static void main(String[] args) {
		while (true) {
			ByteBuffer buffer = ByteBuffer.allocateDirect(10 * 1024 * 1024);
		}
	}
}
