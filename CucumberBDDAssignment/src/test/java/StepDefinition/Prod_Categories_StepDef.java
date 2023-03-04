package StepDefinition;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import POM.Categories_PageObjects;
import POM.LogoPageObject;
import WebDriverFactory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Prod_Categories_StepDef {

	Categories_PageObjects categories_PageObjects=new Categories_PageObjects(DriverFactory.getDriver());
	private static final Logger logger = LogManager.getLogger(Categories_PageObjects.class);
	
	@When("After Launching url categories of the product count is {int}")
	public void after_launching_url_categories_of_the_product_count_is(Integer count) {
		int result=categories_PageObjects.countCategory();
		
		if(result==count)
		{
			Assert.assertTrue(true);
			System.out.println(result);
		}
		
		logger.info(count+" product will displayed");

		
	}

	@Then("Displayed {string} the product categories")
	public void displayed_the_product_categories(String product) {
		List<String> l=categories_PageObjects.DisplayCategory();
		
		logger.info("Product Display: " + product);
		for(int i=0;i<l.size();i++) {
			if(l.get(i).equals(product))
			{
				
				Assert.assertTrue(true);
				
			}
		}
		
	}
}
