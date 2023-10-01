package com.ecommerce.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dishpage {
	@FindBy(xpath="//a[text()='Checkout']")
	private WebElement chkotbtn;
	@FindBy(xpath="//a[text()='Pink Spaghetti Gamberoni']/ancestor::div[@class='food-item']/div/div[2]/input[@value='Add To Cart']")
	private WebElement addtocartbtn;
	public Dishpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getChkotbtn() {
		return chkotbtn;
	}
	public WebElement getAddtocartbtn() {
		return addtocartbtn;
	}
	public void clickOnAddToCartBtn()
	{
		addtocartbtn.click();
		
	}
	public void clickOnCheckOutBtn()
	{
		chkotbtn.click();
	}
	

}
