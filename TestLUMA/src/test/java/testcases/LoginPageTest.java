package testcases;

import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import testdata.DataSupplier;

public class LoginPageTest extends TestBase {
	private static final Logger logger = LogManager.getLogger();
	LoginPage loginPage;

	public LoginPageTest() {
		super();
	}

	@BeforeTest
	public void setUp() {
		logger.info("setup");
		initialization();

		loginPage = new LoginPage();
	}

	@Test
	public void navToLoginTest() {
		logger.info("nav to login test");

		loginPage.navToLogin();
	}
	
	@DataProvider
	public Object excelData() {
		Object data = DataSupplier.getData("login");
		
		return data;
	}

	@Test(dataProvider = "excelData")
	public void loginTest(String email, String pwd) {
		logger.info("login test");

		loginPage.login(email, pwd);
	}

	@Test
	public void verifyLoginTest() {
		logger.info("verify login test");

		assertTrue(loginPage.verifyLogin());
	}
	
	@AfterTest
	public void tearDown() {
		logger.info("quitting the browser");
		driver.quit();
	}
}