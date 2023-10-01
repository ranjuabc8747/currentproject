package com.assignmentpackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JioMartTest2 {

	public static void main(String[] args) {

WebDriver driver=new ChromeDriver();

driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("https://www.jiomart.com/");
 Actions a = new Actions(driver);
  WebElement groceryele = driver.findElement(By.linkText("Groceries"));
 a.moveToElement(groceryele).perform();
 String name1="Dairy & Bakery";
   WebElement b = driver.findElement(By.xpath("//a[.='Groceries']/ancestor::li/descendant::a[.='"+name1+"']"));

  a.moveToElement(b).perform();

 
  //String value = driver.findElement(By.xpath("//li[@class='header-nav-l1-item']//descendant::ul[@class='header-nav-l2 custom-scrollbar']//a[text()='Fruits & Vegetables']//ancestor::li//a [text()='Fresh Vegetables']")).getText();
 List<WebElement> allvalue = driver.findElements(By.xpath("//a[.='Groceries']/ancestor::li/descendant::a[text()='"+name1+"']/..//descendant::li/a"));
		for(WebElement al:allvalue)
		{
			String c = al.getText();
			System.out.println(c);
	 }}}
		
	
 

	


 
	


