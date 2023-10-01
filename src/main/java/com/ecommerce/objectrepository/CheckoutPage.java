package com.ecommerce.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	@FindBy(xpath="//input[@value='Order Now']")
private WebElement ordernwbtn;
	public CheckoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getOrdernwbtn() {
		return ordernwbtn;
	}
	public void clickOnOrderNowBtn(WebDriver driver)
	{
		ordernwbtn.click();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
	}
	
}
