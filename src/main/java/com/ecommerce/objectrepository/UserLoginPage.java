package com.ecommerce.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage {
	@FindBy(xpath="//input[@name='username']")
	private WebElement untxtfild;

	@FindBy(xpath="//input[@name='password']")
private WebElement paswdtxtfild;
	@FindBy(xpath="//input[@name='submit']")
	private WebElement lognbtn;
	public UserLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getUntxtfild() {
		return untxtfild;
	}

	public WebElement getPaswdtxtfild() {
		return paswdtxtfild;
	}

	public WebElement getLognbtn() {
		return lognbtn;
	}

	//Business library
	public  void userLogin(String un,String pwd)
	{
		untxtfild.sendKeys(un);
		paswdtxtfild.sendKeys(pwd);
		lognbtn.click();
	}
}
