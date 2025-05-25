package TipsandTricks;

import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;



public class Log4j {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Automation Setup\\drivers\\chromedriver.exe");	
	      SoftAssert sassert = new SoftAssert();
	      
	      //Below line is commented because properties file is placed under src folder
		 //PropertyConfigurator.configure("log4j.properties");
		 Logger logger=Logger.getLogger(Log4j.class.getName());
	     
		 WebDriver driver = new ChromeDriver();
	     logger.info("Browser Opened");
	     
	     // Load application
	      driver.get("https://www.google.co.in/");
	      logger.info("Url opened");
	      System.out.println(driver.getTitle());
	     
	      // Set implicit wait
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     logger.info("Implicit wait given");
	     sassert.assertAll();

		  //type Selenium
		 driver.findElement(By.name("q")).sendKeys("Selenium");
		 logger.info("keyword type"); 
		 
	   

	     String x = "Akshay";
	     sassert.assertNull(x,"x is not null");
	        
	}
	
	public static String takeScreenshot(WebDriver driver) {
		   
		   TakesScreenshot ts = (TakesScreenshot)driver;
		   File source = ts.getScreenshotAs(OutputType.FILE);
		   String Path = "./Screenshots/Screenshot"+System.currentTimeMillis()+".png";
		   File Destination = new File(Path);
		   
		   try {
			   //FileHandler.copy(source, Destination);
			   //Above line or below line both does the same, but for below line of code
			   //you need to install separate org.apache.commons.io.jar 
			   FileUtils.copyFile(source, Destination);
		   }
		   catch(IOException e){
			  e.printStackTrace();
			   
		   }

		return Path;
	   
	   }
	
}
