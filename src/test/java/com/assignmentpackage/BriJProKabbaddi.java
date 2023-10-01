package com.assignmentpackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BriJProKabbaddi {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1));
		String team="Bengaluru Bulls";
		driver.get("https://www.prokabaddi.com/standings");
		Thread.sleep(3000);
		List<WebElement> allTeam = driver.findElements(By.xpath("//div[@class='row-head']//div[@class='team-name']"));
		List<WebElement> allPlay = driver.findElements(By.xpath("//div[@class='row-head']//div[contains(@class,'play')]/p"));
		int size = allTeam.size();
		for(int i=0;i<size;i++)
		{
			System.out.println(allTeam.get(i).getText()+"\t"+allPlay.get(i).getText());
		}
		System.out.println("successfully read the target element");
		driver.manage().window().minimize();
		driver.quit();
		
//		WebElement row = driver.findElement(By.xpath("//p[.='Jaipur Pink Panthers']/ancestor :: div[@class='table-data team']/following-sibling :: div[contains(@class,'play')]/p"));
//		System.out.println(row.getText());
		
	}

}
