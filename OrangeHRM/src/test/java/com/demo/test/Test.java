package com.demo.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		driver.findElement(By.xpath("//h5[contains(text(),'Alerts, Frame & Windows')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Browser Windows')]")).click();
		driver.findElement(By.id("tabButton")).click();
		
		String currentWindow = driver.getWindowHandle();
		
		Set<String> tabs = driver.getWindowHandles();
		Iterator<String> i = tabs.iterator();
		while (i.hasNext()) {
			String childWindow = i.next();
			if(!childWindow.equalsIgnoreCase(currentWindow)); {
				driver.switchTo().window(childWindow);
				System.out.println(childWindow);
			}
			driver.switchTo().window(currentWindow);
		}
	}
}
