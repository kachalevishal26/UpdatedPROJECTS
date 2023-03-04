package com.test.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.pages.SearchFlight;

public class SearchFlightTest extends TestBase {
	SearchFlight searchFlight;
	
	public SearchFlightTest() {
		super();
	}
	
	@Parameters("browser")
	@BeforeTest
	public void setUp(@Optional String browserName) {
		initialization(browserName);
		searchFlight = new SearchFlight();
	}
	
	@Test
	public void locations() throws InterruptedException {
		searchFlight.srcLoc();
		searchFlight.destLoc();
		searchFlight.selDepDate();
		searchFlight.selAirline();
		searchFlight.clickBtn();
	}
}