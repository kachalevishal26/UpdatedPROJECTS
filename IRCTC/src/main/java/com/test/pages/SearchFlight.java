package com.test.pages;

import static org.testng.Assert.expectThrows;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.base.TestBase;
import com.test.utils.TestUtils;

public class SearchFlight extends TestBase {
	private static final Logger logger = LogManager.getLogger();
	Actions action = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.EXPLICIT_WAIT));

	@FindBy(id = "stationFrom")
	WebElement fromLoc;

	@FindBy(id = "stationTo")
	WebElement toLoc;

	@FindBy(id = "originDate")
	WebElement departDate;

	@FindBy(xpath = "//input[@id='noOfpaxEtc']")
	WebElement classAirline;

	@FindBy(id = "TravellerEconomydropdown")
	WebElement dialog;

	@FindBy(xpath = "//button[@class='btn btn-md yellow-gradient home-btn']")
	WebElement searchBtn;

	public SearchFlight() {
		PageFactory.initElements(driver, this);
	}

	// Source Location
	public void srcLoc() throws InterruptedException {
		logger.info("selecting the source location");
		
		fromLoc.click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@id='ui-id-1']/li")));
		List<WebElement> listLoc = driver.findElements(
				By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete ui-front']/li"));

		for (int i = 0; i < listLoc.size(); i++) {
			String textLoc = listLoc.get(i).getText();
//			System.out.println(textLoc);

			if (textLoc.startsWith("Mumbai (BOM)")) {
				listLoc.get(i).click();
				break;
			}
//			else {
//				fromLoc.sendKeys("Vadodara (BDQ)");
//				Thread.sleep(2000);
//				action.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
//			}
		}
	}

	// Destination Location
	public void destLoc() throws InterruptedException {
		logger.info("selecting the destination location");
		
		toLoc.click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@id='ui-id-1']/li")));
		List<WebElement> listLoc = driver.findElements(
				By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete ui-front']/li"));
		for (int i = 0; i < listLoc.size(); i++) {
			String textLoc = listLoc.get(i).getText();
//			System.out.println(textLoc);

			if (textLoc.startsWith("Bengaluru (BLR)")) {
				listLoc.get(i).click();
				break;
			}
//			else {
//				fromLoc.sendKeys("Dubai (DWC)");
//				Thread.sleep(2000);
//				action.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
//			}
		}
	}

	public void selDepDate() {
		logger.info("selecting the date");
		
		departDate.click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
				"//div[@class='datepicker datepicker-dropdown datepicker-left datepicker-bottom rdeparturedate no-border']")));
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='date-table-right']/table/tr/td/span"));
		for (int i = 0; i < list.size(); i++) {
			String txt = list.get(i).getText();
			System.out.println(txt);

			if (txt.startsWith("APRIL")) {
				list.get(i).click();
				break;
			}
		}
		driver.findElement(By.xpath("//span[contains(text(),'26')]")).click();
	}

	public void selAirline() {
		logger.info("selecting the class and airline");
		
		classAirline.click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("TravellerEconomydropdown")));

		// Select Class
		WebElement selClass = driver.findElement(By.id("travelClass"));
		Select selCla = new Select(selClass);
		selCla.selectByVisibleText("Business");

		// Airlines
		WebElement selAirline = driver.findElement(By.xpath("//select[@name='selectedAirline']"));
		Select selAir = new Select(selAirline);
		selAir.selectByVisibleText("Indigo");
	}

	public void clickBtn() {
		logger.info("clicking search button");
		
		searchBtn.click();
	}
}