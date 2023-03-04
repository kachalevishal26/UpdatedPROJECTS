package com.bw.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bw.base.TestBase;

public class RegisterPage extends TestBase {
	// Define PageFactory
	@FindBy(xpath = "//a[contains(text(),'Register')]")
	WebElement clickRegBtn;

	@FindBy(id = "FirstName")
	WebElement fName;

	@FindBy(id = "LastName")
	WebElement lName;

	@FindBy(id = "Email")
	WebElement email;

	@FindBy(id = "Company")
	WebElement company;

	@FindBy(id = "Password")
	WebElement password;

	@FindBy(id = "ConfirmPassword")
	WebElement cPassword;

	@FindBy(id = "register-button")
	WebElement submitBtn;

	@FindBy(xpath = "//*[@class='button-1 register-continue-button']")
	WebElement continueBtn;

	@FindBy(xpath = "//*[@class='result']")
	WebElement result;

	// Initialize PageFactory
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public HomePage registerForm(String fname, String lname, String eEmail, String eCompany, String ePassword,
			String cpassword) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		clickRegBtn.click();

		fName.sendKeys(fname);
		lName.sendKeys(lname);
		email.sendKeys(eEmail);
		company.sendKeys(eCompany);
		password.sendKeys(ePassword);
		js.executeScript("scroll(0,150)");
		cPassword.sendKeys(cpassword);
		Thread.sleep(7000);
		WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
//		submit.click();
		Thread.sleep(2000);

		return new HomePage();
	}

	public boolean verifyRegister() {
		return result.isDisplayed();
	}

	public InitialPage continueHome() {
		continueBtn.click();

		return new InitialPage();
	}
}
