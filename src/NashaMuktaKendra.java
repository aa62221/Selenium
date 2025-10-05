

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NashaMuktaKendra {
	

	@Test(dataProvider= "Parameters")
    public void nashaMuktBharat(String Name, String Age, String State, String District, String Mobile, String Email) throws InterruptedException, IOException {
//        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://nmba.dosje.gov.in/content/take-a-pledge");
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for(int i=0; i<links.size(); i++) {
        	
        	System.out.println(links.get(i).getText()+"---URL: ----"+links.get(i).getAttribute("href"));
        }
        
        WebElement pledgeLabel= driver.findElement(By.xpath("//div[@class='modal-content']//label[text()='I take a pledge.']"));   
        wait.until(
            ExpectedConditions.elementToBeClickable(pledgeLabel));
        pledgeLabel.click();
        
        WebElement OKbutton= driver.findElement(By.xpath("//div[@class='modal-content']//button[text()='Ok']")); 
        wait.until(
                ExpectedConditions.elementToBeClickable(OKbutton));
        OKbutton.click();  
        
        WebElement PledgeBtn= driver.findElement(By.xpath("//div[@class='pldgeBtn']/a[text()='Take a Pledge']"));   
        Actions actions = new Actions(driver);
        actions.moveToElement(PledgeBtn).perform();
        PledgeBtn.click();
        
        WebElement pledgeLabel1= driver.findElement(By.xpath("//div[@class='modal-content']//label[text()='I take a pledge.']"));   
        wait.until(
                ExpectedConditions.elementToBeClickable(pledgeLabel1));
        pledgeLabel1.click();
       
        WebElement OKbutton1= driver.findElement(By.xpath("//div[@class='modal-content']//button[text()='Ok']")); 
        wait.until(
                ExpectedConditions.elementToBeClickable(OKbutton1));
        OKbutton1.click();  
        
        WebElement PledgeBtn1= driver.findElement(By.xpath("//div[@class='pldgeBtn']/a[text()='Take a Pledge']"));   
        actions.moveToElement(PledgeBtn1).perform();
        PledgeBtn1.click();
  
        driver.findElement(By.xpath("//input[@placeholder='Enter Your Name']")).sendKeys(Name);
        driver.findElement(By.xpath("//input[@placeholder='Enter Your Age']")).sendKeys(Age);
        Select state = new Select(driver.findElement(By.xpath("//select[@name='state']")));
        state.selectByVisibleText(State);
        Select district = new Select(driver.findElement(By.xpath("//select[@name='district']")));
        district.selectByVisibleText(District);
        driver.findElement(By.xpath("//input[@placeholder='Enter Your Mobile']")).sendKeys(Mobile);
        driver.findElement(By.xpath("//input[@placeholder='Enter Your Email']")).sendKeys(Email);
        
        Thread.sleep(10000);
        WebElement Submit=driver.findElement(By.xpath("//button[text()='Submit']"));
        actions.moveToElement(Submit).perform();
        Submit.click();
        Thread.sleep(2000);
        WebElement DownloadCertificate= driver.findElement(By.xpath("//a[text()='Download Certificate']"));
        wait.until(
                ExpectedConditions.elementToBeClickable(DownloadCertificate));
        DownloadCertificate.click();  
        Thread.sleep(5000);
        driver.quit();

    }
    
//
//@DataProvider(name = "Parameters")
//public Object[][] dp() throws IOException {
//    FileInputStream fis = new FileInputStream("C:\\Users\\Dell\\Desktop\\Study Material\\EclipseWorkspace\\Selenium\\src\\TestData\\NashaMuktaKendra.xlsx");
//    XSSFWorkbook workbook = new XSSFWorkbook(fis);
//    XSSFSheet sheet = workbook.getSheetAt(0);
//    int rowCount = sheet.getLastRowNum(); 
//    System.out.println("Total number of rows : " + rowCount);
//    Object[][] data = new Object[rowCount][6]; 
//
//    for (int i = 1; i <= rowCount; i++) { 
//        XSSFRow row = sheet.getRow(i);
//        for (int j = 0; j < 6; j++) {
//            if (row.getCell(j) != null) {
//                row.getCell(j).setCellType(org.apache.poi.ss.usermodel.CellType.STRING);
//                data[i - 1][j] = row.getCell(j).getStringCellValue();
//            } else {
//                data[i - 1][j] = "";
//            }
//        }
//    }
	 
	 @DataProvider(name = "Parameters")
	 public Object[][] dp() throws IOException {
		 FileInputStream fis = new FileInputStream("C:\\Users\\Dell\\Desktop\\Study Material\\EclipseWorkspace\\Selenium\\src\\TestData\\NashaMuktaKendra.xlsx");
	     XSSFWorkbook workbook = new XSSFWorkbook(fis);
	     XSSFSheet sheet = workbook.getSheetAt(0);
	     int totalCols = sheet.getRow(0).getLastCellNum(); // number of columns from header
	     // Count only non-empty rows (excluding header)
	     int totalRows = 0;
	     for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	         XSSFRow row = sheet.getRow(i);
	         if (row != null && row.getCell(0) != null && !row.getCell(0).toString().trim().isEmpty()) {
	             totalRows++;
	         }
	     }

	     System.out.println("Actual non-empty rows: " + totalRows);

	     Object[][] data = new Object[totalRows][totalCols];
	     DataFormatter formatter = new DataFormatter();

	     int dataIndex = 0;
	     for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	         XSSFRow row = sheet.getRow(i);
	         if (row != null && row.getCell(0) != null && !row.getCell(0).toString().trim().isEmpty()) {
	             for (int j = 0; j < totalCols; j++) {
	                 data[dataIndex][j] = formatter.formatCellValue(row.getCell(j));
	             }
	             dataIndex++;
	         }
	     }

	     workbook.close();
	     fis.close();
	     return data;
	 }
	 
	 
	 



}
