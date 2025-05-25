package TipsandTricks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ScrollWebPage {

	public static void main(String[] args) throws InterruptedException {

		     System.setProperty("webdriver.chrome.driver", "E:\\Selenium 2\\Chrome Driver\\Version 96\\chromedriver.exe");
			 WebDriver driver = new ChromeDriver();
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
			 driver.get("https://www.flipkart.com/womens-clothing/pr?sid=2oq,c1r&amp;otracker=hp_nmenu_sub_women_1_View%20all");	 
			 driver.manage().window().maximize(); 
			 JavascriptExecutor jsx = (JavascriptExecutor)driver; 
			 //scroll down 
			  jsx.executeScript("window.scrollBy(0,4500)", "");

			 //scroll up
			  jsx.executeScript("window.scrollBy(0,-4500)", "");
			 
			  
			  //Scroll into view 
			  //If required element is not in focus then with scrollintoview, it will scroll that element and bring in focus.
			  //jsx.executeScript("arguments[0].scrollIntoView(true)", <element that needs to be focused>)
			  
			  //Scroll to the bottom of the page
			  //jsx.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");

	}

}
