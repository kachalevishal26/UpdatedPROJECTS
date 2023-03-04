package com.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
	
	private static final Logger logger = LogManager.getLogger(LoginPage.class);
	
	WebDriver driver;
	private By signInBtn = By.xpath("//a[contains(text(),'Sign in')]");
	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By loginBtn = By.id("SubmitLogin");
	private By errorMsg = By.xpath("//p[contains(text(),'There is 1 error')]");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void navToLoginPage() {
		driver.findElement(signInBtn).click();
	}
	
	public String getPageTitle() {
		logger.info("get title");
		return driver.getTitle();
	}
	
	public void enterUserName(String userName) {
		driver.findElement(emailId).sendKeys(userName);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickLoginBtn() {
		driver.findElement(loginBtn).click();
	}
	
	public boolean errorMsg() {
		logger.info("invalid login");
		return driver.findElement(errorMsg).isDisplayed();
	}
	
	public AccountsPage doLogin(String uName, String uPwd) {
		driver.findElement(emailId).sendKeys(uName);
		driver.findElement(password).sendKeys(uPwd);
		driver.findElement(loginBtn).click();
		
		logger.info("login page");
		return null;
	}
}
