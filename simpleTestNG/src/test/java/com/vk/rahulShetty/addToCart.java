package com.vk.rahulShetty;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class addToCart {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		int j=0;
		String[] itemsNeeded = {"Brocolli","Cucumber"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		// Check whether name you extract is present in array or not.
		// Convert array into array list for easy search
        
        
        
		for (int i = 0; i < products.size(); i++) 
		{
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			List itemsNeededList = Arrays.asList(itemsNeeded);
			
			if(itemsNeededList.contains(formattedName))
			{
				j++;
				//Click on Add to Cart
				driver.findElements(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[25]/div[3]/button[1]")).get(i).click();
				
				if(j==itemsNeeded.length)
				{
					break;
				}
				
			}
			
		}
	}

}
