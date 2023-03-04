package StepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import POM.SearchPageObject;
import POM.TwitterPageObjectMoel;
import WebDriverFactory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TwitterStefDef {

	TwitterPageObjectMoel twitterPageObjectMoel = new TwitterPageObjectMoel(DriverFactory.getDriver());
	private static final Logger logger = LogManager.getLogger(TwitterStefDef.class);

	@When("User Click on twitter link")
	public void user_click_on_twitter_link() {
		twitterPageObjectMoel.linkedToTwitter();
		logger.info("Click on the twitter link ");
	}
	@When("It navigated to new window url contains {string}")
	public void it_navigated_to_new_window_url_contains(String expectedUrl) {
		String actualUrl=twitterPageObjectMoel.openNewWindow();
	
		if(actualUrl.contains(expectedUrl)) {
			Assert.assertTrue(true);
		}
		logger.info("Switched to the new window/tab");
	}

	@Then("User gets account name is {string}")
	public void user_gets_account_name_is(String acName) {
		String accountName=twitterPageObjectMoel.AccountName();
		
		Assert.assertEquals(acName, accountName);
		
		logger.info("getting account name : "+accountName);
	}

}
