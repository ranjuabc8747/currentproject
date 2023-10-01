package TestNG;

import org.testng.annotations.Test;

public class Sample1Test {
	@Test(groups={"smoke"})
	public void sample1test()
	{
		System.out.println("-------sample1");
		
	}
	/*
	@Test(groups="regression")
	public void sample2Test()
	{
		System.out.println("------------sample2---------");
	}*/

}
