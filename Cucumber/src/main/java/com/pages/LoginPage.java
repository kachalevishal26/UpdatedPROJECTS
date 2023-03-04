package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	
	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By subBtn = By.id("SubmitLogin");
	private By forgotLink = By.xpath("//a[contains(text(),'Forgot your password?')]");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean ifForgotLinkExist() {
		return driver.findElement(forgotLink).isDisplayed();
	}
	
	public void enterUserName(String userName) {
		driver.findElement(emailId).sendKeys(userName);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickOnLogin() {
		driver.findElement(subBtn).click();
	}
	
	public AccountsPage doLogin(String uName, String pwd) {
		System.out.println("Username: "+uName+"Password: "+pwd);
		driver.findElement(emailId).sendKeys(uName);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(subBtn).click();
		return new AccountsPage(driver);
	}
}
