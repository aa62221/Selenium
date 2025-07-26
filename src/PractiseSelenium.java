import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class PractiseSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Automation Setup\\drivers\\chromedriver133.exe");
		 ChromeOptions options = new ChromeOptions();
         options.addArguments("--start-maximized");
         WebDriver driver = new ChromeDriver(options);
	     driver.manage().window().maximize();
	     driver.get("https://demoqa.com/automation-practice-form");
	     WebElement ele=  driver.findElement(By.xpath("//input[@id='firstName']"));
	     ele.sendKeys(Keys.SHIFT,"Akshay","Athale");
	     
	     
	     Actions action = new Actions(driver);
	     
	     action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).build().perform();
	     action.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).build().perform();
	     action.sendKeys(Keys.TAB).build().perform();
	     action.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).build().perform();
	     
	     
	  
	     
	     
	     		
	}

}
