package ranjitha;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class makemytrip {
	public static void main(String[] args) throws Throwable {
		
	
	WebDriver driver=new ChromeDriver();
   driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.makemytrip.com/");
	driver.navigate().refresh();
	Thread.sleep(5000);
	Actions a=new Actions(driver);
	a.doubleClick().perform();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//span[.='Departure']")).click();
	WebElement actual = driver.findElement(By.xpath("//div[text()='June 2024']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='6']")); 
	// WebElement actual = driver.findElement(By.xpath("//div[text()='June 2024']/parent::div/../div[3]/div[2]/div[5]/div/p[.=6]"));
WebElement nextarrow = driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
for(; ;)
{
try {
	 driver.findElement(By.xpath("//div[text()='June 2024']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='6']")).click();
	break;
}
catch(Exception e)
{
	driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
}
}
}
}
