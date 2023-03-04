package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePageObj {
	private WebDriver driver;

	private static final Logger logger = LogManager.getLogger();

	private By logo = By.id("header_logo");
	private By logoWidthHeight = By.xpath("//img[@class='logo img-responsive']");
	private By catSection = By.xpath("//div[@id='block_top_menu']//ul//li");
	private By searchBox = By.id("search_query_top");
	private By prodName = By.xpath("//h1[contains(text(),'Faded Short Sleeve T-shirts')]");
	private By socialIcons = By.xpath("//p[@class='socialsharing_product list-inline no-print']//button");
	private By printSendToFrndBtn = By.xpath("//ul[@id='usefull_link_block']//li");
	
	public HomePageObj(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement verifyLogo() {
		logger.info("Logo visibility");
		return driver.findElement(logo);
	}

	public String verifyLogoWidth() {
		logger.info("Verify logo width");
		return driver.findElement(logoWidthHeight).getAttribute("width");
	}

	public String verifyHeight() {
		logger.info("Verify logo height");
		return driver.findElement(logoWidthHeight).getAttribute("height");
	}

	public int categoryFeatureCount() {
		List<WebElement> catList = driver.findElements(catSection);
		String s = "";
		boolean b;
		logger.info("Category features count");
		List<String> list = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < catList.size(); i++) {
			b = catList.get(i).isDisplayed();

			if (b == true) {
				s = catList.get(i).getText();
				if (s != " ") {
					list.add(s);
				}
			}
			count++;
		}
		return count;
	}

	public List<String> categoryFeature() {
		List<WebElement> catList = driver.findElements(catSection);
		String s = "";
		boolean b;
		List<String> list = new ArrayList<>();
		logger.info("Category features");
		for (int i = 0; i < catList.size(); i++) {
			b = catList.get(i).isDisplayed();

			if (b == true) {
				s = catList.get(i).getText();
				if (s != " ") {
					list.add(s);
				}
			}
		}
		return list;
	}
	
	public void searchProduct(String productName) throws InterruptedException {
		WebElement prodElem = driver.findElement(searchBox);
		boolean b = driver.findElement(searchBox).isDisplayed();
		Actions action = new Actions(driver);
		if(b==true) {
			prodElem.click();
			Thread.sleep(2000);
			prodElem.sendKeys(productName);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			action.sendKeys(prodElem, Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		}
	}
	
	public boolean verifyProduct() {
		boolean b = driver.findElement(prodName).isDisplayed();
		return b;
//		if(b==true) {
//			
//		}
	}
}
