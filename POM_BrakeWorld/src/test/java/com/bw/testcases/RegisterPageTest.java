package com.bw.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bw.base.TestBase;
import com.bw.pages.InitialPage;
import com.bw.pages.RegisterPage;
import com.bw.util.DataSupplier;
import com.bw.util.TestUtil;

public class RegisterPageTest extends TestBase {
	InitialPage initialPage;
	RegisterPage registerPage;

	public RegisterPageTest() {
		super();
	}

	@BeforeTest
	public void setup() throws InterruptedException {
		initialization();
		initialPage = new InitialPage();
		registerPage = new RegisterPage();
		initialPage.scrollHomePage();
	}

	@DataProvider
	public Object[][] getTestData() {
		Object data[][] = DataSupplier.getData("Register");
		return data;
	}

	@Test(dataProvider = "getTestData")
	public void registerPageTest(String fname, String lname, String eEmail, String eCompany, String ePassword,
			String cpassword) throws InterruptedException {
		registerPage.registerForm(fname, lname, eEmail, eCompany, ePassword, cpassword);

		// Register
		boolean flag = registerPage.verifyRegister();
		assertTrue(flag);

		// HomePage
		initialPage = registerPage.continueHome();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
