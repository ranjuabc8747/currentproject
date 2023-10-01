package com.order_module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ViewOrderAsUserTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/");
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("ABCD");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("1234567");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
	driver.findElement(By.xpath("//a[text()='Restaurants ']")).click();
	driver.findElement(By.xpath("//a[text()='Eataly']")).click();
	driver.findElement(By.xpath("//a[text()='Pink Spaghetti Gamberoni']/ancestor::div[@class='food-item']/div/div[2]/input[@value='Add To Cart']")).click();
	driver.findElement(By.linkText("Checkout")).click();
	driver.findElement(By.xpath("//input[@value='Order Now']")).click();
	driver.switchTo().alert().accept();
	Thread.sleep(5000);
	driver.switchTo().alert().accept();
	String expected="Pink Spaghetti Gamberoni";
	driver.findElement(By.xpath("//a[text()='My Orders']")).click();
	String actual = driver.findElement(By.xpath("//table/tbody/tr[last()]/td[1]")).getText();
if(actual.equalsIgnoreCase(expected))
{
	System.out.println("order has been placed");
}
else
	System.out.println("order has not been placed");
	}

}
