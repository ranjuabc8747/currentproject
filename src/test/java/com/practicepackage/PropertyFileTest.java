package com.practicepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFileTest {

	public static void main(String[] args) throws Throwable {

		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commandata.properties");
		Properties p=new Properties();
		p.load(fis);
		String Browser = p.getProperty("browser");
		String adminurl = p.getProperty("adminurl");
		String adminusername=p.getProperty("adminusername");
		String adminpassword=p.getProperty("adminpassword");
		String UserURL = p.getProperty("UserURL");
		String UserUsername=p.getProperty("UserUsername");
		String UsePassword=p.getProperty("UsePassword");
		System.out.println(Browser);
		System.out.println(adminurl );
		System.out.println(adminusername);
		System.out.println(adminpassword);
		System.out.println(UserURL );
		System.out.println(UserUsername);
		System.out.println(UsePassword);
}
	
}
