package com.base;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pagination {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://ca.fifthavenuecollection.com/earrings");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		List<WebElement> listProd = driver.findElements(By.xpath("//h2[@class='product-title']"));
		List<String> list = new ArrayList<>();
		for (WebElement str : listProd) {
			String txt = str.getText();
			list.add(txt);
		}
	}
}
