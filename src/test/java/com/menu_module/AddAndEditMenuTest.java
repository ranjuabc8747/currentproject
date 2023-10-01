package com.menu_module;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AddAndEditMenuTest {

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
		String actualvalue = driver.findElement(By.xpath("//table/tbody/tr/td[4]")).getText();
		System.out.println(actualvalue);
		//int avalue=Integer.parseInt(actualvalue);
		//driver.findElement(By.linkText("All Menues")).click();
		driver.findElement(By.xpath("//table/tbody/tr/td[6]/a/following-sibling::a")).click();
		Thread.sleep(5000);
WebElement pricetextfield = driver.findElement(By.xpath("//input[@name='price']"));
pricetextfield.clear();
pricetextfield.sendKeys("62");

driver.findElement(By.xpath("//input[@name='file']")).sendKeys("C:\\Users\\HI\\Pictures\\Saved Pictures\\1ST PICT.jpg");
WebElement Restaurant1 = driver.findElement(By.xpath("//Select[@name='res_name']"));
Select s1=new Select(Restaurant1);
s1.selectByVisibleText("FishLand");

driver.findElement(By.xpath("//input[@name='submit']")).click();
driver.findElement(By.xpath("//span[.='Menu']")).click();
driver.findElement(By.linkText("Add Menu")).click();
driver.findElement(By.linkText("All Menues")).click();
String afterchanging = driver.findElement(By.xpath("//table/tbody/tr/td[4]")).getText();
//int aftervalue=Integer.parseInt(afterchanging);
if(afterchanging.contains("62"))
{
	System.out.println("medu is edited and changed the price successfully");
}
else
{
	System.out.println("price is not changed");
}

driver.findElement(By.xpath("//img[@src='images/bookingSystem/user-icn.png']")).click();
driver.findElement(By.xpath("//a[@href='logout.php']")).click();
/*driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/");
driver.findElement(By.linkText("Login")).click();
driver.findElement(By.xpath("//input[@name='username']")).sendKeys("ABCD");
driver.findElement(By.xpath("//input[@name='password']")).sendKeys("1234567");
driver.findElement(By.xpath("//input[@name='submit']")).click();
driver.findElement(By.xpath("Restaurants ")).click();*/



	}

}
