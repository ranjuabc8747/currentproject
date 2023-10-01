

package com.ecommerce.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePageAfterLogin {
	@FindBy(xpath="//a[text()='Restaurants ']")
	private WebElement restbutton;
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logtbtn;
	@FindBy(xpath="//a[text()='My Orders']")
	private WebElement myorderbtn;
	public UserHomePageAfterLogin(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getRestbutton() {
		return restbutton;
	}
	public WebElement getLogtbtn() {
		return logtbtn;
	}
	
	public WebElement getMyorderbtn() {
		return myorderbtn;
	}
	public void clickOnRestBtn()
	{
		restbutton.click();
	}
	public void clickOnLogoutButton()
	{
		logtbtn.click();
	}
	public void clickOnMyOrdersButton()
	{
		myorderbtn.click();
	}
	
	
	

}
