package com.bw.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bw.base.TestBase;
import com.bw.pages.HomePage;
import com.bw.pages.InitialPage;
import com.bw.pages.RegisterPage;

public class InitialPageTest extends TestBase {
	InitialPage initialPage;
	RegisterPage registerPage;

	public InitialPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		initialPage = new InitialPage();
	}

	@Test
	public void scrollTest() throws InterruptedException {
		registerPage = initialPage.scrollHomePage();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
