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

public class AddRestaurantPge extends WebDriverUtility {
	@FindBy(xpath="//input[@name='res_name']")
	private WebElement restnametxtfld;
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailtxtfild;
	@FindBy(xpath="//input[@name='phone']")
	private WebElement phonumbtextfld;
	@FindBy(xpath="//input[@name='url']")
	private WebElement urlxtfld;
	@FindBy(xpath="//select[@name='o_hr']")
	private WebElement opnhrtxtfld;
	@FindBy(xpath="//select[@name='c_hr']")
	private WebElement closehrltxtfld;
	@FindBy(xpath="//select[@name='o_days']")
	private WebElement opendtxtfld;
	@FindBy(xpath="//select[@name='c_name']")
	private WebElement catgrtxtfld;
	@FindBy(xpath="//input[@name='submit']")
	private WebElement savebtn;

	
	public AddRestaurantPge(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public WebElement getSavebtn() {
		return savebtn;
	}
public void clickOnSubMitBtn()
{
	
	savebtn.click();

	}
	


	public String createRestwithAllfilds(HashMap<String,String>hs,WebDriver driver,JavaUtility jLib,String oh,String ch,String od,String cat)
	{
		String restname=null;
		for(Entry<String, String> e:hs.entrySet())
		{
			if(e.getKey().contains("res_name"))
			{
				 restname = e.getValue()+jLib.getRandomNumber();
				   driver.findElement(By.xpath(e.getKey())).sendKeys(restname);
			}
			else
			{
				driver.findElement(By.xpath(e.getKey())).sendKeys(e.getValue());
			}
		}
		selectDropDown(cat, catgrtxtfld);
		selectDropDown(oh, opnhrtxtfld);
		selectDropDown(ch, closehrltxtfld);
		selectDropDown(od, opendtxtfld);
		
		
		return restname;
		
	}
	public void validateRestAddedOrNot(WebDriver driver,int bcount)
	{
		try {
			String afteradding = driver.findElement(By.xpath("//p[text()='Restaurants']/preceding-sibling::h2")).getText();
			int acount = Integer.parseInt(afteradding);
			System.out.println(bcount);
			System.out.println(acount);
			if(bcount<acount)
			{
				System.out.println("Restaurant added successfully");
			}
			else
			
			
			{
				System.out.println("Restaurant not added");
			}
		}
			catch(Exception e)
			{
		
	}
	}
}

	


