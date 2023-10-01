package com.order_module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddOrderAsUserAndViewOrderAsAdminTest {

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
	driver.findElement(By.linkText("Logout")).click();
	driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/admin/");
	driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("codeastro");
	driver.findElement(By.xpath("//input[@name='submit']")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//span[text()='Orders']")).click();
	String ordername = driver.findElement(By.xpath("//table/tbody/tr[last()]/td[2]")).getText();
	if(ordername.equalsIgnoreCase("Pink Spaghetti Gamberoni"))
	{
		System.out.println("order has been placed successfully");
	}
	else
	{
		System.out.println("order has not been placed");
	}
	//driver.findElement(By.xpath("//table/tbody/tr[last()]/td[8]/a[@class='btn btn-info btn-flat btn-addon btn-sm m-b-10 m-l-5']")).click();
	
	//driver.findElement(By.xpath("//table/tbody/tr[last()]/td[8]/a[@class='btn btn-danger btn-flat btn-addon btn-xs m-b-10']")).click();
	
	}

}
