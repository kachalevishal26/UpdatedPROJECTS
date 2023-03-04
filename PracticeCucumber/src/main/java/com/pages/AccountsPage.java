package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	private WebDriver driver;
	
	private static final Logger logger = LogManager.getLogger();
	
	private By accFeatures = By.cssSelector("div#center_column span");
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPageTitle() {
		logger.info("page title");
		return driver.getTitle();
	}
	
	public int accSectionCount() {
		List<WebElement> accountList = driver.findElements(accFeatures);
		String s= "";
		boolean b;
		List<String> l = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < accountList.size(); i++) {
			b = accountList.get(i).isDisplayed();
			
			if(b==true) {
				s = accountList.get(i).getText();
				if(s!=" ") {
					l.add(s);
				}
				count++;
			}
		}
		return count;
	}
	
	public List<String> accountFeatures() {
		List<WebElement> accList = driver.findElements(accFeatures);
		String s = "";
		boolean b;
		List<String> l = new ArrayList<>();
		for (int i = 0; i < accList.size(); i++) {
			b = accList.get(i).isDisplayed();
			
			if(b==true) {
				s = accList.get(i).getText();
				if(s!=" ") {
					l.add(s);
				}
			}
		}
		return l;
	}
}
