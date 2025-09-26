import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PractiseSelenium {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
////		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Automation Setup\\drivers\\chromedriver133.exe");     
//	     Actions action = new Actions(driver);
//	     
//	     action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).build().perform();
//	     action.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).build().perform();
//	     action.sendKeys(Keys.TAB).build().perform();
//	     action.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).build().perform();
		
		//--------------------------------------------------------------------------------------------------
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
	    driver.manage().window().maximize();
	    driver.get("https://demoqa.com/automation-practice-form");
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	    
	    WebElement first=  driver.findElement(By.xpath("//input[@id='firstName']"));
	    first.sendKeys(Keys.SHIFT,"Nick",Keys.SPACE, "Patrick");
	    WebElement last=  driver.findElement(By.xpath("//input[@id='lastName']"));
	    last.sendKeys(Keys.SHIFT,"Jonas");
	    WebElement email=  driver.findElement(By.xpath("//input[@id='userEmail']"));
	    email.sendKeys("nickjonas.m09@gmail.com");
	    WebElement num=  driver.findElement(By.xpath("//input[@id='userNumber']"));
	    num.sendKeys("9012658930");
	    
	    driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\Dell\\Desktop\\Study Material\\EclipseWorkspace\\Selenium\\src\\TestData\\ProfilePhoto.jpeg");
        driver.findElement(By.id("currentAddress")).sendKeys("US");
        
	    Actions action = new Actions(driver);
	    
	    action.sendKeys(Keys.TAB).perform();
	    Thread.sleep(2000);
	    action.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
	    Thread.sleep(2000);
	    action.sendKeys(Keys.TAB);
	    Thread.sleep(2000);
	    action.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER);


	   
	     
	    
	     
	  
	     
	     
	     		
	}

}
