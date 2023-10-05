package classproperty;

import java.util.Arrays;

//'Class' property /.class property in java app
@SuppressWarnings("serial")
public class App1 implements java.io.Serializable {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		Class c1 = App1.class;
		System.out.println("c1 obj class name: " + c1.getClass()); // gives java.lang.class
		System.out.println("c1 obj data: " + c1.toString());// gives App1
		System.out.println("c1 obj's data class name: " + c1.getName()); // gives App1
		System.out.println("c1 obj's class super class name: " + c1.getSuperclass()); // java.lang.object
		System.out.println("c1 obj's data list of implemented interface: " + Arrays.toString(c1.getInterfaces()));
		// gives java.io.Serializable interface
		System.out.println("c1 obj's data class list of methods: " + Arrays.toString(c1.getDeclaredMethods()));
		// gives methods of App1 (main 1(-))

		System.out.println("===========================================================");
		Class c2 = System.class;
		System.out.println("c2 obj class name: " + c2.getClass());
		System.out.println("c2 obj data: " + c2.toString());
		System.out.println("c2 obj data class name: "+c2.getName());
		System.out.println("c2 obj class super class name: "+c2.getSuperclass());
		System.out.println("c2 obj data  class list of implemented interface: "+Arrays.toString(c2.getInterfaces()));
		System.out.println("c2 obj data class list of methods: "+Arrays.toString(c2.getDeclaredMethods()));
	}

}
