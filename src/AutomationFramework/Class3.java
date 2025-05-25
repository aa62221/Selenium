package AutomationFramework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Class3 {
	

		static WebDriver driver;

		public static void main(String[] args){

		  driver=openDriver("Chrome");
		  JavascriptExecutor exe = (JavascriptExecutor) driver;
			Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
			
		}


		public static WebDriver openDriver(String name){

		if (name.equalsIgnoreCase("Chrome")){
		driver =  new ChromeDriver();
		}
		else if(name.equalsIgnoreCase("Firefox")){
		driver =  new FirefoxDriver();
		}
		else{
		driver =  new InternetExplorerDriver();
		}
		return driver;
		}

		

}
