package jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * jvm 堆内存泄漏问题
 * 内存泄漏是指的，内存中有大量没有用的对象，但是仍然被引用，没有被垃圾回收掉，一直积累，直到没有剩余内存可用，最终导致内存泄漏。
 * 
 * @author hadoop
 *
 */
public class HeapOutOfMemoryDemo1 {
	public static void main(String[] args) {
		List<UUID> list = new ArrayList<UUID>();
		while(true){
			list.add(UUID.randomUUID());
		}
	}
}
