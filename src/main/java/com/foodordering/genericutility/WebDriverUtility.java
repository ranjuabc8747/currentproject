package com.foodordering.genericutility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
         /**
		 * This method is used to maximize the browser
		 */
		public void maximizeTheBrowser(WebDriver driver)
		{
			driver.manage().window().maximize();
		}
		/**
		 * This method is used to minimise the browser
		 */
		public void minimizeTheBrowser(WebDriver driver)
		{
			driver.manage().window().minimize();

	}
		/**
		 * This method will wait until the elements gets loaded
		 */
public void implicitWait(WebDriver driver,int duration)
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
	
}
/**
 * This method will wait untill the url of the page gets loaded
 * @param driver
 * @param duration
 * @param expectedurl
 */
public void waitUntilUrlLoads(WebDriver driver,int duration,String expectedurl)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(duration));
	wait.until(ExpectedConditions.urlContains(expectedurl));
}
/**
 * This method will wait until the title of the page gets loaded
 * @param driver
 * @param duration
 * @param expectedtitle
 */

public void waituntiltitleloads(WebDriver driver,int duration,String expectedtitle)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(duration));
	wait.until(ExpectedConditions.titleContains(expectedtitle));
}
/**
 * This method will wait untill the element in the webpage get loaded
 * @param driver
 * @param duration
 * @param element
 */
public void waitUntilElementToBeClickable(WebDriver driver,int duration,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(duration));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
/**
 * This method will ignore nosuchelement exception and continues execution
 * @param driver
 * @param duration
 */
public void ignoreNoSuchElementException(WebDriver driver,int duration)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(duration));
	wait.ignoring(NoSuchElementException.class);
}
/**This method will wait untill the element is visible in the page
 * @throws Throwable 
 * 
 */
public void customWait(WebElement element) throws Throwable
{
	int count=0;
	while(count<20)
	{
		try {
			element.click();
			break;
		}
		catch(Exception e){
			Thread.sleep(1000);
			count++;
		}
	}
}
/**
 * This method will select a dropdown element based on index
 * @param element
 * @param Index
 */
public void selectDropDown(WebElement element,int Index)
{
	Select s=new Select(element);
	s.selectByIndex(Index);
}
/**
 * This method will select a dropdown element based on value
 * @param element
 * @param value
 */
public void selectDropDown(WebElement element,String value)
{
	Select s=new Select(element);
	s.selectByValue(value);
}
/**
 * This method will sect a dropdown based on visible text
 * @param text
 * @param element
 */
public void selectDropDown(String text,WebElement element)
{
	Select s=new Select(element);
	s.selectByVisibleText(text);
}
/**
 * This method is used to mouseover on a element
 * @param driver
 * @param element
 */
public void mouseOverOnElement(WebDriver driver,WebElement element)
{
	Actions a=new Actions(driver);
	a.moveToElement(element).perform();
}
/**
 * This method is used to right click on a element
 * @param driver
 * @param element
 */
public void rightClick(WebDriver driver,WebElement element)
{
	Actions a=new Actions(driver);
	a.contextClick(element).perform();
}
/**
 * This method is used to double click on a particular element
 * @param driver
 * @param element
 */
public void doubleClick(WebDriver driver,WebElement element)
{
	Actions a=new Actions(driver);
	a.doubleClick(element).perform();
	
}
/**
 * This method is used to drag and drop a element
 * @param driver
 * @param src
 * @param dest
 */
public void dragAndDrop(WebDriver driver,WebElement src,WebElement dest)
{
	Actions a=new Actions(driver);
	a.dragAndDrop(src, dest).perform();;
}
/**
 * This method is used to click on Enter key
 * @param driver
 */
public void clickOnEnterKey(WebDriver driver)
{
	Actions a=new Actions(driver);
	a.sendKeys(Keys.ENTER).perform();
}
/**
 * This method is used to switch from one frame to anather frame using index
 * @param driver
 * @param Index
 */
