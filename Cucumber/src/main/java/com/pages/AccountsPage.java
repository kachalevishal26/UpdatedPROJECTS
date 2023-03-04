package com.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	private WebDriver driver;
	
	private By accountSection = By.cssSelector("div#center_column span");
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public int getAccountSectionCount() {
		return driver.findElements(accountSection).size();
	}
	
	public List<String> getAccountSectionList() {
		List<String> accountList = new ArrayList<>();
		List<WebElement> headerList = driver.findElements(accountSection);
		for(WebElement e : headerList) {
 			String text = e.getText();
			System.out.println(text);
			accountList.add(text);
		}
		return accountList;
	}
}
