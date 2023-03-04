package com.test.pages;

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
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.base.TestBase;
import com.test.utils.TestUtils;

public class SearchBus extends TestBase {
	private static final Logger logger = LogManager.getLogger();
	Actions action = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtils.EXPLICIT_WAIT));

	@FindBy(id = "departFrom")
	WebElement fromLoc;

	@FindBy(id = "goingTo")
	WebElement toLoc;

	@FindBy(id = "departDate")
	WebElement date;

	@FindBy(xpath = "//body/app-root[1]/ng-component[1]/div[3]/div[2]/div[2]/form[1]/div[4]/button[1]")
	WebElement searchBtn;

	public SearchBus() {
		PageFactory.initElements(driver, this);
	}

	public void selLoc() throws InterruptedException {
		logger.info("selecting the locations");
		fromLoc.sendKeys("Vapi");
		Thread.sleep(2000);
		action.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();

		toLoc.sendKeys("Vadodara");
		Thread.sleep(2000);
		action.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
	}

	public void selDate() {
		logger.info("selecting the date");
		date.click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='ui-datepicker-div']")));
		String monYear = driver.findElement(By.xpath("//body/div[@id='ui-datepicker-div']/div[1]/div[1]")).getText();
		System.out.println(monYear);
		String month = monYear.split(" ")[0].toString().trim();
		String year = monYear.split(" ")[1].toString().trim();
		while (!(month.equals("March") && year.equals("2023"))) {
			driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
			monYear = driver.findElement(By.xpath("//body/div[@id='ui-datepicker-div']/div[1]/div[1]")).getText();
			System.out.println(monYear);
			month = monYear.split(" ")[0].toString().trim();
			year = monYear.split(" ")[1].toString().trim();
		}
		driver.findElement(By.xpath("//a[contains(text(),'16')]")).click();
	}

	public void clickBtn() {
		logger.info("clicking the search button");
		searchBtn.click();
	}

	public int totalCount() {
		logger.info("retrieving the total bus count");
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='accordionExample']")));
		List<WebElement> list = driver.findElements(By.xpath("//div[@id='accordionExample']"));
		int no = list.size();

		return no;
	}
}