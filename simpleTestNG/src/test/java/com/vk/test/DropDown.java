package com.vk.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.brakeworld.com/");
		
		//YEAR
		driver.findElement(By.xpath("//span[contains(text(),'YEAR')]")).click();
		List<WebElement> allOptions = driver.findElements(By.xpath("//ul[@id='categories_listbox']/li"));
		System.out.println(allOptions.size());
				
		for (int i = 0; i <= allOptions.size()-1; i++) 
		{
			if(allOptions.get(i).getText().contains("2021"))
			{
				allOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(5000);
		
//		//MAKE
		driver.findElement(By.xpath("//span[contains(text(),'MAKE')]")).click();
		List<WebElement> makeList = driver.findElements(By.xpath("//ul[@id='manufacturers_listbox']/li"));
		System.out.println(makeList.size());
		
		for (int j = 0; j <= makeList.size()-1; j++) 
		{
			if(makeList.get(j).getText().contains("polaris"))
			{
				makeList.get(j).click();
				break;
			}
		}
		Thread.sleep(5000);
		
//		//Model
		driver.findElement(By.xpath("//span[contains(text(),'MODEL')]")).click();
		List<WebElement> modelList = driver.findElements(By.xpath("//ul[@id='specification_1_listbox']/li"));
		System.out.println(modelList.size());
		
		for (int k = 0; k <= modelList.size()-1; k++) 
		{
			if(modelList.get(k).getText().contains("slingshot"))
			{
				modelList.get(k).click();
				break;
			}
		}
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@class='search-button']")).click();
	}

}
