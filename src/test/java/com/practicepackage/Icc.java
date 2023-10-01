package com.practicepackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Icc {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		List<WebElement> allcountries = driver.findElements(By.xpath("//table/tbody/tr[*]/td[3][@class='table-body__cell u-center-text' and text()<30]"));
		
		for(int i=0;i<allcountries.size();i++)
{
	String name = driver.findElement(By.xpath("//table/tbody/tr[*]/td[3]")).getText();
	System.out.println(name);
}
	}

}
