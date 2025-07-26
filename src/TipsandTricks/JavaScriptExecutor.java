package TipsandTricks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class JavaScriptExecutor {
	
		public static void main(String[] args) {
			try {
			 System.setProperty("webdriver.chrome.driver", "E:\\Selenium 2\\Chrome Driver\\Version 96\\chromedriver.exe");		 
			 WebDriver driver = new ChromeDriver();
			 driver.get("https://opensource-demo.orangehrmlive.com/index.php/leave/viewLeaveList");
			 driver.manage().window().maximize();
			 String expectedTitle = "Free QA Automation Tools For Everyone";
		     String originalTitle = driver.getTitle();
		     Assert.assertEquals(originalTitle, expectedTitle);
			 WebElement username =driver.findElement(By.id("txtUsername"));
			 
			 
		
		  //JavaScriptExecutor is an interface that provides a mechanism to execute Javascript through selenium driver.
			 
			 
		     //Code to send text inside textbox without using sendkeys
			 JavascriptExecutor js = (JavascriptExecutor)driver;
			 js.executeScript("arguments[0].value='admin'",username);
			 //or js.executeScript("document.getelementById("uniqueID").value='admin'");
			
			 //to create alert
			 js.executeScript("alert('hello world');");
			
			//to click element
			js.executeScript("arguments[0].click();", username);
			
			//to refresh browser
			js.executeScript("history.go(0)");
			
			//innerText of Webpage
			js.executeScript("return document.documentElement.innerText;").toString();
			
			//get title of web page
			String sText =  js.executeScript("return document.title;").toString();
			System.out.println(sText);
			
			//to find the total number of iFrames on the web page
			Integer numberOfFrames = Integer.parseInt(js.executeScript("return window.length").toString());
			System.out.println("Number of iframes on the page are " + numberOfFrames);
			
			//to reduce the zoom level of the window to 75%
			js.executeScript("document.body.style.zoom='"+ 75 + "';");
			
			}
			 catch(AssertionError e) {
					System.out.println("Assertion caught");
				}
			
//			<custom-component>
//			  #shadow-root
//			    <input id="shadowInput" type="text">
//			</custom-component>

			//to handle shadow DOM elements
//	         WebElement shadowHost = driver.findElement(By.cssSelector("custom-component"));
//			 WebElement shadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost);
			
		     
	}
		
		
}
