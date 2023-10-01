package com.practicepackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KayakCalenderTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		String monthandyear = "September 2023";
		int date=2;
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.kayak.co.in/");
		driver.findElement(By.xpath("//input[@aria-label='Flight origin input']"));
		driver.findElement(By.xpath("//span[text()='Bengaluru, Karnataka, India']")).click();
		driver.findElement(By.xpath("//input[@aria-label='Flight destination input']")).click();
		driver.findElement(By.xpath("//span[text()='New Delhi, National Capital Territory of India, India']")).click();
		//driver.findElement(By.xpath("//span[@class='sR_k-date sR_k-mod-hide-arrows sR_k-mod-active']")).click();
		driver.findElement(By.xpath("//span[@aria-label='Start date calendar input']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Previous month']")).click();
		driver.findElement(By.xpath("//div[.='"+monthandyear+"']/ancestor::div[@class='onx_ onx_-pres-mcfly onx_-double']//div[.='"+date+"']")).click();
	driver.findElement(By.xpath("//span[@aria-label='End date calendar input']")).click();
	driver.findElement(By.xpath("//div[.='October 2023']/ancestor::div[@class='onx_ onx_-pres-mcfly onx_-double' ]//div[.='3'][1]")).click();
	driver.findElement(By.xpath("//button[@aria-label='Search']")).click();
	
	 WebElement othersort = driver.findElement(By.xpath("//div[@aria-label='Other sort' and @class='c1wE_-handle']"));
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(othersort));
	othersort.click();
	driver.findElement(By.xpath("//li[@aria-label='Slowest']")).click();
	List<WebElement> alllinks = driver.findElements(By.xpath("//div[@class='Ui-Flights-Results-Components-ListView-container ']"));
	
	/*for(WebElement links:alllinks)
	{
	//	links.findElements)
	}*/
	
	
	}
	
	

}
