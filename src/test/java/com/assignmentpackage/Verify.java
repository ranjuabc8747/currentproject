package com.assignmentpackage;

import java.security.DrbgParameters.NextBytes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class Verify {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		Scanner sc=new Scanner(System.in);
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
Statement state = con.createStatement();
System.out.println("enter the name");
String name=sc.next();
String query="Select * from assign where name='"+name+"';";
ResultSet result = state.executeQuery(query);
boolean flag=false;
if(result.next())
{
	String a = result.getString(2);
	 if(a.equalsIgnoreCase(name))
	 {
		 System.out.println("name already exists");
	 }

else
{
	System.out.println("name doesnot exists");
	int id=Integer.parseInt(result.getString(1))+1;
String query1="Insert into assign values('"+id+"','"+name+"')";
int result1 = state.executeUpdate(query1);
String query2="Select * from assign where name='"+name+"';";
ResultSet result2 = state.executeQuery(query2);
if(result2.next())
		
{
	String name1 = result2.getString(2);
	if(name1.equalsIgnoreCase(name))
	{
		
	}
}
}
}
		}
		
		catch(Exception e) {
			
		}
		}
}

	


