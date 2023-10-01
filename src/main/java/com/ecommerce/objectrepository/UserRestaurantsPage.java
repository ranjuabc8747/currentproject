package com.ecommerce.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserRestaurantsPage {
	@FindBy(xpath="//a[text()='Eataly'")
	private WebElement restname;
	public UserRestaurantsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getRestname() {
		return restname;
	}
	public void clickOnRestName()
	{
		restname.click();
	}
	
	

}
