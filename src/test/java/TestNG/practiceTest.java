package TestNG;

import org.testng.annotations.Test;

public class practiceTest {
	@Test(priority=2,invocationCount = 2)
	public void createTest()
	{
		System.out.println("--------data is created-----------");
	}
	@Test(priority=1,invocationCount = 1)
	public void editTest()
	{
		
		System.out.println("+++++++++++-data is Edited+++++++++++++"); 
		
	}
	@Test(priority=3,invocationCount = 3,dependsOnMethods ="editTest()" )
	public void deleteTest()
	{
		System.out.println("*********data is deleted********");
	}
	

}
