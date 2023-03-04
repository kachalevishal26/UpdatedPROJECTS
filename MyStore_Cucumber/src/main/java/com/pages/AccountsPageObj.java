package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPageObj {
	private WebDriver driver;

	private static final Logger logger = LogManager.getLogger();

	private By accSection = By.cssSelector("div#center_column span");

	public AccountsPageObj(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}

	public int accountsFeatureCount() {
		List<WebElement> accList = driver.findElements(accSection);
		String s;
		boolean b;
		List<String> l = new ArrayList<>();
		int count = 0;
		logger.info("Accounts features count");
		for (int i = 0; i < accList.size(); i++) {
			b = accList.get(i).isDisplayed();

			if (b == true) {
				s = accList.get(i).getText();
				if (s != " ") {
					l.add(s);
				}
			}
			count++;
		}
		return count;
	}

	public List<String> accountsFeatures() {
		List<WebElement> accList = driver.findElements(accSection);
		String s;
		boolean b;
		List<String> l = new ArrayList<>();
		for (int i = 0; i < accList.size(); i++) {
			b = accList.get(i).isDisplayed();

			if (b == true) {
				s = accList.get(i).getText();
				if (s != " ") {
					l.add(s);
				}
			}
		}
		return l;
	}
}
