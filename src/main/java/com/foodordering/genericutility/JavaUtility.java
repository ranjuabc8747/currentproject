package com.foodordering.genericutility;

import java.util.Date;
import java.util.Random;
/**
 * This class consists of java related methods
 * @author HI
 *
 */



public class JavaUtility {
	/**
	 * This method is used to get the randomnumber
	 * @return
	 */
	public int getRandomNumber()
	{
		Random ran=new Random();
		int randomnum=ran.nextInt(1000);
		return randomnum;
				}
	/**
	 * This method is used to get the system date in ISI formate
	 * @return
	 */
	public String getSystemDate()
	{
		Date date = new Date();
		return date.toString();
		
	}
	/**
	 * This method is used to fetch the systemdate in required formate
	 * @return 
	 */
	public String getSystemDateInFormate()
	{
	Date newdate = new Date();
	 String[] d = newdate.toString().split(" ");
	 String day = d[0];
	String month=d[1];
	String date = d[2];
	String year = d[5];
	String finalFormate = day+" "+month+" "+year;
	return finalFormate;
	
	}
	
	

}
