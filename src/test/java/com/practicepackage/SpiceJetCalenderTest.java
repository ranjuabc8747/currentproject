package com.practicepackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class SpiceJetCalenderTest {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		String month="September";
		int year=2023;
		int date=3;
		String retmonth="October";
		int Returnyear=2023;
		int returndate=2;
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div[text()='round trip']/ancestor::div[@data-testid='round-trip-radio-button']/div[@class='css-1dbjc4n r-zso239']")).click();
driver.findElement(By.xpath("//input[@value='Select Destination']")).click();
driver.findElement(By.xpath("//div[text()='Delhi']")).click();
driver.findElement(By.xpath("//div[text()='Departure Date']")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79' and text()='"+month+"'and text()='"+date+"']/ancestor::div[@data-testid='undefined-month-September-2023']//div[text()='"+date+"']")).click();
driver.findElement(By.xpath("//div[text()='Return Date']")).click();

driver.findElement(By.xpath("//div[text()='"+retmonth+"'and text()='"+Returnyear+"']/ancestor::div[@class='css-1dbjc4n r-1mdbw0j r-ymttw5 r-b2dl2 r-mzjzbw r-wk8lta r-tvv088']//div[text()='"+returndate+"']")).click();

WebElement adult = driver.findElement(By.xpath("//div[text()='1 Adult']"));
Select s=new Select(adult);
s.selectByVisibleText("Adult");
WebElement clickbutton = driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']"));
clickbutton.click();
clickbutton.click();
driver.findElement(By.xpath("//div[text()='Search Flight']"));

	}

}
