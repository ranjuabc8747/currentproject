package ranjitha;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Meprokabbaddi {

	public static void main(String[] args) {
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("https://www.prokabaddi.com/standings");
String name="Bengaluru Bulls";
 List<WebElement> all = driver.findElements(By.xpath("//div[@class='table-body']/div//div[@class='team-name']"));
WebElement point = driver.findElement(By.xpath("//p[.='"+name+"']/ancestor::div[@class='table-data team']/following-sibling::div/p"));
WebElement won = driver.findElement((By.xpath("//p[text()='"+name+"']/ancestor::div[@class='table-data team']/following-sibling::div[2]/p")));
for(WebElement a:all)
{
	if(name.equalsIgnoreCase(a.getText()))
	{
		System.out.println(a.getText());
		System.out.println("total number of points is "+point.getText()+"");
		System.out.println("total no of matches wonis "+won.getText()+"");
	}
}
	}}
