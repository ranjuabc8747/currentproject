package com.assignmentpackage;

import java.time.Duration;
import java.util.HashMap;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ecommerce.objectrepository.AddRestaurantPge;
import com.ecommerce.objectrepository.AdminDashBoardPage;
import com.ecommerce.objectrepository.AdminLoginPage;
import com.foodordering.genericutility.BaseClass;
import com.foodordering.genericutility.ExcelUtility;
import com.foodordering.genericutility.FileUtility;
import com.foodordering.genericutility.JavaUtility;
import com.foodordering.genericutility.WebDriverUtility;
@Listeners(com.foodordering.genericutility.ListenerImpClass.class)
public class AddRestAndVerifyInDashBoardPage extends BaseClass {
	@Test(groups="smoke")
	public void addRestaurent() throws Throwable
	{
	
				AdminDashBoardPage gg=new AdminDashBoardPage(driver);
				gg.clickOnDashboardButton();
				String beforecount = driver.findElement(By.xpath("//p[text()='Restaurants']/preceding-sibling::h2")).getText();
				int bcount = Integer.parseInt(beforecount);
				AdminDashBoardPage b=new AdminDashBoardPage(driver);
				b.clickOnAddRestaurantBtn();
				HashMap<String, String> data = eLib.getmultipledatafromexcel("Restaurant", 0, 1);
				String oh = eLib.ReadDataFromExcelFile("Restaurant", 1, 2);
				String ch = eLib.ReadDataFromExcelFile("Restaurant", 2, 2);
				String od = eLib.ReadDataFromExcelFile("Restaurant", 3, 2);
				String cat = eLib.ReadDataFromExcelFile("Restaurant", 4, 2);
				AddRestaurantPge c = new AddRestaurantPge(driver);
		c.createRestwithAllfilds(data, driver, jLib, oh, ch, od, cat);
		//enter the mandatory details
			c.clickOnSubMitBtn();
			b.clickOnDashboardButton();
			c.validateRestAddedOrNot(driver, bcount);
			driver.close();
		}

	
	}

		
/*<dependency>
		<groupId>org.projectlombok</groupId>
		<artifactId>lombok</artifactId>
		<version>1.18.30</version>
		<scope>provided</scope>
	</dependency>*/





