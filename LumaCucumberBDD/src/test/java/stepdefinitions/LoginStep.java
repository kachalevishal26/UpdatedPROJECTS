package stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginStep {
	private static final Logger logger = LogManager.getLogger();
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	public String title;

	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
		DriverFactory.launchUrl();

		logger.info("launched url");
	}

	@When("user gets the page title")
	public void user_gets_the_page_title() {
		title = loginPage.getPageTitle();

		logger.info("get the page title");
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String actTitle) {
		assertEquals(title, actTitle);

		logger.info("asserting the title");
	}

	@Then("forgot password button should be displayed")
	public void forgot_password_button_should_be_displayed() {
		assertTrue(loginPage.forgotPwdBtn());

		logger.info("verify forgot password step");
	}

	@Then("create account button should be displayed")
	public void create_account_button_should_be_displayed() {
		assertTrue(loginPage.createAccBtn());

		logger.info("verify create account step");
	}

	@When("user enters the email {string}")
	public void user_enters_the_email(String uName) {
		loginPage.enterEmail(uName);

		logger.info("username entered");
	}

	@When("user enters the password {string}")
	public void user_enters_the_password(String uPwd) {
		loginPage.enterPassword(uPwd);

		logger.info("password entered");
	}

	@When("user clicks the Sign In button")
	public void user_clicks_the_sign_in_button() {
		loginPage.clickBtn();

		logger.info("Sign In button us clicked");
	}
}