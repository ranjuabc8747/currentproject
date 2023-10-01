package com.restaurant_module;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;

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

public class WebDriverUtilityForAddAndVerifyTest {
	static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		
		WebDriverUtility wLib = new WebDriverUtility();
	 	FileUtility fLib = new FileUtility();
	 	ExcelUtility eLib = new ExcelUtility();
	 	JavaUtility jLib = new JavaUtility();
		jLib.getRandomNumber();
		String BROWSER=fLib.getPropertyKeyValue("browser");
		String URL=fLib.getPropertyKeyValue("adminurl");
		String USERNAME=fLib.getPropertyKeyValue("adminusername");
		String PASSWORD=fLib.getPropertyKeyValue("adminpassword");
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
			Thread.sleep(5000);
			driver.findElement(By.xpath("//span[text()='Restaurant' and @class='hide-menu']")).click();
			Thread.sleep(5000);
			driver.findElement(By.linkText("Add Restaurant")).click();
			FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\TestData1.xlsx");
			 Workbook wb = WorkbookFactory.create(fi);
			 Sheet sh = wb.getSheet("Restaurant");
			 int rowcount=sh.getLastRowNum();
			HashMap<String, String> hs = new HashMap<String,String>();
			for(int i=1;i<=rowcount;i++)
			{
				String key=sh.getRow(i).getCell(0).getStringCellValue();
				String value=sh.getRow(i).getCell(1).getStringCellValue();
				hs.put(key, value);
			}
			for(Entry<String, String> map:hs.entrySet())
			{
			driver.findElement(By.name(map.getKey())).sendKeys(map.getValue());	
			}
			//driver.findElement(By.xpath("//input[@name='res_name']")).sendKeys("abc");
			//driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abc@gmail.com");
			//driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9876543210");
			//driver.findElement(By.xpath("//input[@name='url']")).sendKeys("www.abc.com");
			 WebElement openhours = driver.findElement(By.xpath("//select[@name='o_hr']"));
			 String oh = eLib.ReadDataFromExcelFile("Restaurant",1 ,2);
			wLib.selectDropDown(oh, openhours);
			
		 WebElement closehour = driver.findElement(By.xpath("//select[@name='c_hr']"));
		String ch = eLib.ReadDataFromExcelFile("Restaurant", 2, 2);
			wLib.selectDropDown(ch, closehour);
			WebElement opendays = driver.findElement(By.xpath("//select[@name='o_days']"));
			String od = eLib.ReadDataFromExcelFile("Restaurant", 3, 2);
			driver.findElement(By.xpath("//input[@name='file']")).sendKeys("C:\\Users\\HI\\Pictures\\Saved Pictures\\USER MODULE.jpg");
			WebElement selectcategory = driver.findElement(By.xpath("//select[@name='c_name']"));
			String cat = eLib.ReadDataFromExcelFile("Restaurant", 4, 2);
			wLib.selectDropDown(cat, selectcategory);
			
			driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys("2nd block jayanagar-560063");
			driver.findElement(By.xpath("//input[@name='submit']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//a[text()='All Restaurants']")).click();
			String addedrestname = driver.findElement(By.xpath("//table/tbody/tr/td[2]")).getText();
			if(addedrestname.equalsIgnoreCase("abc"))
			{
				System.out.println("Restaurant added successfully");
			}
			else
			{
				System.out.println("Restaurant is not added");
			}
			
		}

	}
