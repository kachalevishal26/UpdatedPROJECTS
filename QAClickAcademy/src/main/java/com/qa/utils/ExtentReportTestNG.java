package com.qa.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.qa.base.TestBase;

public class ExtentReportTestNG extends TestBase 
{
	static ExtentReports extent;
	
	public static ExtentReports getReport()
	{
		ExtentSparkReporter reporter = new ExtentSparkReporter("report/ExtentReport.html");
		reporter.config().setDocumentTitle("Test Reports");
		reporter.config().setReportName("Web Automation Report");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Vishal Kachale","Software Test Engineer");
		
		return extent;
	}
}
