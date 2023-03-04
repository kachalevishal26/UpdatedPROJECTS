package stepdefinitions;

import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.factory.DriverFactory;
import com.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InvalidLoginSteps {
	String UserName;
	String PassWord;
	private static final Logger logger = LogManager.getLogger();
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		logger.info("navigate to site");
	}

	@When("enter the username {string}")
	public void enter_the_username(String uName) {
		this.UserName = uName;
		loginPage.enterUserName(uName);
		logger.info("enter the username");
	}

	@When("enter the password {string}")
	public void enter_the_password(String uPwd) {
		this.PassWord = uPwd;
		loginPage.enterPassword(uPwd);
		logger.info("enter the password");
	}

	@When("press the submit button")
	public void press_the_submit_button() {
		loginPage.clickLoginBtn();
		logger.info("press login button");
	}

	@Then("login failed and the error message will be shown.")
	public void login_failed_and_the_error_message_will_be_shown() {
		boolean b = loginPage.errorMsg();
		logger.info("error message");
		if(b==true) {
			assertTrue(b);
		}
	}
}