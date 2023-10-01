package com.menu_module;

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
import org.openqa.selenium.support.ui.Select;

public class AddAndDeleteMenuTest {

	public static void main(String[] args) throws Throwable {
		
		Random ran=new Random();
		ran.nextInt(500);
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
		driver.findElement(By.xpath("//span[.='Menu']")).click();
		driver.findElement(By.linkText("Add Menu")).click();
		driver.findElement(By.xpath("//input[@name='d_name']")).sendKeys("ranjus");
		driver.findElement(By.xpath("//input[@name='about']")).sendKeys("taste is so good");
		driver.findElement(By.xpath("//input[@name='price']")).sendKeys("7");
		driver.findElement(By.xpath("//input[@name='file']")).sendKeys("C:\\Users\\HI\\Pictures\\Saved Pictures\\1ST PICT.jpg");
		WebElement Restaurant = driver.findElement(By.xpath("//Select[@name='res_name']"));
		Select s=new Select(Restaurant);
		s.selectByVisibleText("FishLand");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		driver.findElement(By.linkText("All Menues")).click();
		String actualmenu = driver.findElement(By.xpath("//table/tbody/tr[1]")).getText();
				
if(actualmenu.contains("ranjus"))
{
	System.out.println("menu is added successfully");
}
else
{
	System.out.println("menu is not added");
}
driver.findElement(By.xpath("//table//tr[1]/td[6]/a[@class='btn btn-danger btn-flat btn-addon btn-xs m-b-10']")).click();
String afterdel=driver.findElement(By.xpath("//table/tbody/tr[1]")).getText();
if(afterdel.contains("ranjus"))
{
	System.out.println("menu is not deleted");
}
else
{
	System.out.println("added menu is deleted successfully");
}
}
	
}
