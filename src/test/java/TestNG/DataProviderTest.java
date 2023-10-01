package TestNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.foodordering.genericutility.ExcelUtility;
import com.foodordering.genericutility.IPathconstants;

public class DataProviderTest {
	@Test(dataProvider = "vegMenu")
	public void Executemenu(String name,int price)
	{
		System.out.println(name+"------>"+price);
	}
	@DataProvider
	public Object[][] vegMenu()
	{
		Object[][] obj = new Object[2][2];
		
		obj[0][0]="vangibath";
		obj[0][1]=50;
		
		obj[1][0]="rice";
		obj[1][1]=30;
		
		return obj;
	}
	@DataProvider
	public Object[][] nonVegMenu()
	{
		Object[][] obj = new Object[2][3];
		
		obj[0][0]="dry Chicken";
		obj[0][1]=120;
		obj[0][2]="6 pieces";
		
		obj[1][0]="muttonfry";
		obj[1][1]=150;
		obj[1][2]="1 plate";
		return obj;
	}
	@DataProvider
	public Object[][] readDataFromExcel() throws Throwable
	{
		/*FileInputStream fis = new FileInputStream(IPathconstants.ExcelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("DataProvider");
		int lastrow = sh.getLastRowNum()+1;
	int	lastcell=sh.getRow(0).getLastCellNum();
	Object[][] obj = new Object[lastrow][lastcell];
	for(int i=0;i<lastrow;i++)
	{
		
		for(int j=0;j<lastcell;j++)
		{
			obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
		}
		}
return obj;*/
		ExcelUtility eLib = new ExcelUtility();
		Object[][] value = eLib.getMultipleSetOfDataFromExcel("DataProvider");
		return value;
		
}
}
