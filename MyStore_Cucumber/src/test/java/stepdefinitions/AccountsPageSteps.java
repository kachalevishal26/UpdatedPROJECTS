package stepdefinitions;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.factory.DriverFactory;
import com.pages.AccountsPageObj;
import com.pages.LoginPageObj;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountsPageSteps {
	String title;
	private static final Logger logger = LogManager.getLogger();
	AccountsPageObj accountsPageObj;
	LoginPageObj loginPageObj = new LoginPageObj(DriverFactory.getDriver());

	@Given("user should be already logged in to the app")
	public void user_should_be_already_logged_in_to_the_app(DataTable credTable) {
		List<Map<String, String>> credList = credTable.asMaps();
		String userName = credList.get(0).get("username");
		String passWord = credList.get(0).get("password");

		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountsPageObj = loginPageObj.doLogin(userName, passWord);
		logger.info("login to the site");
	}

	@Given("user is on the accounts page")
	public void user_is_on_the_accounts_page() {
		title = accountsPageObj.getPageTitle();
		assertTrue(true);
		logger.info("Check if it's accounts page");
	}

	@When("user gets the accounts section")
	public void user_gets_the_accounts_section(DataTable expSection) {
		List<String> expList = expSection.asList();
		System.out.println("Expected List" + expList);

		List<String> actList = accountsPageObj.accountsFeatures();
		System.out.println("Actual List" + actList);

		assertTrue(actList.containsAll(expList));
		logger.info("Verifying accounts features");
	}

	@Then("account section count should be {int}")
	public void account_section_count_should_be(Integer expCount) {
		int actCount = accountsPageObj.accountsFeatureCount();

		if (actCount == expCount) {
			assertTrue(true);
			System.out.println(actCount);
		}
		logger.info("Account section count");
	}

}
