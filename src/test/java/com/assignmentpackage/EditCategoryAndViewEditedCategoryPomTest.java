package com.assignmentpackage;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.ecommerce.objectrepository.AddRestaurantCategoryPage;
import com.ecommerce.objectrepository.AdminDashBoardPage;
import com.ecommerce.objectrepository.AdminLoginPage;
import com.foodordering.genericutility.BaseClass;
import com.foodordering.genericutility.ExcelUtility;
import com.foodordering.genericutility.FileUtility;
import com.foodordering.genericutility.JavaUtility;
import com.foodordering.genericutility.WebDriverUtility;

public class EditCategoryAndViewEditedCategoryPomTest extends BaseClass {
	@Test
	public void editcategory() throws Throwable
	{
	String name="efg";
		String name1="456";
		
		
		AdminDashBoardPage b = new AdminDashBoardPage(driver);
		b.clickOnRestbtn();
	b.clickOnAddCatBtn();
	 AddRestaurantCategoryPage c=new  AddRestaurantCategoryPage(driver);
	 c.enterCatname(name);
	 c.clickOnSaveBtn();
	  c.reEnterCatName(name1);
	  b.clickOnRestbtn();
		b.clickOnAddCatBtn();
		AddRestaurantCategoryPage d=new AddRestaurantCategoryPage(driver);
		d.verifyEditedCategory(driver, name1);
	
	b.clickOnLogout();
	
	}


	}


