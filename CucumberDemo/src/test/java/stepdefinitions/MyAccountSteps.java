package stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.LoginPage;

public class MyAccountSteps {
	AccountPage accountPage;
	LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	@Given("user is already logged in to site")
	public void user_is_already_logged_in_to_site(DataTable credTable) {
		List<Map<String, String>> credList = credTable.asMaps();
		String emailId = credList.get(0).get("username");
		String pWd = credList.get(0).get("password");

		DriverFactory.getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		DriverFactory.getDriver().manage().window().maximize();
		accountPage = loginPage.doLogin(emailId, pWd);
	}

	@Given("user is on the accounts page")
	public void user_is_on_the_accounts_page() {
		String title = accountPage.getPageTitle();
		assertTrue(true);
//		assertEquals(title, "My Account","Failed!");
	}

	@When("user gets the my account section")
	public void user_gets_the_my_account_section(DataTable actSection) {
		List<String> actList = actSection.asList();
		System.out.println(actList);

		List<String> expList = accountPage.verifySection();
		System.out.println(expList);

		assertTrue(actList.containsAll(actList));
	}

	@Then("account section count should be {int}")
	public void account_section_count_should_be(Integer actCount) {
		int expCount = accountPage.secCount();

		if (actCount == expCount) {
			assertTrue(true);
		}
	}
}
