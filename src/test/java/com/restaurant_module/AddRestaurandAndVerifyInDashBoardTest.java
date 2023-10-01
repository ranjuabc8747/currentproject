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



public class AddRestaurandAndVerifyInDashBoardTest {

	public static void main(String[] args) throws Throwable {
		
		Random ran=new Random();
		ran.nextInt(500);
		WebDriver driver=null;
		
//To fetch the data from the propertyfile
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commandata.properties");
		Properties p=new Properties();
		p.load(fis);
	String BROWSER = p.getProperty("browser");
	String URL = p.getProperty("adminurl");
	String USERNAME = p.getProperty("adminusername");
	String PASSWORD = p.getProperty("adminpassword");
	 if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
	 driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(URL);
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys(USERNAME);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PASSWORD);
			driver.findElement(By.xpath("//input[@name='submit']")).click();
			driver.findElement(By.xpath("//span[text()='Dashboard']")).click();
			String beforecount = driver.findElement(By.xpath("//p[text()='Restaurants']/preceding-sibling::h2")).getText();
			int bcount = Integer.parseInt(beforecount);
			 driver.findElement(By.xpath("//span[text()='Restaurant' and @class='hide-menu']")).click();
		
		driver.findElement(By.linkText("Add Restaurant")).click();
		//to fetch the data from excel file
		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\TestData1.xlsx");
		 Workbook wb = WorkbookFactory.create(fi);
		 Sheet sh = wb.getSheet("Restaurant");
		 int rowcount=sh.getLastRowNum();
	//enter the mandatory details
			HashMap<String,String> map=new HashMap<String,String>();
			for(int i=1;i<=rowcount;i++)
			{
				String key=sh.getRow(i).getCell(0).getStringCellValue();
				String value=sh.getRow(i).getCell(1).getStringCellValue();
				map.put(key, value);
			}
			for ( Entry<String, String> st : map.entrySet()) {
				
				driver.findElement(By.name(st.getKey())).sendKeys(st.getValue());
			}
	 String oh = sh.getRow(1).getCell(2).getStringCellValue();
	 String ch = sh.getRow(2).getCell(2).getStringCellValue();
	 String od = sh.getRow(3).getCell(2).getStringCellValue();
	 String cat = sh.getRow(4).getCell(2).getStringCellValue();
	
	
	
		 WebElement openhours = driver.findElement(By.xpath("//select[@name='o_hr']"));
		Select s=new Select(openhours);
		s.selectByVisibleText(oh);
		  WebElement closehour = driver.findElement(By.xpath("//select[@name='c_hr']"));
		
		Select s1=new Select(closehour);
		s1.selectByVisibleText(ch);
		WebElement opendays = driver.findElement(By.xpath("//select[@name='o_days']"));
		Select s3=new Select(opendays);
		s3.selectByVisibleText(od);
		//driver.findElement(By.xpath("//input[@name='file']")).sendKeys("C:\\Users\\HI\\Pictures\\Saved Pictures\\USER MODULE.jpg");
		WebElement selectcategory = driver.findElement(By.xpath("//select[@name='c_name']"));
		Select s2=new Select(selectcategory);
		s2.selectByVisibleText(cat);
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
		driver.close();
	}

	}



