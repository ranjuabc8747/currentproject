package TestNG;

import org.testng.annotations.Test;

public class ExecuteDataProvider {
	@Test(dataProviderClass = DataProviderTest.class,dataProvider = "readDataFromExcel")
	public void Executemenu(String brand,String price,String year)
	{
		System.out.println(brand+"------>"+price+"----"+year);
	}

}
