//package TipsandTricks;
//
//import java.io.File;
//import java.io.IOException;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.io.FileHandler;
//import org.testng.Assert;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import com.aventstack.extentreports.ExtentReporter;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.utils.FileUtil;
//
//public class ExtentReportWithScreenshot {
//	
//	static ExtentReports setReport;
//	static ExtentTest logCase;
//	static ExtentTest logStep;
//	static WebDriver driver;
//	
//   @BeforeClass
//   public void setUp() {
//	   ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/ExtentReport.html");
//	   setReport = new ExtentReports();
//	   setReport.attachReporter(reporter);
//	  
//   }
//   
//   @Test
//   public void firstTestCase() {
//	  logCase= setReport.createTest("FirstCase", "Testing Extent Report");
//	
//      System.setProperty("webdriver.chrome.driver", "E:\\Selenium 2\\Chrome Driver\\Version 96\\chromedriver.exe");
//      driver= new ChromeDriver();
//      driver.get("https://www.google.co.in/");
//      driver.manage().window().maximize();
//   
//     logStep = logCase.createNode("Step1", "Get Title");  
//     try {
//      String Title= driver.getTitle();
//      System.out.println(Title);
//      logStep.info("Title is "+ Title); 
//      Assert.assertTrue(false);
//      //Assert.assertEquals(Title, "Amazon");	    
//      logStep.log(Status.PASS, "Test Case is passed");
//      logStep.info("Test Case is passed");
//     
//    
//     }
//     //To catch an assertion pass Assertion error as parameter in catch block
//     catch(AssertionError e) {
//    	 logStep.fail("Title verification failed");
//    	 logStep.log(Status.FAIL, "Test Case is failed");
//    	 
//     }
//
//   }
//   
//
//   @AfterMethod
//   public static void  status(ITestResult result) throws IOException {
//	  
//	   if(result.getStatus()==ITestResult.FAILURE) {
//		   String temp= Log4j.takeScreenshot(driver); 
//		  logStep.addScreenCaptureFromPath(temp);
//		// logCase.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
//	   }
//	   driver.quit();
//	// This will add another test in report
//	   setReport.flush();
//	     
//   }
//   
//   
//		
//}
