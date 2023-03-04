package StepDefinition;

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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDef  {
	
	HomePageObject homePageObject=new HomePageObject(DriverFactory.getDriver());
	LogoPageObject logoPageObject = new LogoPageObject(DriverFactory.getDriver());
	Categories_PageObjects categories_PageObjects=new Categories_PageObjects(DriverFactory.getDriver());
	SearchPageObject searchPageObject = new SearchPageObject(DriverFactory.getDriver());
	TwitterPageObjectMoel twitterPageObjectMoel = new TwitterPageObjectMoel(DriverFactory.getDriver());

	private static final Logger logger = LogManager.getLogger(StepDef.class);
	
	@Given("User Launch url")
	public void user_launch_url() {
		DriverFactory.launchUrl();
		logger.info("launch Url");
		
	}

	@Then("User gets redirected URL {string}")
	public void user_gets_redirected_url(String redirectUrl) {
	  
		String actualurl=homePageObject.getUrl();
		
		Assert.assertEquals(redirectUrl, actualurl);
		logger.info("Browser navigated to URL:  :"+actualurl);
	}
}
