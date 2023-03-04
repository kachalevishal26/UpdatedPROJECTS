package stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

public class HomePageSteps {
	private static final Logger logger = LogManager.getLogger();
	HomePage homePage = new HomePage(DriverFactory.getDriver());

	@Given("user is on homepage")
	public void user_is_on_homepage() {
		DriverFactory.getDriver().get("https://magento.softwaretestingboard.com/");

		logger.info("launched the url");
	}

	@Given("the logo should be visible")
	public void the_logo_should_be_visible() {
		logger.info("checking the logo");
		boolean logo = homePage.chkLogo();

		if (logo == true) {
			assertTrue(logo);
		}
	}

//	@When("logo width should be {string}")
//	public void logo_width_should_be(String actWidth) {
//		assertEquals(actWidth, homePage.chkLogoWidth());
//		homePage.chkLogoWidth();
//	}

//	@When("logo height should be {string}")
//	public void logo_height_should_be(String actHeight) {
//		assertEquals(actHeight, homePage.chkLogoHeight());
//		homePage.chkLogoHeight();
//	}

	@Given("menubar should be visible")
	public void menubar_should_be_visible() {
		logger.info("checking the menubar visibility");
		assertTrue(homePage.menuVisible());
	}

	@When("menubar section should contain")
	public void menubar_section_should_contain(DataTable actData) {
		logger.info("checking the menubar contents");
		List<String> actualList = actData.asList();
		System.out.println(actualList);

		List<String> expectedList = homePage.chkMenubar();
		System.out.println(expectedList);

		assertEquals(actualList, expectedList);
	}

	@Then("section count should be {int}")
	public void section_count_should_be(Integer actCount) {
		logger.info("checking the menubar count");
		assertEquals(actCount, homePage.chkMenubarCount());
	}

	@Given("search bar should be visible")
	public void search_bar_should_be_visible() {
		logger.info("checking the search bar visibility");
		assertTrue(homePage.chkSearch());
	}

	@When("enter some text it should show search suggestions")
	public void enter_some_text_it_should_show_search_suggestions() throws InterruptedException {
		logger.info("checking the search bar suggestion options");
		assertTrue(homePage.chkSearchSuggestions());
	}

	@When("shopping cart should be visible")
	public void shopping_cart_should_be_visible() {
		logger.info("checking the shopping card icon visibiltiy");
		assertTrue(homePage.cartIcon());
	}
}
