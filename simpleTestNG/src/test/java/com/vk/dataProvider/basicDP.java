package com.vk.dataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basicDP {

	@Test(dataProvider = "loginData",dataProviderClass = ExcelDataSupplier.class)
	public void testLogin(String userName, String password) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(userName);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("welcome")).isDisplayed();
		Thread.sleep(5000);
		driver.quit();
	}

//	@DataProvider(name = "loginTestData")
//	public Object[][] loginData() {
//		Object[][] data = new Object[2][2];
//
//		data[0][0] = "Admin";
//		data[0][1] = "admin123";
//
//		data[1][0] = "Admin";
//		data[1][1] = "test123";
//
//		return data;
//	}

}
