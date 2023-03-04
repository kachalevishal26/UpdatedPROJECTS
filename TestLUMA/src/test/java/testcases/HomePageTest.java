package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;

public class HomePageTest extends TestBase {
	HomePage homePage;

	public HomePageTest() {
		super();
	}

	@BeforeTest
	public void setup() {
		initialization();

		homePage = new HomePage();
	}
	
	@Test
	public void productTest() throws InterruptedException {
		homePage.product();
		homePage.menu();
	}
}
