package com.foodordering.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ecommerce.objectrepository.AdminDashBoardPage;
import com.ecommerce.objectrepository.AdminLoginPage;

public class BaseClass {
	public DataBaseUtiLity dLib = new DataBaseUtiLity();
	public ExcelUtility eLib = new ExcelUtility();
	public FileUtility fLib = new FileUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public  WebDriver driver;
	public  static WebDriver sdriver;

	@BeforeSuite
	public void configBS() throws Throwable {
		dLib.connectToDB();
		System.out.println("------connect to DB---------");
	}

	@BeforeClass
	public void configBC() throws Throwable {
		String BROWSER = fLib.getPropertyKeyValue("browser");
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			System.out.println("--launching chromebrowser--");
		}
		else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			System.out.println("launching edge driver");
		} 
	else {
			System.out.println("invalid browser");
		}
		 sdriver = driver;
		wLib.maximizeTheBrowser(driver);
	}

	@BeforeMethod
	public void confifBM() throws Throwable {
		String URL = fLib.getPropertyKeyValue("adminurl");
		String USERNAME = fLib.getPropertyKeyValue("adminusername");
		String PASSWORD = fLib.getPropertyKeyValue("adminpassword");
		driver.get(URL);
		wLib.implicitWait(driver, 10);
		AdminLoginPage lp = new AdminLoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		System.out.println("-----Login to the application-----");

	}

	@AfterMethod
	public void configAM() {
		AdminDashBoardPage b = new AdminDashBoardPage(driver);
		b.clickOnLogout();
		System.out.println("-----Logout from the application---");
	}

	@AfterClass
	public void configAC() {
		driver.quit();
		System.out.println("----Close the Browser------");
	}

	@AfterSuite
	public void configAS() throws Throwable {
		dLib.closeDB();
		System.out.println("-----Disconnect the database-----");
	}
}
