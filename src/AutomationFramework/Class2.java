package AutomationFramework;

import org.testng.annotations.Test;

public class Class2 {
	
	@Test(priority=1)
	public static void m1() {
		System.out.println("Class2 m1 methods");
	}
	
	@Test(priority=2)
	public static void m2() {
		System.out.println("Class2 m2 methods");
	}

	@Test(priority=3)
	public static void m3() {
		System.out.println("Class2 m3 methods");
	}
	
	
}
