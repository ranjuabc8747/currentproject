package com.practicepackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CmdTest {

	@Test
	public void cmd()
	{
		String browser=System.getProperty("browser");
		String adminurl = System.getProperty("adminurl");
		String adminusername = System.getProperty("adminusername");
		String adminpassword = System.getProperty("adminpassword");
		System.out.println(browser);
		System.out.println(adminurl);
		System.out.println(adminusername);
		System.out.println(adminpassword);
		//launch the browser
		WebDriver driver=new ChromeDriver();
		driver.get(adminurl);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(adminusername);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(adminpassword);
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		driver.close();
	}

}
