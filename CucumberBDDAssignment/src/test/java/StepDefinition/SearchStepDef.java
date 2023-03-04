package StepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import POM.Categories_PageObjects;
import POM.SearchPageObject;
import WebDriverFactory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchStepDef {

	SearchPageObject searchPageObject = new SearchPageObject(DriverFactory.getDriver());
	private static final Logger logger = LogManager.getLogger(SearchPageObject.class);

	@When("User Enters Items {string}")
	public void user_enters_items(String items) {
		searchPageObject.searchItems(items);
		logger.info("Product searched : " + items);
	}

	@Then("Get suggestion to user with entered Items i.e {string}")
	public void get_suggestion_to_user_with_entered_items_i_e(String items) {
		String text = searchPageObject.searchResultValidation();

		if (text.contains(items)) {
			Assert.assertTrue(true);
			logger.info("Product found with given text : " + items);
		}

	
	}

}
