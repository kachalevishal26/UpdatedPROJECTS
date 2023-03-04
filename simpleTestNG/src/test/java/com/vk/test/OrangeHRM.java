package com.vk.test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {
	WebDriver driver;
	
	@Parameters("browserName")
	@BeforeTest
	public void initializeBrowser(@Optional("chrome") String browserName) {
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\chromedriver.exe\\");
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			System.err.println("Browser Name is Incorrect!");
			break;
		}
		
		driver.manage().window().maximize();
	}
	
	@Parameters("timeout")
	@AfterTest
	public void closeBrowser(Long timeout) throws InterruptedException {
		System.out.println(timeout);
		Thread.sleep(timeout);
		driver.quit();
	}
	
	@Parameters("url")
	@Test
	public void launchApp(String url) {
		driver.get(url);
		
	}
	
	@Parameters({"userName","password"})
	@Test
	public void loginDetails(String userName, String password) {
		driver.findElement(By.id("txtUsername")).sendKeys(userName);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		
	}
	
	@Test
	public void navigateToMyInfo() {
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		
	}
	
	@Test
	public void verifyMyInfo() {
		boolean actualValue = driver.findElement(By.id("employee-details")).isDisplayed();
		assertTrue(actualValue);
		
	}
	
	@Test
	public void verifyLogin() {
		WebElement element = driver.findElement(By.id("welcome"));
		assertTrue(element.isDisplayed());
		assertTrue(element.getText().startsWith("Welcome"));
	}
}