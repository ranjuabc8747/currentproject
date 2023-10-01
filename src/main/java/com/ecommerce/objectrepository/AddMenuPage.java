package com.ecommerce.objectrepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.foodordering.genericutility.JavaUtility;
import com.foodordering.genericutility.WebDriverUtility;


public class AddMenuPage extends WebDriverUtility {
	@FindBy(xpath="//input[@name='d_name']")
	private WebElement dishtxtfld;
	@FindBy(xpath="//input[@name='about']")
	private WebElement desctxtfld;
	@FindBy(xpath="//input[@name='price']")
	private WebElement pricetxtfld;
	@FindBy(xpath="//input[@name='file']")
	private WebElement imgtxtfld;
	@FindBy(xpath="//select[@name='res_name']")
	private WebElement selectresttxtfild;
	@FindBy(xpath="//input[@name='submit']")
	private WebElement savebtn;
	public AddMenuPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getDishtxtfld() {
		return dishtxtfld;
	}
	public WebElement getDesctxtfld() {
		return desctxtfld;
	}
	public WebElement getPricetxtfld() {
		return pricetxtfld;
	}
	public WebElement getImgtxtfld() {
		return imgtxtfld;
	}
	public WebElement getSelectresttxtfild() {
		return selectresttxtfild;
	}
	public WebElement getSendbtn() {
		return savebtn;
	}
	//Business Library
	
	public void addMenuByAllDetails(HashMap<String,String> hs,WebDriver driver,JavaUtility j,String restname)
	{
		for(Entry<String, String> e:hs.entrySet())
		{
			if(e.getKey().contains("d_name"))
			{
				driver.findElement(By.name(e.getKey())).sendKeys(e.getValue()+j.getRandomNumber());
			}
			else
			{
				driver.findElement(By.name(e.getKey())).sendKeys(e.getValue());
			}
		}
		selectDropDown(restname, selectresttxtfild);
		savebtn.click();
	}
	
}
