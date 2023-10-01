package com.ecommerce.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v113.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage {
	@FindBy(xpath="//a[text()='Login']")
	private WebElement logntab;
	
public UserHomePage (WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public void clickOnLoginBtn()
{
	logntab.click();
}
}
