package ranjitha;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ksrtc {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		int date=23;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.ksrtc.in/oprs-web/");
		driver.findElement(By.xpath("//input[@value='Date Of Departure']")).click();
driver.findElement(By.xpath("//a[.='"+date+"']")).click();
	}

}