public void switchFrame(WebDriver driver,int Index)
{
	driver.switchTo().frame(Index);
}
/**
 * This method is used to switch from one frame to another by using string
 * @param driver
 * @param id
 */
public void switchFrame(WebDriver driver,String id)
{
	driver.switchTo().frame(id);
}
/**
 * This method is used to switch from one frame to another by using element
 * @param driver
 * @param element
 */
public void switchFrame(WebDriver driver,WebElement element)
{
	driver.switchTo().frame(element);
}
/**
 * This method is used to switch to mainframe
 * @param driver
 */
public void switchFrame(WebDriver driver)
{
	driver.switchTo().defaultContent();
}
/*public void switchFrame(WebDriver driver)
{
	driver.switchTo().parentFrame();
}*
/**
 * This method is used to take the screenshot of web page whenever the testscript gets failed
 * @param driver
 * @param screenshotname
 * @return
 */
public String takeScreenShot(WebDriver driver,String screenshotname)
{
	 TakesScreenshot ts = (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dest = new File("./screenshots/"+screenshotname+".png");
	try
	{
		Files.copy(src, dest);
	}
	
	 catch (Exception e) {
		// TODO: handle exception
	}
	return screenshotname;
}
/**
 * This msg is used to accept the alert popup of the page
 * @param driver
 * @param expectedmsg
 */
public void acceptAlertPopup(WebDriver driver,String expectedmsg) {
	Alert al = driver.switchTo().alert();
	if(al.getText().equalsIgnoreCase(expectedmsg))
	{
		System.out.println("alert msg is verified");
	}
	else
	{
		System.out.println("alert msg is not verified");
	}
al.accept();
}
/**
 * This msg is used to decline the alert popup of the page
 * @param driver
 * @param expectedmsg
 */
public void rejectAlertPopup(WebDriver driver,String expectedmsg)
{
	Alert al = driver.switchTo().alert();
	if(al.getText().equalsIgnoreCase(expectedmsg))
	{
		System.out.println("alert msg is verified");
	}
	else
	{
		System.out.println("alert msg is not verified");
	}
al.dismiss();
}
/**
 * This msg is used to switch from one window to other based on title
 * @param driver
 * @param Expectedtitle
 */
public void switchWindowBasedOnTitle(WebDriver driver,String Expectedtitle)
{
	Set<String> allwindow = driver.getWindowHandles();
	for(String eachwindow:allwindow)
	{
		driver.switchTo().window(eachwindow);
		String title = driver.getTitle();
		if(title.contains(Expectedtitle))
		{
			break;
		}
	}
}
/**
 * This method is used to switch from one window to other based on url
 * @param driver
 * @param ExpectedUrl
 */
	
public void switchWindowBasedOnUrl(WebDriver driver,String ExpectedUrl)
{
	Set<String> set = driver.getWindowHandles();
	Iterator<String> it = set.iterator();
	while(it.hasNext())
	{
		String wid = it.next();
		driver.switchTo().window(wid);
		String url = driver.getCurrentUrl();
		if(url.contains(ExpectedUrl))
		{
			break;
		}
	}
}
/**
 * This method is used to scroll to a particular element untill the specified element is found
 * @param driver
 * @param element
 */
public void scrollToParticularElement(WebDriver driver,WebElement element)
{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollInToView()",element);
	int y=element.getLocation().getY();
	//js.executeScript("window.scrollBy(0,"+y+")",element);
	
}
public void scrollBarAction(WebDriver driver,int x,int y)
{
	JavascriptExecutor js = (JavascriptExecutor)driver;	
	js.executeScript("window.scrollBy("+x+","+y+")","");
}
/**
 * This method is used to press the key
 * @throws Throwable
 */
public void keyPress() throws Throwable
{
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_ENTER);
}
/**
 * This method is used to release the key
 * @throws AWTException
 */
public void keyRelease() throws AWTException
{
	Robot r=new Robot();
	r.keyRelease(KeyEvent.VK_ENTER);
}
 
}



