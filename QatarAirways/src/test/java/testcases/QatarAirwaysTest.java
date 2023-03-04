package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.QatarAirways;

public class QatarAirwaysTest extends TestBase {
	QatarAirways qatar;
	
	public QatarAirwaysTest() {
		super();
	}
	
	@BeforeTest
	public void setup() {
		initialization();
		qatar = new QatarAirways();
	}
	
	@Test
	public void searchFlight() throws InterruptedException {
		qatar.fromLocation();
		qatar.toLocation();
		qatar.tripType();
	}
}
