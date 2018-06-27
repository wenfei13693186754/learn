package jvm;

/**
 * 栈的OutOfMemoryError异常
 * java程序代码启动一个新的线程时候，没有足够的内存空间为该线程分配java栈
 * （一个线程java栈的大小由-Xss决定），jvm就会抛出OutOfMemoryError异常
 * @author hadoop
 *
 */
public class StackOutOfMemoryError {
	public static void main(String[] args) {
		int count = 0;
		while(true){
			Thread t = new Thread(new Runnable(){

				@Override
				public void run() {
					while(true){
						try {
							Thread.sleep(5000);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				
			});
			t.start();
			System.out.println(++count);
		}
	}
}
