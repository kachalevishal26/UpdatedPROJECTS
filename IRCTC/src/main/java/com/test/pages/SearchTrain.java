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

public class SearchTrain extends TestBase {
	private static final Logger logger = LogManager.getLogger();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	Actions action = new Actions(driver);

	@FindBy(xpath = "//body/app-root[1]/app-home[1]/div[3]/div[1]/app-main-page[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-jp-input[1]/div[1]/form[1]/div[2]/div[1]/div[1]/p-autocomplete[1]/span[1]/input[1]")
	WebElement fromLoc;

	@FindBy(xpath = "//body/app-root[1]/app-home[1]/div[3]/div[1]/app-main-page[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-jp-input[1]/div[1]/form[1]/div[2]/div[1]/div[2]/p-autocomplete[1]/span[1]/input[1]")
	WebElement toLoc;

	@FindBy(xpath = "//body[1]/app-root[1]/app-home[1]/div[3]/div[1]/app-main-page[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-jp-input[1]/div[1]/form[1]/div[2]/div[2]/div[1]/p-calendar[1]/span[1]/input[1]")
	WebElement date;

	@FindBy(xpath = "//body/app-root[1]/app-home[1]/div[3]/div[1]/app-main-page[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-jp-input[1]/div[1]/form[1]/div[2]/div[2]/div[2]/p-dropdown[1]/div[1]")
	WebElement trClass;

	@FindBy(xpath = "//button[contains(text(),'Search')]")
	WebElement searchButton;

	public SearchTrain() {
		PageFactory.initElements(driver, this);
	}

	public void selLocation(String fromLocation, String toLocation) throws InterruptedException {
		logger.info("selecting locations");

		fromLoc.sendKeys(fromLocation);
		Thread.sleep(1000);
		action.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();

		toLoc.sendKeys(toLocation);
		Thread.sleep(1000);
		action.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
	}

	public void selDate() {
		logger.info("selecting the date");
		date.click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
				"//body/app-root[1]/app-home[1]/div[3]/div[1]/app-main-page[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-jp-input[1]/div[1]/form[1]/div[2]/div[2]/div[1]/p-calendar[1]/span[1]/div[1]")));

		String monYear = driver.findElement(By.xpath(
				"//body/app-root[1]/app-home[1]/div[3]/div[1]/app-main-page[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-jp-input[1]/div[1]/form[1]/div[2]/div[2]/div[1]/p-calendar[1]/span[1]/div[1]/div[1]/div[1]/div[1]"))
				.getText();
		System.out.println(monYear);
		while (!(monYear.equals("April2023"))) {
			driver.findElement(By.xpath(
					"//body/app-root[1]/app-home[1]/div[3]/div[1]/app-main-page[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-jp-input[1]/div[1]/form[1]/div[2]/div[2]/div[1]/p-calendar[1]/span[1]/div[1]/div[1]/div[1]/a[2]"))
					.click();
			monYear = driver.findElement(By.xpath(
					"//body/app-root[1]/app-home[1]/div[3]/div[1]/app-main-page[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-jp-input[1]/div[1]/form[1]/div[2]/div[2]/div[1]/p-calendar[1]/span[1]/div[1]/div[1]/div[1]/div[1]"))
					.getText();
			System.out.println(monYear);
		}
		driver.findElement(By.xpath("//a[contains(text(),'16')]")).click();
	}

	public void selClass() {
		logger.info("selecting the class");
		trClass.click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
				"//body/app-root[1]/app-home[1]/div[3]/div[1]/app-main-page[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-jp-input[1]/div[1]/form[1]/div[2]/div[2]/div[2]/p-dropdown[1]/div[1]/div[4]")));
		List<WebElement> classList = driver.findElements(By.xpath("//span[@class='ng-star-inserted']"));
		for (int i = 0; i < classList.size(); i++) {
			String text = classList.get(i).getText();
			
			if (text.equals("xyz")) {
				classList.get(i).click();
			}
		}
	}

	public void selCheckBox() {
		logger.info("selecting the check box");
		List<WebElement> chkList = driver.findElements(By.xpath("//label[@class='css-label_c t_c']"));
		for (int i = 0; i < chkList.size(); i++) {
			String txt = chkList.get(i).getText();

			if (txt.equalsIgnoreCase("Train with Available Berth")) {
				chkList.get(i).click();
			}
		}
	}

	public void clickBtn() {
		logger.info("clicking the search button");
		searchButton.click();
	}

	public int getTrCount() {
		logger.info("getting train list count");
		List<WebElement> trainList = driver.findElements(By.xpath("//div[@class='white-back no-pad col-xs-12']"));
		int count = trainList.size();

		return count;
	}
}