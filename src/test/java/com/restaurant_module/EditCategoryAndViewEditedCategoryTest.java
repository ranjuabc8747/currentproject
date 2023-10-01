package com.restaurant_module;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EditCategoryAndViewEditedCategoryTest {

	public static void main(String[] args) throws Throwable {
		
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
	driver.findElement(By.xpath("//span[.='Restaurant']")).click();
	driver.findElement(By.xpath("//a[text()='Add Category']")).click();
	driver.findElement(By.xpath("//input[@name='c_name']")).sendKeys("ovo");
	driver.findElement(By.xpath("//input[@name='submit']")).click();
	driver.findElement(By.xpath("//table/tbody/tr[2]/td[4]/a[2]")).click();
	WebElement addCategort = driver.findElement(By.xpath("//input[@name='c_name']"));
			addCategort.clear();
	addCategort.sendKeys("India");
	driver.findElement(By.xpath("//input[@name='submit']")).click();
	driver.findElement(By.xpath("//span[.='Restaurant']")).click();
		driver.findElement(By.xpath("//a[text()='Add Category']")).click();
	String editedcategory = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText();
	if(editedcategory.equalsIgnoreCase("India"))
	{
		System.out.println("category name has changed successfully");
	}
	else
	{
		System.out.println("category name has not changed");
	}
	driver.findElement(By.xpath("//img[@class='profile-pic']")).click();
	driver.findElement(By.xpath("//a[@href='logout.php']")).click();
	
	}
}
