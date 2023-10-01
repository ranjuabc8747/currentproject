package com.practicepackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MakeMyTripCalenderPopupTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		String monthandyear="December 2024";
	int	date=14;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");
		driver.navigate().refresh();
		Thread.sleep(5000);
		Actions a=new Actions(driver);
		a.doubleClick().perform();
		Thread.sleep(5000);
		//a.moveByOffset(0, 80).click().perform();
		
		//driver.findElement(By.xpath(" //i[@class='wewidgeticon we_close')")).click();
		driver.findElement(By.xpath("//span[.='Departure']")).click();
		String actual="//div[text()='"+monthandyear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
		String nextarrow="//span[@aria-label='Next Month']";
		for(;;)
		{
			try
			{
				driver.findElement(By.xpath(actual)).click();
				break;
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath(nextarrow)).click();
			}
		}
		

	}

}
