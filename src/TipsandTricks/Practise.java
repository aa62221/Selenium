//package TipsandTricks;
//
//import java.awt.AWTException;
//import java.awt.Robot;
//import java.awt.event.KeyEvent;
//import java.time.Duration;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Reporter;
//import org.testng.annotations.Test;
//
//public class Practise extends ExtentReportWithScreenshot {
//	
//@Test
//public static void driver() {
//	
//	logCase= setReport.createTest("FirstCase", "Testing Extent Report");
//	logStep = logCase.createNode("Step1", "Get Title"); 
//	
//	System.setProperty("wedriver.chrome.driver", "E:\\Selenium 2\\Chrome Driver\\Version 99\\chromedriver.exe");
//	WebDriver driver = new ChromeDriver();
//	driver.get("https://www.toolsqa.com/");
//	
//	WebElement el = driver.findElement(By.id("abc"));
//	el.sendKeys(Keys.CONTROL + "1");
//	
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	Alert ele =wait.until(ExpectedConditions.alertIsPresent());
//    driver.manage().deleteAllCookies();
//   
//   try {
//	Robot rb = new Robot();
//	rb.keyPress(KeyEvent.VK_CONTROL);
//
//} catch (AWTException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
//   
//	
//}
//
//
//}