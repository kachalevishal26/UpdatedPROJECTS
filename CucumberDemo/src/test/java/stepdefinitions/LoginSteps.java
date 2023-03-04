package stepdefinitions;

import static org.testng.Assert.assertTrue;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps {
	String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
		loginPage.navToLogin();
	}

	@When("user gets the page title")
	public void user_gets_the_page_title() {
		title = loginPage.getPageTitle();
	}

	@Then("the page title should be {string}")
	public void the_page_title_should_be(String exTitle) {
		assertTrue(title.contains(exTitle));
	}

	@When("user enters the username {string}")
	public void user_enters_the_username(String uName) {
		loginPage.enterEmail(uName);
	}

	@When("user enters the password {string}")
	public void user_enters_the_password(String pWd) {
		loginPage.enterPwd(pWd);
	}

	@When("user clicks the submit button")
	public void user_clicks_the_submit_button() {
		loginPage.clickBtn();
	}
}