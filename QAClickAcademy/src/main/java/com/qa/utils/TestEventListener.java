package com.qa.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.base.TestBase;

public class TestEventListener extends TestBase implements ITestListener
{
	ExtentTest test;
	ExtentReports extent = ExtentReportTestNG.getReport();

	public void onTestStart(ITestResult result) 
	{
		ITestListener.super.onTestStart(result);
		test = extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) 
	{
		ITestListener.super.onTestStart(result);
		test.log(Status.PASS, "Passed");
		
	}

	public void onTestFailure(ITestResult result) 
	{
		ITestListener.super.onTestStart(result);
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		extent.flush();
	}
	
}
