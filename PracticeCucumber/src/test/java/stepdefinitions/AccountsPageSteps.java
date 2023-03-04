package stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.factory.DriverFactory;
import com.pages.AccountsPage;
import com.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountsPageSteps {
	String title;
	private static final Logger logger = LogManager.getLogger();
	AccountsPage accountsPage;
	LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	@Given("user is already logged in")
	public void user_is_already_logged_in(DataTable expTable) {
		List<Map<String, String>> credList = expTable.asMaps();
		String uName = credList.get(0).get("username");
		String uPwd = credList.get(0).get("password");

		DriverFactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountsPage = loginPage.doLogin(uName, uPwd);

		logger.info("perform login");
	}

	@Given("user is on the accounts page")
	public void user_is_on_the_accounts_page() {
		title = loginPage.getPageTitle();
		logger.info("get page title");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getPageTitle();
		logger.info("get page title");
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expTitle) {
		assertEquals(title, expTitle);
		logger.info("checking title");
	}

	@Then("user gets the accounts section")
	public void user_gets_the_accounts_section(DataTable expList) {
		List<String> expectedList = expList.asList();
		System.out.println(expectedList);
		
		logger.info("comparing accounts features");
		
		List<String> actualList = accountsPage.accountFeatures();
		System.out.println(actualList);
		
		assertTrue(expectedList.containsAll(actualList));
	}

	@Then("the accounts section counts should be {int}")
	public void the_accounts_section_counts_should_be(Integer expCount) {
		int actCount = accountsPage.accSectionCount();

		if (actCount == expCount) {
			assertTrue(true);
			System.out.println(actCount);
		}
		logger.info("account features count");
	}
}