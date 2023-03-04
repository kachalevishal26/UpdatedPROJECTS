package utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.TestBase;

public class TestExtent extends TestBase {
	static ExtentReports extent;
	
	public static ExtentReports getReport() {
		ExtentSparkReporter reporter = new ExtentSparkReporter(new File(".//reports/ExtentReport.html"));
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Luma Automation Report");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Vishal Kachale", "Test Engineer");
		
		return extent;
	}
}
