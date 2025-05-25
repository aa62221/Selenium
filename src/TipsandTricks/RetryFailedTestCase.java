package TipsandTricks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.TestNG;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class RetryFailedTestCase{
	
	@Test
	public void method() {
		Assert.assertTrue(false);
		
	}

//	Below method will execute only when the failed.xml is present.
	@Test
	public void failedTestCase() {
		TestNG runner = new TestNG();
		
		List<String> list = new ArrayList<String>();
		//Add path of testng-failed.xml in the list
		list.add("E:\\Eclipse workspace\\Selenium\\test-output\\testng-failed.xml");
		try {
		runner.setTestSuites(list);
		System.out.println("failed test case executed again");
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
	
}
	
	

