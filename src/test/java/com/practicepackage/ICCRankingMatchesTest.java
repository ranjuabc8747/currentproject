package com.practicepackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ICCRankingMatchesTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		int matches=40;
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		List<WebElement> allcountries = driver.findElements(By.xpath("//table/tbody/tr[*]/td[3][@class='table-body__cell u-center-text'and text()<"+matches+"]/preceding-sibling::td[@class='table-body__cell rankings-table__team']//span[@class='u-hide-phablet']"));
		for(int i=0;i<allcountries.size();i++)
		{
			 String eachteam = allcountries.get(i).getText();
			 System.out.println(eachteam);
		}
}
}
