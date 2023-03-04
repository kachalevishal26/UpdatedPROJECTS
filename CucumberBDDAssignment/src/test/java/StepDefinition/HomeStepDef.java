package StepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import POM.HomePageObject;
import WebDriverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomeStepDef {
	
	HomePageObject homePageObject=new HomePageObject(DriverFactory.getDriver());
	private static final Logger logger = LogManager.getLogger(HomeStepDef.class);
	
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
