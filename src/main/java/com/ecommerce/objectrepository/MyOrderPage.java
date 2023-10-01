package com.ecommerce.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyOrderPage {
	@FindBy(xpath="//a[text()='My Orders']")
	private WebElement myordrbtn;
	public MyOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getMyordrbtn() {
		return myordrbtn;
	}
	public void clickOnMyOrderbtn()
	{
		myordrbtn.click();
	}
	public void validateOrder(WebDriver driver,String expected)
	{
		try {
	String actual = driver.findElement(By.xpath("//table/tbody/tr[last()]/td[1]")).getText();
	if(actual.equalsIgnoreCase(expected))
	{
		System.out.println("order has been placed");
	}
	else
	{
		System.out.println("order has not been placed");	
	}}
	catch(Exception e)
	{
		
		}
	}	
}


