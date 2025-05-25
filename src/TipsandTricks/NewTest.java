package TipsandTricks;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class NewTest {
//      WebDriver driver ;
//	  @Test
//	  public void f() {
//		      System.setProperty("wedriver.chrome.driver", "E:\\Selenium 2\\Chrome Driver\\chromedriver.exe");
//	          String baseUrl = "https://www.toolsqa.com/";
//	          System.out.println("Launching Google Chrome browser"); 
//	          driver = new ChromeDriver();
//	          driver.get(baseUrl);
//	          String testTitle = "Free QA Automation Tools Tutorial for Everyone";
//	          String originalTitle = driver.getTitle();
//	          try {
//	          Assert.assertEquals(originalTitle, testTitle);
//	          }
//	          catch(Exception e) {
//	        	 System.out.println(e.getMessage());
//	          }
//		  System.out.println("This is 1st test method");
//	   }
	
	
	//If there are multiple parameters then you will have to use curly braces otherwise for one parameter
	  //you can directly write under closed brackets ().
	  @Test
	  @Parameters ("Message1")
	  public void messaga1(@Optional("Akshay Aathale")String message) {
		  System.out.println("Hello " + message);
	  }  

	  @Test(dataProvider= "Parameters")
	  public void messaga(String message) {
		  System.out.println("Hello " + message);
	  }
	  
	  //import java.lang.reflect.Method; incase you are passing method as parameter
	  @DataProvider(name ="Parameters")
	  public Object[][] dp(Method m){
		  return new Object[][] {{"Akshay"},{"Kimaya"}};
		  
		  }
	  @Test(dependsOnGroups = {"Smoke"})
	  public void Case1() {
		  System.out.println("Case1");
	  }
	  @Test(groups = {"Demo","Smoke"})
	  public void Case2() {
		  System.out.println("Case2");
	  }
	  @Test(groups = {"Smoke"})
	  public void Case3() {
		  System.out.println("Case3");
	  }
	  @Test(groups = "Demo")
	  public void Case4() {
		  System.out.println("Case4");
	  }
	  @Test
	  public void Case5() {
		  System.out.println("Case5");
	  }
		  
		  
	  }
	  
	 
	  
	  
	  
	  

	  

