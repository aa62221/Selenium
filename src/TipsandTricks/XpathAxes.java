package TipsandTricks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathAxes {

	public static void main(String[] args) {
		    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Automation Setup\\drivers\\chromedriver.exe");	
	        WebDriver driver = new ChromeDriver();	   
	        driver.manage().window().maximize();
	        driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
	        
	   	        
	        //self axis  (Select current node)
	        String text =driver.findElement(By.xpath("//a[contains(text(),'Indian Bank')]/self::a")).getText();
	        System.out.println(text);
	      
	        //parent axis  (Selects the parent of the current node--always one)
	        //It will print the same output for this example, td defines the complete row and hence getText will give same value.	        
	        String text1 =driver.findElement(By.xpath("//a[contains(text(),'Indian Bank')]/parent::td")).getText(); 
	        System.out.println(text1);
	        
	        //ancestor axis  (Select all parent ,grand parent nodes, etc. of current node)
	        //a[contains(text(),'Indian Bank')]/ancestor::*-----This will give all the parent nodes of all anchor tags having text Indian Bank
	        //a[contains(text(),'Indian Bank')]/ancestor::tr---This will give tr ancestor node(not immediate parent but parent to parent node)
	        String text2 =driver.findElement(By.xpath("//a[contains(text(),'Indian Bank')]/ancestor::tr")).getText(); 
	        System.out.println(text2);
	        //tr is a full row, hence get text will return all the elements in the row.
	        
	        //child axis  (Select all children of current node, immediate childs)
	        List<WebElement> elements =driver.findElements(By.xpath("//a[contains(text(),'Indian Bank')]/ancestor::tr/child::td"));
	        System.out.println("Number of child "+elements.size());
	
	        //descendant axis  (Select all children , grand children etc..of current node)
	        //a[contains(text(),'Indian Bank')]/ancestor::tr/descendant::*-----This will give all the descendant of tr tag in which one is 'a' tag with text Indian Bank
	        List<WebElement> elements1 =driver.findElements(By.xpath("//a[contains(text(),'Indian Bank')]/ancestor::tr/descendant::*"));
	        for(WebElement ele :elements1) {
	        	System.out.println(ele.getText());
	        }
	        
	        //Following axis  ( Selects all the siblings and the parents siblings )
	        //So basically below we are finding all the following tr tags of //a[contains(text(),'Indian Bank')]/ancestor::tr
	        // and //a[contains(text(),'Indian Bank')]/ancestor::tr this means all the ancestor tr tags of anchor tags which contains text Indian Bank
	        List<WebElement> elements2 =driver.findElements(By.xpath("//a[contains(text(),'Indian Bank')]/ancestor::tr/following::tr"));
	        System.out.println("Number of child "+elements2.size());
	        
	        //Same way, you can use following-sibling,preceding and preceding-sibling
	        //a[contains(text(),'Indian Bank')]/ancestor::tr/following-sibling::tr
	        //a[contains(text(),'Indian Bank')]/ancestor::tr/preceding::tr
	        //a[contains(text(),'Indian Bank')]/ancestor::tr/preceding-sibling::tr
	        
	}
	
}
