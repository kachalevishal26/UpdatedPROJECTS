package com.demo.test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testOrangeHRM {

	WebDriver driver;
	Actions action;
	@Parameters("browserName")
	@Test
	public void openBrowser(@Optional("chrome") String browserName) {

		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			action = new Actions(driver);
			driver.manage().window().maximize();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;

		default:
			System.err.println("Invalid browser name!");
			break;
		}
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@DataProvider
	public Object[][] testData() {
		Object data[][] = dataSupplier.getData("login");
		return data;
	}
	
	@Test(dataProvider = "testData")
	public void loginTest(String username, String password) {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
	}
	
	@AfterTest
	public void exit() {
		driver.quit();
	}

	@Test
	public void verifyLogin() {
		WebElement loginVerify= driver.findElement(By.id("welcome"));
		assertTrue(loginVerify.isDisplayed());
		assertTrue(loginVerify.getText().startsWith("Welcome"));
	}

	@DataProvider
	public Object[][] registrationData() {
		Object data[][] = dataSupplier.getData("Sheet1");
		return data;
	}
	
	@Ignore
	@Test(dataProvider = "registrationData")
	public void addEmployee(String fname,String mname, String lname, String uname, String pass, String pass2) {
		//HoverOnPIM
		WebElement PIM = driver.findElement(By.id("menu_pim_viewPimModule"));
		action.moveToElement(PIM).build().perform();

		//ClickAddEmployee
		driver.findElement(By.id("menu_pim_addEmployee")).click();

		//AddEmployee
		driver.findElement(By.id("firstName")).sendKeys(fname);
		driver.findElement(By.id("middleName")).sendKeys(mname);
		driver.findElement(By.id("lastName")).sendKeys(lname);
		driver.findElement(By.id("photofile")).sendKeys("C:\\Users\\Asus\\Pictures\\Saved Pictures\\Wallpaper.jpg");
		driver.findElement(By.id("chkLogin")).click();
		driver.findElement(By.id("user_name")).sendKeys(uname);
		driver.findElement(By.id("user_password")).sendKeys(pass);
		driver.findElement(By.id("re_password")).sendKeys(pass2);

		WebElement status = driver.findElement(By.id("status"));
		Select stat = new Select(status);
		stat.selectByValue("Enabled");
	}

}
