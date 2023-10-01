package TestNG;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationsTest {
	@Test
	public void test()
	{
		System.out.println("executeTheScript");
	}
	@BeforeSuite
	public void configBS()
	{
	System.out.println("***connect To database-*****");	
	}
	@BeforeClass
	public void conficBC()
	{
		System.out.println("----Launch the browser");
	}
	@BeforeMethod
	public void configBM()
	{
		System.out.println("--Login to the appl");
	}
	@AfterMethod
	public void configAM()
	{
		System.out.println("Logout from the app");
	}
	@AfterClass
	public void configAC()
	{
		System.out.println("---close the browser");
	}
	@AfterSuite
	public void configAS()
	{
		System.out.println("**---close the connection--***");
	}
	

}
