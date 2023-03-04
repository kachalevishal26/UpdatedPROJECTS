package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;

	private By uId = By.id("email");
	private By uPwd = By.id("pass");
	private By signInBtn = By.id("send2");
	private By forgotBtn = By.xpath("(//span[contains(text(),'Forgot Your Password?')])[1]");
	private By createAccBtn = By.xpath("(//span[contains(text(),'Create an Account')])[1]");
	private By welcomeBtn = By.xpath("(//span[@class='logged-in'])[1]");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getPageTitle() {
		String title = driver.getTitle();

		return title;
	}

	public boolean forgotPwdBtn() {
		boolean fBtn = driver.findElement(forgotBtn).isDisplayed();

		return fBtn;
	}

	public boolean createAccBtn() {
		boolean crAccBtn = driver.findElement(createAccBtn).isDisplayed();

		return crAccBtn;
	}

	public void enterEmail(String userName) {
		driver.findElement(uId).sendKeys(userName);
	}

	public void enterPassword(String password) {
		driver.findElement(uPwd).sendKeys(password);
	}

	public void clickBtn() {
		driver.findElement(signInBtn).click();
	}

	public boolean verifyLogin() {
		boolean welBtn = driver.findElement(welcomeBtn).isDisplayed();

		return welBtn;
	}
	
	public AccountsPage doLogin(String username, String password) {
		driver.findElement(uId).sendKeys(username);
		driver.findElement(uPwd).sendKeys(password);
		driver.findElement(signInBtn).click();
		
		return new AccountsPage(driver);
	}
}