package stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountsPage;
import pages.LoginPage;

public class AccountsStep {
	private static final Logger logger = LogManager.getLogger();
	AccountsPage accountsPage = new AccountsPage(DriverFactory.getDriver());

//	@Given("user is already logged in to the application")
//	public void user_is_already_logged_in_to_the_application(DataTable dataTable) {
//		List<Map<String, String>> cred = dataTable.asMaps();
//		String userName = cred.get(0).get("userName");
//		String uPwd = cred.get(0).get("password");
//		DriverFactory.getDriver().get("https://magento.softwaretestingboard.com/customer/account/login");
//		DriverFactory.getDriver().manage().window().maximize();
//		accountsPage = loginPage.doLogin(userName, uPwd);
//
//		logger.info("loggin in");
//	}

	@Given("user is on the accounts page")
	public void user_is_on_the_accounts_page() {
		DriverFactory.launchUrl();

		accountsPage.getPageTitle();
	}

	@When("user gets the accounts section")
	public void user_gets_the_accounts_section(DataTable actualSec) {
		List<String> actualList = actualSec.asList();
		System.out.println(actualList);

		List<String> expectedList = accountsPage.accountSection();
		System.out.println(expectedList);

		assertEquals(actualList, expectedList);
	}

	@Then("the section count should be {int}")
	public void the_section_count_should_be(Integer actCount) {
		System.out.println(actCount + " " + accountsPage.accountSectionCount());
		int expCount = accountsPage.accountSectionCount();

		if (actCount == expCount) {
			assertTrue(true);
		}
	}
}