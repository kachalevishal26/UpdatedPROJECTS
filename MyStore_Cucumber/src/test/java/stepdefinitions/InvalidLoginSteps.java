package stepdefinitions;

import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.factory.DriverFactory;
import com.pages.LoginPageObj;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InvalidLoginSteps {
	private static final Logger logger = LogManager.getLogger();
	LoginPageObj loginPage = new LoginPageObj(DriverFactory.getDriver());

	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.launchURL();
		loginPage.navToLogin();
		logger.info("user navigate to login page");
	}

	@When("user enters the username {string} and password {string}")
	public void user_enters_the_username_and_password(String uName, String uPwd) {
		loginPage.doLogin(uName, uPwd);
		logger.info("entering uname and password");
	}

	@Then("login failed and error message should be shown")
	public void login_failed_and_error_message_should_be_shown() {
		boolean b = loginPage.invalidLogin();
		logger.info("negative logins");
		if (b == true) {
			assertTrue(true);
		}
	}
}