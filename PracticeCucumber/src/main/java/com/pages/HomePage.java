package com.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private static final Logger logger = LogManager.getLogger(HomePage.class);

	private WebDriver driver;

	private By logo = By.id("header_logo");
	private By logoWidthandHeight = By.xpath("//img[@class='logo img-responsive']");
	private By catOptions = By.xpath("//div[@id='block_top_menu']//ul//li");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean checkLogo() {
		logger.info("checking logo");
		return driver.findElement(logo).isDisplayed();
	}

	public String logoWidth() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("checking logo width");
		return driver.findElement(logoWidthandHeight).getAttribute("width");
	}

	public String logoHeight() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("checking logo height");
		return driver.findElement(logoWidthandHeight).getAttribute("height");
	}

	public boolean categoryExist() {
		logger.info("checking category section exist or not");
		return driver.findElement(catOptions).isDisplayed();
	}

	public int catSectionCount() {
		List<WebElement> catList = driver.findElements(catOptions);
		String s = "";
		boolean b;
		List<String> l = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < catList.size(); i++) {
			b = catList.get(i).isDisplayed();

			if (b == true) {
				s = catList.get(i).getText();
				if(s!=" ") {
					l.add(s);
				}
				count++;
			}
		}
		return count;
	}

	public List<String> verifyCategorySection() {
		List<String> categoryList = new ArrayList<>();

		List<WebElement> headerList = driver.findElements(catOptions);
		String s = "";
		boolean b;
		for (int i = 0; i < headerList.size(); i++) {
			b = headerList.get(i).isDisplayed();

			if (b == true) {
				s = headerList.get(i).getText();
				if (s != "") {
					categoryList.add(s);
				}
			}
		}
		return categoryList;
	}
}