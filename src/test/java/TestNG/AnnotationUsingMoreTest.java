package TestNG;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationUsingMoreTest {
	@BeforeSuite
	public void configBS()
	{
		System.out.println("connect to db");
	}
	@BeforeClass
	public void configBC()
	{
		System.out.println("launch th browse");
	}
	@BeforeMethod
	public void configBM()
	{
		System.out.println("login");
	}
	@Test(dependsOnMethods = "test2")
	public void test1()
	{
		System.out.println("execute the testScript-1");
	}
	@AfterMethod
	public void configAM()
	{
		System.out.println("logout");
	}
	
	@Test(invocationCount =2,enabled = false)
	public void test2()
	{
		System.out.println("exexute ---2");
	}
	
	@AfterClass
	public void Ac()
	{
		System.out.println("close the browser");
	}
	@AfterSuite
	public void as()
	{
		System.out.println("disconnect db");
	}
	

}
