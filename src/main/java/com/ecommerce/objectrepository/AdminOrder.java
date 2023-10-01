package com.ecommerce.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminOrder {
	@FindBy(xpath="//span[text()='Orders']")
	private WebElement orderbtn;
	public AdminOrder(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	public void clickOnOrderButton()
	{
		orderbtn.click();
	}
	public void verifyOrder(WebDriver driver)
	{
		String ordername = driver.findElement(By.xpath("//table/tbody/tr[last()]/td[2]")).getText();
		if(ordername.equalsIgnoreCase("Pink Spaghetti Gamberoni"))
		{
			System.out.println("order has been placed successfully");
		}
		else
		{
			System.out.println("order has not been placed");
		}
	}
	

}
