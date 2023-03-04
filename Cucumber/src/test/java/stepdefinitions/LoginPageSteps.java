package stepdefinitions;

import org.testng.Assert;

import com.factory.DriverFactory;
import com.pages.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	public static String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	    @Given("^user is on login page$") 
	    public void user_is_on_login_page() throws Throwable {
	    	DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	    }

	    @When("^user gets the title of the page$")
	    public void user_gets_the_title_of_the_page() throws Throwable {
	    	title = loginPage.getLoginPageTitle();
	    	System.out.println("Title is "+title);
	    }

	    @When("^user enters username \"([^\"]*)\"$")
	    public void user_enters_username_something(String userName) throws Throwable {
	    	loginPage.enterUserName(userName);
	    }

	    @Then("^page title should be \"([^\"]*)\"$")
	    public void page_title_should_be_something(String expectedTitle) throws Throwable {
	    	Assert.assertTrue(title.contains(expectedTitle));
	    }

	    @Then("^forgot your password link should be displayed$")
	    public void forgot_your_password_link_should_be_displayed() throws Throwable {
	    	Assert.assertTrue(loginPage.ifForgotLinkExist());
	    }

	    @And("^user enters password \"([^\"]*)\"$")
	    public void user_enters_password_something(String password) throws Throwable {
	    	loginPage.enterPassword(password);
	    }

	    @And("^user clicks on Login button$")
	    public void user_clicks_on_login_button() throws Throwable {
	    	loginPage.clickOnLogin();
	    }

	}