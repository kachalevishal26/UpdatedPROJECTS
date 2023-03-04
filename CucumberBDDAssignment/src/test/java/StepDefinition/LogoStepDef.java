package StepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import POM.LogoPageObject;
import WebDriverFactory.DriverFactory;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoStepDef {

	LogoPageObject logoPageObject = new LogoPageObject(DriverFactory.getDriver());
	private static final Logger logger = LogManager.getLogger(LogoPageObject.class);
	
	@When("After launching Check logo is displayed or not")
	public void after_launching_check_logo_is_displayed_or_not() {
		boolean result=logoPageObject.chkLogoVisibility();
		Assert.assertTrue(result);
	
		logger.info("Logo displayed");
	}

	@Then("Logo  having width is {string} and height is {string}")
	public void logo_having_width_is_and_height_is(String width, String height) {
		logoPageObject.ChkLogoEidthHeight(width,height);
		logger.info("Both width and height are matched with expected width and height");

	}

}
