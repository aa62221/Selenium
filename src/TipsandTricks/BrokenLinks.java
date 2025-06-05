package TipsandTricks;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) {
        System.setProperty("wedriver.chrome.driver", "C:\\Users\\Dell\\Automation Setup\\drivers\\chromedriver133.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
 
        //Storing the links in a list and traversing through the links
        List<WebElement> links = driver.findElements(By.tagName("a"));
 
        // This line will print the number of links and the count of links.
        System.out.println("No of links are "+ links.size());  
      
        List<String> urlList = new ArrayList<>();
        for (WebElement link : links) {
            String url = link.getAttribute("href");
//            verifyLinks(url);----Skip this method and run in parallel to save time.
            if (url != null && !url.isEmpty()) {
                urlList.add(url);
                
            }
        }
        System.out.println("No of urls are "+ urlList.size());  
        //We can use below method to run the url in parallel to save time in case there are many links.
//        urlList.parallelStream().forEach(e -> verifyLinks(e));//------ This will work same as below but below code is more readable and easy to understand.
          urlList.parallelStream().forEach(BrokenLinks::verifyLinks);
         
        
        driver.quit();
    }
    
    
    public static void verifyLinks(String linkUrl)
    {
        try
        {
//            URL url = new URL(linkUrl);---This is deprecated, hence using URI class to create URL object.
            URI uri = URI.create(linkUrl);

            // Convert URI to URL
            URL url = uri.toURL();
            //Now we will be creating url connection and getting the response code
            //we will check the HTTP status of each using HttpURLConnection class in Java.
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            //It is important to wait before creating a connection as the URL may take time to load. We have set the Connection timeout of 5 seconds.
            httpURLConnect.setConnectTimeout(5000);
           // Now creation of connection happens
            httpURLConnect.connect();
            //We will fetch the response code and print OK if the URL works fine. Else will give an error.
            if(httpURLConnect.getResponseCode()>=400)
            {
             System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()+" is a broken link");
            }    
       
            //Fetching and Printing the response code obtained
            else{
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            }
        }catch (Exception e) {
      }
   }

	}


