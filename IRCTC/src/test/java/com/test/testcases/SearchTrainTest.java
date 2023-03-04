package com.test.testcases;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.pages.SearchTrain;
import com.test.utils.TestUtils;

public class SearchTrainTest extends TestBase {
	private static final Logger logger = LogManager.getLogger();
	SearchTrain searchTrain;

	public SearchTrainTest() {
		super();
	}

	@Parameters("browser")
	@BeforeTest
	public void setUp(String browserName) {
		logger.info("executing the setup");
		initialization(browserName);

		searchTrain = new SearchTrain();
	}

	@DataProvider
	public Object[][] excelData() {
		Object data[][] = TestUtils.getData("locations");
		return data;
	}
	
	@Test(dataProvider = "excelData")
	public void selectLocation(String fromLocation, String toLocation) throws InterruptedException {
		logger.info("selecting locations");
		searchTrain.selLocation(fromLocation, toLocation);
	}

	@Test
	public void selectDate() {
		logger.info("selecting the date");
		searchTrain.selDate();
	}

	@Test
	public void selectClass() {
		logger.info("selecting the class");
		searchTrain.selClass();
	}

	@Test
	public void selectChkBox() {
		logger.info("selecting the checkbox and clicking the search button");
		searchTrain.selCheckBox();
		searchTrain.clickBtn();
	}
	
	@Test
	public void getTrainCount() {
		logger.info("retrieving the train count");
		assertEquals(searchTrain.getTrCount(), 44);
	}

	@AfterTest
	public void tearDown() {
		logger.info("quitting the browser");
		driver.quit();
	}
}