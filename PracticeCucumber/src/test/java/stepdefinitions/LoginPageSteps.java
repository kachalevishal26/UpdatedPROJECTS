package stepdefinitions;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.factory.DriverFactory;
import com.pages.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	String title;
	LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private static final Logger logger = LogManager.getLogger(LoginPageSteps.class);
	
	@Given("^user navigates to the site$")
	public void user_navigates_to_the_site() throws Throwable {
		DriverFactory.getDriver().get("http://automationpractice.com/index.php");
		logger.info("Launch URL");
	}

	@When("^user enters the username \"([^\"]*)\"$")
	public void user_enters_the_username_something(String userName) throws Throwable {
		loginPage.enterUserName(userName);
	}

	@Then("^user successfully logged in and gets the accounts page title$")
	public void user_successfully_logged_in_and_gets_the_accounts_page_title() throws Throwable {
		title = loginPage.getPageTitle();
		logger.info("fetching page title");
	}

	@And("^user click on the Sign In button$")
	public void user_click_on_the_sign_in_button() throws Throwable {
		loginPage.navToLoginPage();
		logger.info("login button is clicked");
	}

	@And("^user enters the password \"([^\"]*)\"$")
	public void user_enters_the_password_something(String password) throws Throwable {
		loginPage.enterPassword(password);
	}

	@And("^user clicks the login button$")
	public void user_clicks_the_login_button() throws Throwable {
		loginPage.clickLoginBtn();
		logger.info("password is entered");
	}

	@And("^the title should be \"([^\"]*)\"$")
	public void the_title_should_be_something(String expectedTitle) throws Throwable {
		assertEquals(title, expectedTitle);
		logger.info("verifies the title"+title);
	}

}
