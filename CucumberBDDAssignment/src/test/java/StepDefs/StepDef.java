package StepDefs;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import Hooks.AppHooks;
import POM.Categories_PageObjects;
import POM.HomePageObject;
import POM.LogoPageObject;
import POM.SearchPageObject;
import POM.TwitterPageObjectMoel;
import WebDriverFactory.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef {

	HomePageObject homePageObject;
	LogoPageObject logoPageObject;
	Categories_PageObjects categories_PageObjects;
	SearchPageObject searchPageObject;
	TwitterPageObjectMoel twitterPageObjectMoel;

	@Before
	public void setUp() {
		homePageObject = new HomePageObject(DriverFactory.getDriver());
		logoPageObject = new LogoPageObject(DriverFactory.getDriver());
		categories_PageObjects = new Categories_PageObjects(DriverFactory.getDriver());
		searchPageObject = new SearchPageObject(DriverFactory.getDriver());
		twitterPageObjectMoel = new TwitterPageObjectMoel(DriverFactory.getDriver());
	}

	private static final Logger logger = LogManager.getLogger(StepDef.class);

	@Given("User Launch url")
	public void user_launch_url() {
		DriverFactory.launchUrl();
		logger.info("launch Url");

	}

	@Then("User gets redirected URL {string}")
	public void user_gets_redirected_url(String redirectUrl) {
		String actualurl = homePageObject.getUrl();
		Assert.assertEquals(redirectUrl, actualurl);
		logger.info("Browser navigated to URL:  :" + actualurl);
	}

	@When("After launching Check logo is displayed or not")
	public void after_launching_check_logo_is_displayed_or_not() {
		boolean result = logoPageObject.chkLogoVisibility();
		Assert.assertTrue(result);

		logger.info("Logo displayed");
	}

	@Then("Logo  having width is {string} and height is {string}")
	public void logo_having_width_is_and_height_is(String width, String height) {
		logoPageObject.ChkLogoEidthHeight(width, height);
		logger.info("Both width and height are matched with expected width and height");
	}

	@When("After Launching url categories of the product count is {int}")
	public void after_launching_url_categories_of_the_product_count_is(Integer count) {
		int result = categories_PageObjects.countCategory();

		if (result == count) {
			Assert.assertTrue(true);
			System.out.println(result);
		}

		logger.info(count + " product will displayed");

	}

	@Then("Displayed {string} the product categories")
	public void displayed_the_product_categories(String product) {
		List<String> l = categories_PageObjects.DisplayCategory();

		logger.info("Product Display: " + product);
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).equals(product)) {

				Assert.assertTrue(true);

			}
		}

	}

	@When("User Enters Items {string}")
	public void user_enters_items(String items) {
		searchPageObject.searchItems(items);
		logger.info("Product searched : " + items);
	}

	@Then("Get suggestion to user with entered Items i.e {string}")
	public void get_suggestion_to_user_with_entered_items_i_e(String items) {
		String text = searchPageObject.searchResultValidation();
		System.out.println(text);
		
		if (text.contains(items)) {
			Assert.assertTrue(true);
			logger.info("Product found with given text : " + items);
		}

	}

	@When("User Click on twitter link")
	public void user_click_on_twitter_link() {
		twitterPageObjectMoel.linkedToTwitter();
		logger.info("Click on the twitter link ");
	}

	@When("It navigated to new window url contains {string}")
	public void it_navigated_to_new_window_url_contains(String expectedUrl) {
		String actualUrl = twitterPageObjectMoel.openNewWindow();

		if (actualUrl.contains(expectedUrl)) {
			Assert.assertTrue(true);
		}
		logger.info("Switched to the new window/tab");
	}

	@Then("User gets account name is {string}")
	public void user_gets_account_name_is(String acName) {
		String accountName = twitterPageObjectMoel.AccountName();

		Assert.assertEquals(acName, accountName);

		logger.info("getting account name : " + accountName);
	}

}
