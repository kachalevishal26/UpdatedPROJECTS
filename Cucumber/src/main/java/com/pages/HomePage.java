package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	private static final Logger logger = LogManager.getLogger(HomePage.class);
	
	private WebDriver driver;
	private By logo = By.xpath("//img[@class='logo img-responsive']");
	private By catSection = By.xpath("//div[@id='block_top_menu']//ul//li");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean verifyLogo() {
		logger.info("checking logo");
		return driver.findElement(logo).isDisplayed();
	}
	
	public void logoWidthHeight() {
		String actualWidth = driver.findElement(logo).getAttribute("width");
		String actualHeight = driver.findElement(logo).getAttribute("height");
		
		logger.info("logo width and height");
	}
	
	public int sectionCount() {
		logger.info("categories section count");
		return driver.findElements(catSection).size();
	}
	
	public List<String> categorySection() {
		List<String> categoryList = new ArrayList<>();
		List<WebElement> headers = driver.findElements(catSection);
		for(WebElement e : headers) {
			String text = e.getText();
			categoryList.add(text);
		}
		return categoryList;
	}
}
