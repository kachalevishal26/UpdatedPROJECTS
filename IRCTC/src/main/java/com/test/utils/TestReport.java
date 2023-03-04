package com.test.utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestReport {
	public static ExtentReports extent;

	public static ExtentReports getReport() {
		ExtentSparkReporter reporter = new ExtentSparkReporter(new File(".//Report/ExtentReport.html"));
		reporter.config().setDocumentTitle("IRCTC Test Report");
		reporter.config().setReportName("Automation Report");

		extent = new ExtentReports();
		extent.setSystemInfo("Vishal Kachale", "Test Engineer");
		extent.attachReporter(reporter);

		return extent;
	}
}
