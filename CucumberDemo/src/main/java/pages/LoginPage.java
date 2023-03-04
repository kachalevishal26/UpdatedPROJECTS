package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;

	private By myAcc = By.xpath("//span[contains(text(),'My Account')]");
	private By loginBtn = By.xpath("//a[contains(text(),'Login')]");
	private By emailId = By.id("input-email");
	private By pWd = By.id("input-password");
	private By subBtn = By.xpath("//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void navToLogin() {
		driver.findElement(myAcc).click();
		driver.findElement(loginBtn).click();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void enterEmail(String email) {
		driver.findElement(emailId).sendKeys(email);
	}

	public void enterPwd(String password) {
		driver.findElement(pWd).sendKeys(password);
	}

	public void clickBtn() {
		driver.findElement(subBtn).click();
	}

	public AccountPage doLogin(String email, String pass) {
		driver.findElement(emailId).sendKeys(email);
		driver.findElement(pWd).sendKeys(pass);
		driver.findElement(subBtn).click();
		
		return new AccountPage(driver);
	}
}