package com.practicepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritindDataUsingScannerClassTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\practiceexcel.xlsx");
Workbook wb = WorkbookFactory.create(fis);
FileOutputStream fos=new FileOutputStream("\\src\\test\\resources\\practiceexcel.xlsx");
Scanner s=new Scanner(System.in);
System.out.println("Enter the size of rows ");



	}

}
