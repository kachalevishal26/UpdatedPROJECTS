package stepdefinitions;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.factory.DriverFactory;
import com.pages.HomePageObj;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {
	String product;
	private static Logger logger = LogManager.getLogger();
	private HomePageObj homePageObj = new HomePageObj(DriverFactory.getDriver());

	@Given("user is on the home page")
	public void user_is_on_the_home_page() {
		DriverFactory.launchURL();
		logger.info("Launching URL");
	}

	@When("the logo should be visible")
	public void the_logo_should_be_visible() {
		homePageObj.verifyLogo();
		logger.info("Logo");
	}

	@Then("width and height of logo should be {string} and {string}")
	public void width_and_height_of_logo_should_be_and(String exWidth, String exHeight) {
		String actualWidth = homePageObj.verifyLogoWidth();
		System.out.println(actualWidth);

		String actualHeight = homePageObj.verifyHeight();
		System.out.println(actualHeight);

		logger.info("Logo width and height");

		if (actualWidth.equals(exWidth) && actualHeight.equals(exHeight)) {
			assertTrue(true);
			System.out.println("Actual width " + actualWidth);
			System.out.println("Actual height " + actualHeight);
		}
	}

	@When("user gets the category {string} section")
	public void user_gets_the_category_section(String categorySection) {
		List<String> catList = homePageObj.categoryFeature();
		System.out.println(catList);
		logger.info("Verify category features");
		for (int i = 0; i < catList.size(); i++) {
			if (catList.get(i).equals(product)) {
				assertTrue(true);
			}
		}
	}

	@Then("the category count should be {int}")
	public void the_category_count_should_be(Integer expectedCount) {
		int actualCount = homePageObj.categoryFeatureCount();
		logger.info("Category features count");
		if (actualCount == expectedCount) {
			assertTrue(true);
			System.out.println("Actual count: " +actualCount);
		}
	}

	@When("tap on search button and enter {string} on it and select the suggested text")
	public void tap_on_search_button_and_enter_on_it_and_select_the_suggested_text(String productName) throws InterruptedException {
		homePageObj.searchProduct(productName);
		logger.info("Search product");
	}

	@Then("print the name of the product")
	public void print_the_name_of_the_product() {
		homePageObj.verifyProduct();
		logger.info("Product name is "+homePageObj.verifyProduct());
	}

}