package com.assignmentpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ecommerce.objectrepository.CheckoutPage;
import com.ecommerce.objectrepository.Dishpage;
import com.ecommerce.objectrepository.MyOrderPage;
import com.ecommerce.objectrepository.UserHomePage;
import com.ecommerce.objectrepository.UserHomePageAfterLogin;
import com.ecommerce.objectrepository.UserLoginPage;
import com.ecommerce.objectrepository.UserRestaurantsPage;
import com.foodordering.genericutility.ExcelUtility;
import com.foodordering.genericutility.FileUtility;
import com.foodordering.genericutility.JavaUtility;
import com.foodordering.genericutility.WebDriverUtility;

public class PomViewOrderAsUserTest {
	static WebDriver driver=null;
	public static void main(String[] args) throws Throwable {
		WebDriverUtility wLib=new WebDriverUtility();
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String UURL =fLib.getPropertyKeyValue("UserURL");
		String UUSERNAME =fLib.getPropertyKeyValue("UserUsername");
		String UPASSWORD = fLib.getPropertyKeyValue("UsePassword");
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
		driver.get(UURL);
		UserHomePage b=new UserHomePage(driver);
		b.clickOnLoginBtn();
		UserLoginPage a=new UserLoginPage(driver);
		a.userLogin(UUSERNAME, UPASSWORD);
	String expected="Cheesy Mashed Potato";
	UserHomePageAfterLogin c=new UserHomePageAfterLogin(driver);
	c.clickOnRestBtn();
	UserRestaurantsPage d=new UserRestaurantsPage(driver);
	d.clickOnRestName();
	Dishpage e= new Dishpage(driver);
	e.clickOnAddToCartBtn();
	e.clickOnCheckOutBtn();
	CheckoutPage f= new CheckoutPage(driver);
	f.clickOnOrderNowBtn(driver);
	MyOrderPage MyOrderPage = new MyOrderPage(driver);
	MyOrderPage.clickOnMyOrderbtn();
	
	MyOrderPage.validateOrder(driver, expected);
	
	}
}


