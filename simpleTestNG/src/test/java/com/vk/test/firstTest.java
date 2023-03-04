package com.vk.test;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class firstTest {

	@Test
	public void testGoogle() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("Seven Bits Technologies LLP",Keys.ENTER);
		//HardAssertion
		String expectedTitle = "Seven Bits Technologies LLP - Google Search";
		String actualTitle = driver.getTitle();
		
		assertEquals(expectedTitle,actualTitle);
//		Assert.assertEquals(expectedTitle,actualTitle,"Title is mismatched!"); //If title is not matching we can give message here.
//		System.out.println(driver.getTitle());
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test
	public void testFacebook() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.name("email")).sendKeys("vk26",Keys.ENTER);
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		
		SoftAssert softAssert = new SoftAssert();
		
		//Title
		String actualTitle = driver.getTitle();
		String expectedTitle = "Log in to Facebook";
		softAssert.assertEquals(actualTitle, expectedTitle,"Title is mismatched!");
		
		//URL
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://www.facebook.com/";
		softAssert.assertNotEquals(actualURL,expectedURL,"URL mismatched!");
		
		//Text
		String actualText = driver.findElement(By.name("email")).getAttribute("value");
		String expectText = "";
		softAssert.assertEquals(actualText,expectText,"Text is mismatched!");
		
		//Border
		String actualBorder = driver.findElement(By.name("email")).getCssValue("border");
		String expectedBorder = "1px solid rgb(240, 40, 73)";
		softAssert.assertEquals(actualBorder,expectedBorder,"Border color mismatched!");
		
		//ErrorMessage
		String actualError = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/div[2]")).getText();
		String expectedError = "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
		softAssert.assertEquals(actualError,expectedError,"Error mismatched!");
		
		
		driver.quit();
		softAssert.assertAll();
}
}