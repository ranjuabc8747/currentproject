package com.assignmentpackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ecommerce.objectrepository.AddMenuPage;
import com.ecommerce.objectrepository.AdminDashBoardPage;
import com.ecommerce.objectrepository.AdminLoginPage;
import com.foodordering.genericutility.BaseClass;
import com.foodordering.genericutility.ExcelUtility;
import com.foodordering.genericutility.FileUtility;
import com.foodordering.genericutility.JavaUtility;
import com.foodordering.genericutility.WebDriverUtility;
@Listeners(com.foodordering.genericutility.ListenerImpClass.class)
public class AddAndDeleteMenuUsingPomTest extends BaseClass{
static	WebDriver driver=null;
@Test(groups="smoke")
public void addRestaurent() throws Throwable 
{
		AdminDashBoardPage b = new AdminDashBoardPage(driver);
		b.clickOnMenuButton();
		AddMenuPage c=new AddMenuPage(driver);
		HashMap<String, String> data = eLib.getmultipledatafromexcel("Menu", 0, 1);
		String restname = eLib.ReadDataFromExcelFile("Menu", 1, 2);
			c.addMenuByAllDetails(data, driver, jLib,restname);
			
			b.clickOnAllMenu();
			String actualmenu = driver.findElement(By.xpath("//table/tbody/tr[1]")).getText();
					
	if(actualmenu.contains("ranjus"))
	{
		System.out.println("menu is added successfully");
	}
	else
	{
		System.out.println("menu is not added");
	}
	driver.findElement(By.xpath("//table//tr[1]/td[6]/a[@class='btn btn-danger btn-flat btn-addon btn-xs m-b-10']")).click();
	String afterdel=driver.findElement(By.xpath("//table/tbody/tr[1]")).getText();
	if(afterdel.contains("ranjus"))
	{
		System.out.println("menu is not deleted");
	}
	else
	{
		System.out.println("added menu is deleted successfully");
	}
	}
		
	

	}


