package com.demo.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsDemo 
{
	ExtentReports extent;
	@BeforeTest
	public void config()
	{
		
		ExtentSparkReporter reporter = new ExtentSparkReporter("target/ExtentReport.html");
		reporter.config().setReportName("Web Automation Reports");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Vishal Kachale");
		
		
	}
	
	@Test
	public void initialDemo()
	{
		ExtentTest test = extent.createTest("Initial Demo");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		System.out.println(driver.getTitle());
		driver.close();
		
//		test.fail("Result do not match!");
		extent.flush();
	}
}
