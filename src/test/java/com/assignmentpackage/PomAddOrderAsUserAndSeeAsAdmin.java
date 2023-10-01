package com.assignmentpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ecommerce.objectrepository.AdminLoginPage;
import com.ecommerce.objectrepository.AdminOrder;
import com.ecommerce.objectrepository.CheckoutPage;
import com.ecommerce.objectrepository.Dishpage;
import com.ecommerce.objectrepository.UserHomePage;
import com.ecommerce.objectrepository.UserHomePageAfterLogin;
import com.ecommerce.objectrepository.UserLoginPage;
import com.ecommerce.objectrepository.UserRestaurantsPage;
import com.foodordering.genericutility.ExcelUtility;
import com.foodordering.genericutility.FileUtility;
import com.foodordering.genericutility.JavaUtility;
import com.foodordering.genericutility.WebDriverUtility;

public class PomAddOrderAsUserAndSeeAsAdmin {
	static WebDriver driver=null;
	public static void main(String[] args) throws Throwable {
		WebDriverUtility wLib=new WebDriverUtility();
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String UURL =fLib.getPropertyKeyValue("UserURL");
		String UUSERNAME =fLib.getPropertyKeyValue("UserUsername");
		String UPASSWORD = fLib.getPropertyKeyValue("UserPassword");
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
		UserHomePageAfterLogin c=new UserHomePageAfterLogin(driver);
		c.clickOnRestBtn();
		UserRestaurantsPage d=new UserRestaurantsPage(driver);
		d.clickOnRestName();;
		Dishpage e= new Dishpage(driver);
		e.clickOnAddToCartBtn();;
		e.clickOnCheckOutBtn();;
		CheckoutPage f= new CheckoutPage(driver);
		f.clickOnOrderNowBtn(driver);;
		c.clickOnLogoutButton();
		String URL=	fLib.getPropertyKeyValue("adminurl");
		String USERNAME	=fLib.getPropertyKeyValue("adminusername");
		String PASSWORD	=fLib.getPropertyKeyValue("adminpassword");
		AdminLoginPage h = new AdminLoginPage(driver);
		h.login(USERNAME, PASSWORD);
		AdminOrder g=new AdminOrder(driver);
		g.clickOnOrderButton();
		g.verifyOrder(driver);
	
		
	
	


	
	
	
	
	//driver.findElement(By.xpath("//table/tbody/tr[last()]/td[8]/a[@class='btn btn-info btn-flat btn-addon btn-sm m-b-10 m-l-5']")).click();
	
	//driver.findElement(By.xpath("//table/tbody/tr[last()]/td[8]/a[@class='btn btn-danger btn-flat btn-addon btn-xs m-b-10']")).click();
	
	

}

}
