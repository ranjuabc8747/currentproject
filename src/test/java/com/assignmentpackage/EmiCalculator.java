package com.assignmentpackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class EmiCalculator {

	public static void main(String[] args) {

WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
Actions a=new Actions(driver);
driver.get("https://emicalculator.net/");
List<WebElement> allpoints = driver.findElements(By.xpath("//*[name()='g' and @class='highcharts-markers highcharts-series-2 highcharts-spline-series highcharts-tracker']/*"));
for(WebElement one:allpoints)
{
	//WebElement ele = driver.findElement(By.xpath("//*[name()='path' and @class='highcharts-point']"));

 // a.moveToElement(one).perform();


 List<WebElement> alltext = driver.findElements(By.xpath("//*[ @class='highcharts-label highcharts-tooltip highcharts-color-undefined']//*//*"));
for( WebElement t:alltext)
{
	a.moveToElement(one).perform();
 String name = t.getText();
System.out.println(name);

}
driver.quit();
}
}
}