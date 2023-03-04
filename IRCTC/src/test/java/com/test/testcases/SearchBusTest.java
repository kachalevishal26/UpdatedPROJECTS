package com.test.testcases;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.pages.SearchBus;

public class SearchBusTest extends TestBase {
	private static final Logger logger = LogManager.getLogger();
	SearchBus searchBus;

	public SearchBusTest() {
		super();
	}

	@Parameters("browser")
	@BeforeTest
	public void setUp(String browserName) {
		logger.info("executing the setup method");
		initialization(browserName);

		searchBus = new SearchBus();
	}

	@Test
	public void selectLocations() throws InterruptedException {
		logger.info("executing the select date method");
		searchBus.selLoc();
	}

	@Test
	public void selectDate() {
		logger.info("executing the select date method");
		searchBus.selDate();
		searchBus.clickBtn();
	}
	
	@Test
	public void busCount() {
		logger.info("executing the bus count method");
		assertEquals(searchBus.totalCount(), 20);
	}
	
	@AfterTest
	public void tearDown() {
		logger.info("quitting the browser");
		driver.quit();
	}
}