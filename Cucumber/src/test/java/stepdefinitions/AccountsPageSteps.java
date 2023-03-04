package stepdefinitions;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import com.factory.DriverFactory;
import com.pages.AccountsPage;
import com.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountsPageSteps {

	AccountsPage accountsPage;
	LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	@Given("user is already logged in")
	public void user_is_already_logged_in(DataTable credTable) {
		List<Map<String, String>> credList = credTable.asMaps();
		String uName = credList.get(0).get("username");
		String uPassword = credList.get(0).get("password");
		
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountsPage = loginPage.doLogin(uName, uPassword);
	}

	@Given("user is on the accounts page")
	public void user_is_on_the_accounts_page() {
		String title = loginPage.getLoginPageTitle();
		System.out.println(title);
	}

	@Then("user gets the accounts section")
	public void user_gets_the_accounts_section(DataTable sectionsList) {
		List<String> expectedAccountList = sectionsList.asList();
		System.out.println("Expected count: "+expectedAccountList);
		
		List<String> actualAccountList = accountsPage.getAccountSectionList();
		System.out.println("Actual count: "+actualAccountList);
		
		assertTrue(expectedAccountList.containsAll(actualAccountList));
	}

	@Then("the accounts section counts should be {int}")
	public void the_accounts_section_counts_should_be(Integer expectedSectionCount) {
		assertTrue(accountsPage.getAccountSectionCount() == expectedSectionCount);
	}
}
