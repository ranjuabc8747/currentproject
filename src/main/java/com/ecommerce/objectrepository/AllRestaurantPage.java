package com.ecommerce.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AllRestaurantPage {
	public AllRestaurantPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void validateRestaurant(WebDriver driver,String restuname)
	{
		try {
			driver.findElement(By.xpath("//table/tbody/tr[*]/td[2][.='"+restuname+"']"));
			System.out.println("Restaurant added successfully");
		}
		catch(Exception e)
		{
			System.out.println("Restaurant not added");
		}
	}

}
