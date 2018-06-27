package learn.javaWithScala;

/**
 * 在java应用程序中调用一个已经完成了的Scala特质与实现的方法，需要把特质包装到一个类中
 * @author Administrator
 * 注意：
 * 		静态方法中只能引用静态的方法和成员变量
 * 		非静态方法可以引用静态的或者非静态的方法和成员变量
 *
 */
public class JavaMath extends MathTraitWrapper{
	public static void main(String[] args) {
		new JavaMath();
		//System.out.println(sum(2, 3));
	}
	
	public JavaMath(){
		System.out.println(sum(2, 3));
	}
	
	public void aa(){
		System.out.println(sum(2, 3));
	}
}
