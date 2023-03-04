package com.vk.invocation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testAttributes {

	@Test(invocationCount = 3, threadPoolSize = 3)
	public void testMethod() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
//		driver.manage().window().maximize();
		driver.get("https://randomuser.me/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@data-label='name']")).click();
		System.out.println("User name: " +  driver.findElement(By.id("user_value")).getText());
		
		driver.findElement(By.xpath("//li[@data-label='email']")).click();
		System.out.println("Email: " + driver.findElement(By.id("user_value")).getText());
		
		driver.quit();
	}
}
