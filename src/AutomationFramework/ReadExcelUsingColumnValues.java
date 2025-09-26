package AutomationFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xslf.usermodel.XSLFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ReadExcelUsingColumnValues {
  
	static String Path = "C:\\Users\\Dell\\Desktop\\Study Material\\EclipseWorkspace\\Selenium\\src\\TestData\\TestData.xlsx";;
	public static void main(String[]args) throws IOException {
	
	   
		  FileInputStream ExcelFile = new FileInputStream(Path);		  
		  XSSFWorkbook ExcelWBook = new XSSFWorkbook(ExcelFile);
		  XSSFSheet ExcelWSheet = ExcelWBook.getSheetAt(0);
		  
		  int row= ExcelWSheet.getPhysicalNumberOfRows();
		  System.out.println("Total number of rows in the excel using getPhysicalNumberOfRows:" +row);
		  int col =ExcelWSheet.getRow(0).getLastCellNum();
		  
		  			 
			  for(int j=0; j<col;j++) {
				
						 XSSFCell cell= ExcelWSheet.getRow(0).getCell(j);
						 if(cell.getStringCellValue().equalsIgnoreCase("UserName")) {
							 System.out.println("Username Found at col index " +j);
							 
							 for(int i=1;i<row;i++) {
								 XSSFCell cell2= ExcelWSheet.getRow(i).getCell(j);
								 System.out.println(cell2.getStringCellValue());
								
							 }
							
							 
							 
							 }
						 }
			  ExcelWBook.close();
			  
			  }		  
			 
		  
	
	}

	
              

