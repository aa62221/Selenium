package TipsandTricks;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoIT {
	public static void main(String[] args) {
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Automation Setup\\drivers\\chromedriver133.exe");
     WebDriver driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.get("https://demoqa.com/automation-practice-form");
     driver.findElement(By.cssSelector("input#uploadPicture.form-control-file")).click();
     
     
//     Actions action = new Actions(driver);
//     action.sendKeys(Keys.SHIFT,"Test");
//     String s =Keys.chord(Keys.SHIFT+"A");
//     action.sendKeys(s);
 
    		
     try {
		Runtime.getRuntime().exec("C:\\Users\\dell\\Desktop\\AutoITFile");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
     
   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // 10-second timeout
   wait.ignoring(ElementNotInteractableException.class).until(ExpectedConditions.visibilityOfElementLocated(By.id("elementID")));
     
   
   //Key Difference between WebDriverWait and FluentWait is 
   //🕒 Polling Frequency	Default: 500 milliseconds(WebDriverWait)	You can customize it (e.g., 2 sec)(FluentWait)
   //❌ Ignore Exceptions	Only NoSuchElementException by default	    Can ignore multiple exceptions
   
  FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
  fluentWait.withTimeout(Duration.ofSeconds(10))          // Max wait time
  	        .pollingEvery(Duration.ofSeconds(1))          // Poll every second
  	        .ignoring(NoSuchElementException.class)     // Ignore NoSuchElementException   	
            .until(ExpectedConditions.visibilityOfElementLocated(By.id("elementID")));
  
}
	
}
