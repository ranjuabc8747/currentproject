package com.assignmentpackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IccRankingMatches {
      public static void main(String[] args)
      {
			WebDriver driver=new ChromeDriver();
			int matches=40;
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
			List<WebElement> allcountry = driver.findElements(By.xpath("//table//tr/th[3]/span[.='Matches']/ancestor::th//ancestor::thead/following-sibling::tbody/tr[*]/td[3][text()<40 ]/preceding-sibling::td/ span[ @class='u-hide-phablet']"));
			for(int i=0;i<allcountry.size();i++)
			
			{
				String value = allcountry.get(i).getText();
				List<WebElement> allcount = driver.findElements(By.xpath("//table//tr/th[3]/span[.='Matches']/ancestor::th//ancestor::thead/following-sibling::tbody/tr[*]/td[3][text()<40]"));
				for(int j=0;j<allcount.size();j++)
				{
					String num = allcount.get(i).getText();
				System.out.println(value+"  "+num);
			}
			
			//List<WebElement> allcountries = driver.findElements(By.xpath("//td[3][@class='table-body__cell u-center-text'and text()<40]"));
			// List<WebElement> allname = driver.findElements(By.xpath("//table/tbody/tr[*]/td[*]/span[2]"));
			
			}}
      
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

