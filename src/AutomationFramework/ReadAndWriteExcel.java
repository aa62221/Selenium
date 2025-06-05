package AutomationFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xslf.usermodel.XSLFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ReadAndWriteExcel {
  
	static String Path = "C:\\Users\\Dell\\Desktop\\Study Material\\Eclipse workspace\\Selenium\\src\\TestData\\TestData.xlsx";
	public static void main(String[]args) throws IOException {
	
	  
	  FileInputStream ExcelFile = new FileInputStream(Path);
	  
	  XSSFWorkbook ExcelWBook = new XSSFWorkbook(ExcelFile);
	  XSSFSheet ExcelWSheet = ExcelWBook.getSheetAt(0);
	  
	  //Logic to read the excel data
	  int row =ExcelWSheet.getLastRowNum();
	  int row2= ExcelWSheet.getPhysicalNumberOfRows();
	  System.out.println("Total number of rows in the excel using getLastRowNum :" +row);
	  System.out.println("Total number of rows in the excel using getPhysicalNumberOfRows:" +row2);
	  //Note:  getLastRowNum() returns a number with the count starting from 0. Hence the total number of rows in the output 
	  //would be 1 less than total rows. So in case there is only 1 row then count will show 0.
	  //For this we can use getPhysicalNumberOfRows method which does not count empty rows
	  
	  int col =ExcelWSheet.getRow(0).getLastCellNum();
	  System.out.println("Total number of columns in the excel are :"+col);
	 	  	  

	  for(int i=0; i<=row;i++) {
		 
		  for(int j=0; j<col;j++) {
			
					 XSSFCell cell= ExcelWSheet.getRow(i).getCell(j);
					 System.out.print(cell.getStringCellValue()+"                 ");
					 
		  }		  
		  System.out.println();
	  }
	  
//	  ExcelWBook.close();-- If you close the workbook here, you cannot write to it later.
	  
	  
	  WebDriver driver = new ChromeDriver();
	  System.setProperty("wedriver.chrome.driver", "E:\\Selenium 2\\Chrome Driver\\Version116\\chromedriver.exe");
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.get("https://www.facebook.com/");
      String ActualTitle= driver.getTitle();
      String ExpectedTitle= "Facebook";
    
      
     
     //Write data into excel 
      if(ActualTitle.equalsIgnoreCase(ExpectedTitle)) {
    	  int col1=ExcelWSheet.getRow(1).getLastCellNum();
    	  System.out.println("Last cell number is "+col1);
    	  XSSFCell cell= ExcelWSheet.getRow(1).createCell(col1);
    	
    	  cell.setCellValue("Pass");
    	  System.out.println("Test case is passed");
      }
      else {
    	  int col2=ExcelWSheet.getRow(1).getLastCellNum();
    	  System.out.println("Last cell number is "+col2);
    	  XSSFCell cell= ExcelWSheet.getRow(1).createCell(col2);
    	  cell.setCellValue("Fail");
    	  System.out.println("Test case is failed");
      }
      FileOutputStream outputStream = new FileOutputStream(Path);
      ExcelWBook.write(outputStream);
      ExcelWBook.close();
       
     driver.close();

}
}
