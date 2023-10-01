package com.practicepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToExcelTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData1.xlsx");
 Workbook wb = WorkbookFactory.create(fis);
 
 FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData1.xlsx");
 wb.getSheet("Restaurants").createRow(10).createCell(0).setCellValue("Qspider");
 wb.getSheet("Restaurants").getRow(10).createCell(1).setCellValue("Jspider");
 wb.getSheet("Restaurants").getRow(10).createCell(2).setCellValue("ranjitha");
 wb.write(fos);
 wb.close();
 
}

}
