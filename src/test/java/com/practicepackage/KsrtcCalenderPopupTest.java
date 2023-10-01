package com.practicepackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KsrtcCalenderPopupTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		int date1=31;
				int date2=20;
		
		driver.get("https://www.ksrtc.in/oprs-web/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.findElement(By.id("txtJourneyDate")).click();
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/descendant::a[text()='"+date1+"']")).click();
driver.findElement(By.id("txtReturnJourneyDate")).click();
driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/descendant::span[text()='Next']")).click();
driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/descendant::a[text()='"+date2+"']")).click();
	}

}
