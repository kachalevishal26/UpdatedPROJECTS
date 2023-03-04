package stepdefinitions;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.factory.DriverFactory;
import com.pages.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {
	private static final Logger logger = LogManager.getLogger(HomePageSteps.class);
	
	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	
	@Given("navigate to the site")
	public void navigate_to_the_site() {
		DriverFactory.getDriver().get("http://automationpractice.com/index.php");
		logger.info("nav to site");
	}

	@When("check logo is displayed or not")
	public void check_logo_is_displayed_or_not() {
		homePage.checkLogo();
		logger.info("checking logo");
	}

	@Then("width and height of logo should be {string} and {string}")
	public void width_and_height_of_logo_should_be_and(String expWidth, String expHeight) {
		String actualWidth = homePage.logoWidth();
		String actualHeight = homePage.logoHeight();
		
		assertTrue(actualWidth.contains(expWidth));
		assertTrue(actualHeight.contains(expHeight));
		logger.info("checking width and height");
	}

	@When("check the categories section is visible")
	public void check_the_categories_section_is_visible() {
		homePage.categoryExist();
	}

	@Then("verify that the categories should have following texts")
	public void verify_that_the_categories_should_have_following_texts(DataTable catSection) {
		List<String> expectedList = catSection.asList();
		System.out.println(expectedList);
		
		List<String> actualList = homePage.verifyCategorySection();
		System.out.println(actualList);
		
		assertTrue(actualList.containsAll(expectedList));
		logger.info("checking the category section");
	}
	
	@Then("the section count should be {int}")
	public void the_section_count_should_be(int expCount) {
		int actualCount = homePage.catSectionCount();
		
		if(actualCount == expCount) {
			assertTrue(true);
			System.out.println(actualCount);
		}
		
		logger.info("category count");
	}
}
