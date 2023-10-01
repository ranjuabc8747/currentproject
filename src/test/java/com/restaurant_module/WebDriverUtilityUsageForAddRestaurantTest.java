package com.restaurant_module;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.foodordering.genericutility.ExcelUtility;
import com.foodordering.genericutility.FileUtility;
import com.foodordering.genericutility.JavaUtility;
import com.foodordering.genericutility.WebDriverUtility;

public class WebDriverUtilityUsageForAddRestaurantTest {

	static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		WebDriverUtility wLib = new WebDriverUtility();
	 	FileUtility fLib = new FileUtility();
	 	ExcelUtility eLib = new ExcelUtility();
	 	JavaUtility jLib = new JavaUtility();
		
		jLib.getRandomNumber();
		
		//To fetch the data from the propertyfile
		
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL=	fLib.getPropertyKeyValue("adminurl");
		String USERNAME	=fLib.getPropertyKeyValue("adminusername");
		String PASSWORD	=fLib.getPropertyKeyValue("adminpassword");
if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
	wLib.maximizeTheBrowser(driver);
		wLib.implicitWait(driver, 10);
			driver.get(URL);
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys(USERNAME);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PASSWORD);
			driver.findElement(By.xpath("//input[@name='submit']")).click();
			driver.findElement(By.xpath("//span[text()='Dashboard']")).click();
			String beforecount = driver.findElement(By.xpath("//p[text()='Restaurants']/preceding-sibling::h2")).getText();
			int bcount = Integer.parseInt(beforecount);
			//System.out.println(bcount);
			 driver.findElement(By.xpath("//span[text()='Restaurant' and @class='hide-menu']")).click();
		
		driver.findElement(By.linkText("Add Restaurant")).click();
		//to fetch the data from excel file
		eLib.getmultipledatafromexcel("Restaurant", 0, 1);
	
			 String oh=eLib.ReadDataFromExcelFile("Restaurant", 1, 2);
	// String oh = sh.getRow(1).getCell(2).getStringCellValue();
			 String ch=eLib.ReadDataFromExcelFile("Restaurant", 2, 2);	 
	 //String ch = sh.getRow(2).getCell(2).getStringCellValue();
			 String od=eLib.ReadDataFromExcelFile("Restaurant", 3, 2);	 
	// String od = sh.getRow(3).getCell(2).getStringCellValue();
			 String cat=eLib.ReadDataFromExcelFile("Restaurant", 4, 2);	 
	// String cat = sh.getRow(4).getCell(2).getStringCellValue();
	
	 WebElement openhours = driver.findElement(By.xpath("//select[@name='o_hr']"));
	wLib.selectDropDown(oh, openhours);	
	 
		  WebElement closehour = driver.findElement(By.xpath("//select[@name='c_hr']"));
		wLib.selectDropDown(ch, closehour);
		
		WebElement opendays = driver.findElement(By.xpath("//select[@name='o_days']"));
		wLib.selectDropDown(od, opendays);
		
		//driver.findElement(By.xpath("//input[@name='file']")).sendKeys("C:\\Users\\HI\\Pictures\\Saved Pictures\\USER MODULE.jpg");
		WebElement selectcategory = driver.findElement(By.xpath("//select[@name='c_name']"));
		wLib.selectDropDown(cat, selectcategory);
		
		//driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys("2nd block jayanagar-560063");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		driver.findElement(By.xpath("//span[text()='Dashboard']")).click();
		String afteradding = driver.findElement(By.xpath("//p[text()='Restaurants']/preceding-sibling::h2")).getText();
		int acount = Integer.parseInt(afteradding);
		System.out.println(bcount);
		System.out.println(acount);
		if(bcount<acount)
		{
			System.out.println("Restaurant added successfully");
		}
		else
		{
			System.out.println("Restaurant not added");
		}
		driver.quit();
	}
}

	

	


