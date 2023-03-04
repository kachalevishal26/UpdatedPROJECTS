package stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.factory.DriverFactory;
import com.pages.LoginPageObj;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	private String title;
	private static final Logger logger = LogManager.getLogger();

	private LoginPageObj loginPageObj = new LoginPageObj(DriverFactory.getDriver());

	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
		DriverFactory.launchURL();
		loginPageObj.navToLogin();

		logger.info("launch url and navigate to login page");
	}

	@When("user gets the page title")
	public void user_gets_the_page_title() {
		title = loginPageObj.getPageTitle();

		logger.info("Get page title");
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String exTitle) {
		assertEquals(title, exTitle, "Title didn't matched");

		logger.info("Verify title");
	}

	@Then("forgot password link should be visible")
	public void forgot_password_link_should_be_visible() {
		assertTrue(loginPageObj.forgotPwdLink());

		logger.info("Verify forgot password link");
	}

	@When("user enters the username {string}")
	public void user_enters_the_username(String uName) {
		loginPageObj.enterUsername(uName);

		logger.info("Entering username..");
	}

	@When("user enters the password {string}")
	public void user_enters_the_password(String uPwd) {
		loginPageObj.enterPassword(uPwd);

		logger.info("Entering password..");
	}

	@When("user clicks the submit button")
	public void user_clicks_the_submit_button() {
		loginPageObj.clickLoginBtn();

		logger.info("Clicking login button..");
	}
}
