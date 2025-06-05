package TipsandTricks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCertAndHeadlessBrowser {

	public static void main(String[] args) {
		
		//SSL(Secure Sockets Layer)
		 ChromeOptions Object = new ChromeOptions();
		
		 //Using the accept insecure cert method with true as parameter to accept the untrusted certificate
		 Object.setAcceptInsecureCerts(true);
		 //Same for firefox as well
		 
		 //Below method is used to run the headless browser
		 Object.addArguments("headless");
		 //For firefox you have  to write Object.setHeadless(true);
		 
		 //Creating instance of Chrome driver by passing reference of ChromeOptions object
		 //WebDriver path is set in System Path Variable hence no need to set path in system property
		 WebDriver driver = new ChromeDriver(Object);
		 
		 //Launching the URL
		 driver.get("https://expired.badssl.com/");
		 System.out.println("The page title is : " +driver.getTitle());
		 driver.quit();
		 

	}
	
	//Advantages of Headless testing:- 
	//Faster execution compared to GUI, as it does not wait for images to be rendered or element to be present in the screen
   // Helps you to do the multi task while the test are running in background.
	
	//Disadvantages:-
	//Debugging is not feasible, as the only way to check what's running on the browser is to grab the screenshots and validate the output.
	//Cosmetic bugs like the location of a web element, the color of a web element may get missed while running the tests in headless mode.

}


