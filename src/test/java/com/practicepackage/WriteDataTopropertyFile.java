package com.practicepackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WriteDataTopropertyFile {

	public static void main(String[] args) throws IOException {
		FileInputStream f=new FileInputStream(".\\src\\test\\resources\\writedata.properties");
		Properties p=new Properties();
		p.setProperty("aurl"," http://rmgtestingserver/domain/Online_Food_Ordering_System/admin/");
		p.setProperty("ausername", "admin");
		p.setProperty("apassword", "codeastro");
		p.setProperty("browser", "chrome");
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\writedata.properties");
		p.store(fos, "write data");
		fos.close();
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\writedata.properties");
		p.load(fis);
		String BROWSER=p.getProperty("browser");
		String AURL=p.getProperty("aurl");
		String USERNAME=p.getProperty("ausername");
		String PASSWORD=p.getProperty("apassword");
		WebDriver driver=new ChromeDriver();
		driver.get(AURL);
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("submit")).click();
		
	}

}
