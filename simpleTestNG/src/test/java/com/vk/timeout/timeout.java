package com.vk.timeout;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class timeout {

	//Timeout: Test will fail if it is not executed withing given time
	//expectedException: 
//	@Test(timeOut = 2000)
	@Test(expectedExceptions = {NoSuchElementException.class})
	public void testMethod() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://google.com");
		driver.findElement(By.id("abcd")).click();
		
		driver.quit();
	}

}
