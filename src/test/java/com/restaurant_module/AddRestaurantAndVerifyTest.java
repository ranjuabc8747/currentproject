package com.restaurant_module;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AddRestaurantAndVerifyTest {

	public static void main(String[] args) throws InterruptedException, Throwable {
		Random ran=new Random();
		int random=ran.nextInt(500);
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commandata.properties");
		Properties p=new Properties();
		p.load(fis);
	String BROWSER = p.getProperty("browser");
	String URL = p.getProperty("adminurl");
	String USERNAME = p.getProperty("adminusername");
	String PASSWORD = p.getProperty("adminpassword");
	WebDriver driver=null;
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
		driver.findElement(By.xpath("//span[text()='Restaurant' and @class='hide-menu']")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Add Restaurant")).click();
		driver.findElement(By.xpath("//input[@name='res_name']")).sendKeys("abc");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9876543210");
		driver.findElement(By.xpath("//input[@name='url']")).sendKeys("www.abc.com");
		 WebElement openhours = driver.findElement(By.xpath("//select[@name='o_hr']"));
		Select s=new Select(openhours);
		s.selectByVisibleText("7am");
		  WebElement closehour = driver.findElement(By.xpath("//select[@name='c_hr']"));
		
		Select s1=new Select(closehour);
		s1.selectByVisibleText("10pm");
		WebElement opendays = driver.findElement(By.xpath("//select[@name='o_days']"));
		Select s2=new Select(opendays);
		s2.selectByVisibleText("Mon-Sat");
		driver.findElement(By.xpath("//input[@name='file']")).sendKeys("C:\\Users\\HI\\Pictures\\Saved Pictures\\USER MODULE.jpg");
		WebElement selectcategory = driver.findElement(By.xpath("//select[@name='c_name']"));
		Select s3=new Select(selectcategory);
		s3.selectByVisibleText("Chinese");
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
