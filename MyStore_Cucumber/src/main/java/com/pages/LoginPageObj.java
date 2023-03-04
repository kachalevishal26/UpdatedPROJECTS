package com.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.lv.Un;

public class LoginPageObj {
	private WebDriver driver;
	private static final Logger logger = LogManager.getLogger();
	
	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By loginBtn = By.id("SubmitLogin");
	private By forgotPwd = By.xpath("//a[contains(text(),'Forgot your password?')]");
	private By signInBtn = By.xpath("//a[@class='login']");
	private By errMsg = By.xpath("//p[contains(text(),'There is 1 error')]");
	
	public LoginPageObj(WebDriver driver) {
		this.driver = driver;
	}
	
	public void navToLogin() {
		driver.findElement(signInBtn).click();
		logger.info("Navigating to the login page");
	}
	
	public String getPageTitle() {
		logger.info("Getting page title");
		return driver.getTitle();
	}
	
	public boolean forgotPwdLink() {
		logger.info("Verify forgot password link");
		return driver.findElement(forgotPwd).isDisplayed();
	}
	
	public void enterUsername(String uName) {
		driver.findElement(emailId).sendKeys(uName);
		logger.info("Enter username");
	}
	
	public void enterPassword(String uPwd) {
		driver.findElement(password).sendKeys(uPwd);
		logger.info("Enter password");
	}
	
	public void clickLoginBtn() {
		driver.findElement(loginBtn).click();
		logger.info("Clicking login button");
	}
	
	public AccountsPageObj doLogin(String uName, String uPwd) {
		driver.findElement(emailId).sendKeys(uName);
		driver.findElement(password).sendKeys(uPwd);
		driver.findElement(loginBtn).click();
		
		logger.info("Do login");
		return new AccountsPageObj(driver);
	}
	
	public boolean invalidLogin() {
		logger.info("Negative testing for login");
		return driver.findElement(errMsg).isDisplayed();
	}
}
