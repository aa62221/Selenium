package AutomationFramework;

import org.testng.annotations.Test;

public class Class1 {
	
	@Test(priority=1)
	public static void n1() {
		System.out.println("Class1 n1 methods");
	}

	@Test(priority=2)
	public static void n2() {
		System.out.println("Class1 n2 methods");
	}

	@Test(priority=3)
	public static void n3() {
		System.out.println("Class1 n3 methods");
	}


}
