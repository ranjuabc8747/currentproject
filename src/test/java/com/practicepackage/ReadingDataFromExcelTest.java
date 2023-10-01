package com.practicepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingDataFromExcelTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData1.xlsx");
Workbook wb= WorkbookFactory.create(fis);
Sheet sh = wb.getSheet("Restaurants");
int count=sh.getLastRowNum();
System.out.println(count);
int lastcell=sh.getRow(1).getLastCellNum();//cell
System.out.println(lastcell);
for(int i=1;i<=count;i++)//row
{
	for(int j=0;j<lastcell;j++)
	{
		String value = sh.getRow(i).getCell(j).getStringCellValue();
		System.out.print(value+" ");
	}
	System.out.println();
	
}

	}

}
