package com.foodordering.genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtiLity {
	Connection con=null;
	/**
	 * This method is used to connect to database
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection(IPathconstants.dbURL,IPathconstants.dbUsername,IPathconstants.dbPassword);
	}
	/**
	 * This method is used to execute the query and get the data
	 * @param query
	 * @param columnno
	 * @param expdata
	 * @return
	 * @throws Throwable
	 */
	public String executeQueryAndGetData(String query,int columnno,String expdata) throws Throwable
	{
		Statement state = con.createStatement();
		  ResultSet result = state.executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
			String data = result.getString(columnno);
			if (data.equalsIgnoreCase(expdata))
			{
				flag=true;
				break;
			}
			
		}
		if(flag==true)
		{
			System.out.println("----Data is verified");
			return expdata;
		}
		
		else
		{
			System.out.println("Data is not present");
			return "";
		}
	}
	/**
	 * This method is used to close the database connection
	 * @throws Throwable 
	 */
		
		public void closeDB() throws Throwable
		{
			con.close();
		}
		
	}
