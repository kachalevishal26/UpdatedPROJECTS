package POM;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import StepDefinition.HomeStepDef;

public class HomePageObject {

	private static final Logger logger = LogManager.getLogger(HomePageObject.class);
	
	WebDriver driver;
	
	public HomePageObject(WebDriver driver){
		this.driver=driver;
	}

	public String getUrl() {
		String actualUrl=driver.getCurrentUrl();
		
		logger.info("get url : "+actualUrl);
		return actualUrl;
	}
	
	
}
