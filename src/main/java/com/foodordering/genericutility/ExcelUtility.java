package com.foodordering.genericutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtility {
	/**
	 * This method is used to read the data from excel sheet
	 * @param sheetname
	 * @param rowindex
	 * @param colindex
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String ReadDataFromExcelFile(String sheetname,int rowindex,int colindex) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathconstants.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		String value = sh.getRow(rowindex).getCell(colindex).getStringCellValue();
		return value;
		
	}
	/**
	 * This method is used to write the data in to excel sheet
	 * @param sheetname
	 * @param rowindex
	 * @param colindex
	 * @param value
	 * @throws Throwable
	 */
	public void writeDataInToExcelFile(String sheetname,int rowindex,int colindex,String value) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathconstants.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		  sh.createRow(rowindex).createCell(colindex).setCellValue(value);
		  FileOutputStream fos=new FileOutputStream(IPathconstants.ExcelFilePath);
		  wb.write(fos);
		  wb.close();
	}
	/**
	 * This method will fetch count the number of rows created in excel sheet
	 * @param Sheetname
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String Sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathconstants.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheetname);
		int lastrow = sh.getLastRowNum();
		return lastrow;
	}
	public  HashMap<String, String> getmultipledatafromexcel(String sheetname,int keycell,int valuecolumn) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathconstants.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int count = sh.getLastRowNum();
		HashMap<String, String> hs = new HashMap<String,String>();//empty map
		for(int i=1;i<=count;i++)
		{
		String key = sh.getRow(i).getCell(keycell).getStringCellValue();
		String value = sh.getRow(i).getCell(valuecolumn).getStringCellValue();
		hs.put(key, value);
		}
		return hs;
			
		}
	public Object[][] getMultipleSetOfDataFromExcel(String Sheetname) throws Throwable, IOException {
		FileInputStream fis=new FileInputStream(IPathconstants.ExcelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheetname);
		int lastrow = sh.getLastRowNum()+1;
		int lastcell = sh.getRow(0).getLastCellNum();
		Object[][] obj = new Object[lastrow][lastcell];
		for(int i=0;i<lastrow;i++)
		{
			for(int j=0;j<lastcell;j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
	}



