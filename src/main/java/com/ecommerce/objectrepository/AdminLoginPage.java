package com.ecommerce.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
	@FindBy(name="username")
	private WebElement untxt;
	@FindBy(name="password")
	private WebElement pwdtxt;
	@FindBy(name="submit")
	private WebElement lgnbtn;
	public AdminLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getUntxt() {
		return untxt;
	}
	public WebElement getPwdtxt() {
		return pwdtxt;
	}
	public WebElement getLgnbtn() {
		return lgnbtn;
	}
	public void login(String username,String password)
	{
		untxt.sendKeys(username);
		pwdtxt.sendKeys(password);
		lgnbtn.click();
	}

}
