package com.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testFAC {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ca.fifthavenuecollection.com/");
		
		List<WebElement> catList = driver.findElements(By.xpath("//ul[@class='category-navigation-list ']/li"));
		for (int i = 0; i < catList.size(); i++) {
			String itemName = catList.get(i).getText();
			System.out.println(itemName);
			if (itemName.equals("Watches")) {
				catList.get(i).click();
				break;
			}
		}
		
		WebElement sort = driver.findElement(By.id("products-orderby"));
		Select select = new Select(sort);
		select.selectByIndex(1);
	}
}
