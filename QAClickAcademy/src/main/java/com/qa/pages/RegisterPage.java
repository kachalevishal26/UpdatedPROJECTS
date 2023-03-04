package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class RegisterPage extends TestBase 
{
	@FindBy(id = "user_name")
	WebElement fullName;
	
	@FindBy(id = "user_email")
	WebElement emailId;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@class='button btn-primary col-10-xs p-v-2-xs p-h-5-xs m-v-3-xs']")
	WebElement submitBtn;
	
	public RegisterPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void registerUser(String fName, String email, String pwd)
	{
		fullName.sendKeys(fName);
		emailId.sendKeys(email);
		password.sendKeys(pwd);
		submitBtn.click();
	}
}
