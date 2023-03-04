package com.bw.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bw.base.TestBase;
import com.bw.util.TestUtil;

public class HomePage extends TestBase 
{
	@FindBy(xpath = "//button[@class='search-button']")
	WebElement searchBtn;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public ProductListPage selectFilters(String make, String model) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.IMPLICITLY_WAIT));
		WebElement yearDd = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'YEAR')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'YEAR')]")));
		yearDd.click();
		List<WebElement> allOptions = driver.findElements(By.xpath("//ul[@id='categories_listbox']/li"));
		for (int i = 0; i <= allOptions.size()-1; i++) 
		{
			if(allOptions.get(i).getText().contains("2021")){
				allOptions.get(i).click();
				 }
		}
		
		Thread.sleep(2000);
		WebElement makeDd = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'MAKE')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'MAKE')]")));
		makeDd.click();
		List<WebElement> makeOptions = driver.findElements(By.xpath("//ul[@id='manufacturers_listbox']/li"));
		for (int j = 0; j <= makeOptions.size()-1; j++) 
		{
			if(makeOptions.get(j).getText().contains(make)) {
				makeOptions.get(j).click();
			}
		}

		Thread.sleep(3000);
		WebElement modelDd = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'MODEL')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'MODEL')]")));
		modelDd.click();
		List<WebElement> modelOptions = driver.findElements(By.xpath("//ul[@id='specification_1_listbox']/li"));
		for (int k = 0; k <= modelOptions.size()-1; k++) 
		{
			if(modelOptions.get(k).getText().contains(model)) {
				modelOptions.get(k).click();
			}
		}
		Thread.sleep(3000);
		
		searchBtn.click();
		
		return new ProductListPage();
	}
	
}