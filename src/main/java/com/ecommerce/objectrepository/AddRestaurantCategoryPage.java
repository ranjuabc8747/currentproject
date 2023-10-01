package com.ecommerce.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRestaurantCategoryPage {
	@FindBy(xpath="//input[@name='c_name']")
	private WebElement addcattxtfld;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement savebtn;
	@FindBy(xpath="//table/tbody/tr[2]/td[4]/a[2]")
	private WebElement editicon;
	
	
	public AddRestaurantCategoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getAddcattxtfld() {
		return addcattxtfld;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	public void enterCatname(String catname)
	{
		addcattxtfld.sendKeys(catname);	
		
	}
	public void clickOnSaveBtn()
	{
		savebtn.click();	
	}
	public void reEnterCatName(String name1)
	{
		editicon.click();
		addcattxtfld.clear();
		addcattxtfld.sendKeys(name1);
		savebtn.click();
	}
	public void verifyEditedCategory(WebDriver driver,String catname)
	{
		try {
			 String cat = driver.findElement(By.xpath("//table/tbody/tr[*]/td[text()='"+catname+"']")).getText();;
			System.out.println(cat);
			System.out.println("categaory name has changed successfully");
		}
		catch(Exception e)
		{
		System.out.println("category name has not changed");	
		}
	}
	

}
