package ranjitha;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Icc {
	

		public static void main(String[] args) {

			WebDriver driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
			List<WebElement> allmatchcount = driver.findElements(By.xpath("//tbody/tr[*]/td[3][text()<'40']"));
			List<WebElement>	 countrynames = driver.findElements(By.xpath("//tbody/tr[*]/td[3][text()<'40']/preceding-sibling::td/following-sibling::td/span[2]"));
		for(int i=0;i<allmatchcount.size();i++)
		{
			System.out.println(countrynames.get(i).getText()+" "+allmatchcount.get(i).getText());
		}
		}}
			


