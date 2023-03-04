package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import page.RegisterPage;

public class RegisterPageTest extends TestBase {
	RegisterPage registerPage;

	public RegisterPageTest() {
		super();
	}

	@BeforeTest
	public void setUp() {
		initialization();
		registerPage = new RegisterPage();
	}

	@Test
	public void regPage() {
		registerPage.navToReg();
		registerPage.regPage();
	}
	
	public void tearDown() {
		driver.quit();
	}
}
