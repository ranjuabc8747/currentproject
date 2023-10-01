package com.practicepackage;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllLinksTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		List<WebElement> alllinks = driver.findElements(By.xpath("//a"));
		System.out.println(alllinks.size());
	ArrayList <String>link	=new ArrayList<String>();
	for(int i=0;i<alllinks.size();i++)
	{
	String	eachlink =alllinks.get(i).getAttribute("href");
	URL url=null;
	int statuscode=0;
	try
	{
		url=new URL(eachlink);
		HttpURLConnection httpcon=(HttpURLConnection)url.openConnection();
		statuscode=httpcon.getResponseCode();
		if(statuscode>=400)
		{
			link.add(eachlink+"----->"+statuscode);
			System.out.println(eachlink+"---->"+statuscode);
			
		}
	}
		catch(Exception e)
		{
			link.add(eachlink);	
		}
	}
	}
		
	}


