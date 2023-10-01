package com.foodordering.genericutility;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImpClass  implements ITestListener  {
ExtentReports report;
ExtentTest test;
public ExtentSparkReporter htmlreport;


	public void onTestStart(ITestResult result) {
		//actual testscripts execution starts from here
		String MethodName=result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		Reporter.log(MethodName+"-----> Execution starts");
		
		
	}

	public void onTestSuccess(ITestResult result) {
		
		String MethodName=result.getMethod().getMethodName();
		test.log(Status.PASS,MethodName+"-->passed");
		Reporter.log(MethodName+"-----> Testscript executed successfully");
	}

	public void onTestFailure(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		WebDriverUtility b = new WebDriverUtility();
		try {
   String failedpath=b.takeScreenShot(BaseClass.sdriver, MethodName);
test.addScreenCaptureFromPath(failedpath);
	
	
	}
		catch (Exception e) {
			// TODO: handle exception
		}
		test.log(Status.FAIL,result.getThrowable());
		test.log(Status.FAIL,MethodName+"---------->failed");
	Reporter.log(MethodName+"-----Failed");
	
	}
	public void onTestSkipped(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		test.log(Status.SKIP,MethodName+"-->skipped");
		Reporter.log(MethodName+"------>execution skipped");
	}

	public void onStart(ITestContext context) {
		//create report
		 htmlreport=new ExtentSparkReporter("./ExtentReports/report.html");
		htmlreport.config().setDocumentTitle("SDET-51");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("online food ordering");
		
		report=new ExtentReports();
		report.setSystemInfo("os","windows-10");
		report.setSystemInfo("Base-Browser","chrome");
		report.setSystemInfo("Base-Url","http://localhost:8888");
		
		report.setSystemInfo("Reporter Name","Ranjitha");
		
		}

	public void onFinish(ITestContext context) {
		report.flush();
		
	}
	
	
	
	

}
