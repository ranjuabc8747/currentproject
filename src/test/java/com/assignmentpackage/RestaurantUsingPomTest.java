package com.assignmentpackage;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


import com.ecommerce.objectrepository.AddRestaurantPge;
import com.ecommerce.objectrepository.AdminDashBoardPage;
import com.ecommerce.objectrepository.AdminLoginPage;
import com.ecommerce.objectrepository.AllRestaurantPage;
import com.foodordering.genericutility.ExcelUtility;
import com.foodordering.genericutility.FileUtility;
import com.foodordering.genericutility.JavaUtility;
import com.foodordering.genericutility.WebDriverUtility;

public class RestaurantUsingPomTest extends WebDriverUtility {
	static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException, Throwable {

		WebDriverUtility wLib=new WebDriverUtility();
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();

		String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL =fLib.getPropertyKeyValue("adminurl");
		String USERNAME =fLib.getPropertyKeyValue("adminusername");
		String PASSWORD = fLib.getPropertyKeyValue("adminpassword");

		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		wLib.maximizeTheBrowser(driver);
		wLib.implicitWait(driver, 10);
		driver.get(URL);
		AdminLoginPage a = new AdminLoginPage(driver);
		a.login(USERNAME, PASSWORD);
		AdminDashBoardPage b = new AdminDashBoardPage(driver);
		b.clickOnAddRestaurantBtn();
		
		HashMap<String, String> data = eLib.getmultipledatafromexcel("Restaurant", 0, 1);
		for (Entry<String, String> s : data.entrySet()) {
			System.out.println(s.getKey());
			System.out.println(s.getValue());
		}
		String oh = eLib.ReadDataFromExcelFile("Restaurant", 1, 2);
		String ch = eLib.ReadDataFromExcelFile("Restaurant", 2, 2);
		String od = eLib.ReadDataFromExcelFile("Restaurant", 3, 2);
		String cat = eLib.ReadDataFromExcelFile("Restaurant", 4, 2);
		
		
		AddRestaurantPge c=new AddRestaurantPge (driver);
		c.createRestwithAllfilds(data, driver, jLib, oh, ch, od, cat);
		c.clickOnSubMitBtn();

Thread.sleep(1000);
		AdminDashBoardPage d=new AdminDashBoardPage(driver);
		d.clickOnAllRestaurant();

AllRestaurantPage e = new  AllRestaurantPage(driver);
e.validateRestaurant(driver, "NewRestaurant");

		
		

	}
}
