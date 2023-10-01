package com.practicepackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQuery {

	public static void main(String[] args) throws Throwable {
		 Connection con = null;
		int result=0;
		try {
		Driver driver=new Driver();

		DriverManager.registerDriver(driver);
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
	Statement state = con.createStatement();
	String query="insert into ranjitha values('API','Sachin','Mysore');";
	result=state.executeUpdate(query);
	}
	catch(Exception e) {
		
	}
finally
{
	if(result==1)
	{
		System.out.println("data is created");
	}
	else
	{
		System.out.println("data is not created");
		
	}
	con.close();
}
}
}
	
