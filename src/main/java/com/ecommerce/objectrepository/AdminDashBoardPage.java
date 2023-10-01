package com.ecommerce.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashBoardPage {
	@FindBy(xpath="//span[text()='Users']")
	private WebElement usersbtn;
	@FindBy(xpath="//span[text()='Restaurant']")
	private WebElement restaurantbtn;
	@FindBy(xpath="//span[text()='Menu']")
	private WebElement menubtn;
	@FindBy(xpath="//span[text()='Orders']")
	private WebElement orderbtn;
	@FindBy(xpath="//a[text()='All Restaurant']")
	private WebElement allrestbtn;
	@FindBy(xpath="//a[text()='Add Category']")
	private WebElement addcatbtn;
	@FindBy(xpath="//a[text()='Add Restaurant']")
	private WebElement  addrestaurantbtn;
	@FindBy(xpath="//a[text()='All Menues']")
	private WebElement allmenubtn;
	@FindBy(xpath="//a[text()='Add Menu']")
	private WebElement addmenubtn;
	@FindBy(xpath="//img[@class='profile-pic']")
	private WebElement logtsymble;
	@FindBy(xpath="//a[text()=' Logout']")
	private WebElement logtbtn;
	@FindBy(xpath="//span[text()='Dashboard']")
	private WebElement dashbrdbtn;
	public AdminDashBoardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getDashbrdbtn() {
		return dashbrdbtn;
	}

	public void setDashbrdbtn(WebElement dashbrdbtn) {
		this.dashbrdbtn = dashbrdbtn;
	}

	public void clickOnDashboardButton()
	{
		dashbrdbtn.click();
	}
			public void clickOnAddRestaurantBtn()
	{
		restaurantbtn.click();
		addrestaurantbtn.click();
	}
	public void clickOnRestbtn()
	{
		restaurantbtn.click();
	}
	public WebElement getRestaurantbtn() {
		return restaurantbtn;
	}
	
	public WebElement getAddcatbtn() {
		return addcatbtn;
	}
public void clickOnAddCatBtn()
	{
		addcatbtn.click();
	}
public WebElement getMenubtn() {
		return menubtn;
	}
	public WebElement getAddmenubtn() {
		return addmenubtn;
	}
		public WebElement getAllmenubtn() {
		return allmenubtn;
	}

public WebElement getAllrestbtn() {
		return allrestbtn;
	}
public void clickOnMenuButton()
	{
		menubtn.click();
		addmenubtn.click();
	}
	public void clickOnAllMenu()
	{
		allmenubtn.click();
	}
	public void clickOnAllRestaurant()
	{
		allrestbtn.click();	
	}
	public void clickOnLogout()
	{
		logtsymble.click();
		logtbtn.click();
	}
	
	
}
