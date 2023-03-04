package com.vk.test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot {
	public static void main(String[] args) throws IOException {

		Date currentDate = new Date();
		System.out.println(currentDate);
		String ssName = currentDate.toString().replace(" ", "-").replace(":", "-");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://sevenbits.in");
		
		File ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ss, new File(".//screenshots//" + ssName +".png"));
		
		driver.quit();
	}
}
