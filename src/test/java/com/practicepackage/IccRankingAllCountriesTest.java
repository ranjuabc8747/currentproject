package com.practicepackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class IccRankingAllCountriesTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://www.icc-cricket.com/");
		WebElement ranking = driver.findElement(By.xpath("//div[@class='main-navigation__header u-hide-desktop']//button[contains(text(),'Rankings')]"));
		Actions a=new Actions(driver);
		a.moveToElement(ranking).perform();
		driver.findElement(By.xpath("//div[@class='main-navigation__header u-hide-desktop' ]/descendant::a[@href='/rankings/womens/team-rankings']")).click();
		
	}

}
