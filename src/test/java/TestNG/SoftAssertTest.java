package TestNG;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest
{
	@Test
	public void softAssert()
	{
	 String exp="a";
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888");
	 String actual=driver.getTitle();
	 System.out.println(actual);
	 SoftAssert sa=new SoftAssert();
	 
	 sa.assertEquals(actual, exp);
	 System.out.println("aplcn is launched");
	 System.out.println("execution is completed");
	
	
	

	 }

}
