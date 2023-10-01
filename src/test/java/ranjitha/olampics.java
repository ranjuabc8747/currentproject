package ranjitha;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class olampics {

	private static List<WebElement> allcountry;

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");

List<WebElement> all = driver.findElements(By.xpath("//span[@data-cy='country-name']"));
	//WebElement goldmedal = driver.findElement(By.xpath("//span[.='Argentina']/parent::div/following-sibling::div//span/span"));
	//WebElement silvermedal = driver.findElement(By.xpath("//span[.='Argentina']/parent::div/following-sibling::div[2]//span/span"));
	for(WebElement a:all)
	{
		
		WebElement goldmedal = driver.findElement(By.xpath("//span[.='"+a+"']/parent::div/ancestor::div[@data-cy='table-content']/preceding-sibling::div[1]//div[3]//span/following-sibling::div/../../following-sibling::div/div[4]//span/span"));
		//WebElement silvermedal = driver.findElement(By.xpath("//span[.='"+a+"']/parent::div/following-sibling::div[2]//span/span"));
	System.out.println(a.getText()+" "+goldmedal.getText());
	}
	}

}
