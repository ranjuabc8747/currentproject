package com.practicepackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmajonBrandTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driver.get("https://www.amazon.in/");
			String Brand="Samsung";
			WebElement searchbutton = driver.findElement(By.xpath("//input[@aria-label='Search Amazon.in']"));
searchbutton.sendKeys("mobiles");
searchbutton.sendKeys(Keys.ENTER);
driver.findElement(By.xpath("//span[.='Brand']/ancestor::div[@id='brandsRefinements']/descendant::input[@type='checkbox']/../following::span[text()='"+Brand+"']")).click();

	 List<WebElement> allmobiles = driver.findElements(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']//span[@class='a-price-whole' ][number(translate(text(),'₹,',''))<20000]"));
for( WebElement mobile:allmobiles)
{
	String name = mobile.getText();
	System.out.println(name);
}
}
}
