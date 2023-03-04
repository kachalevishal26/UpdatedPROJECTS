package com.bw.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


import com.bw.base.TestBase;

public class InitialPage extends TestBase 
{
	
	
	public RegisterPage scrollHomePage() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scroll(0,590)");
		Thread.sleep(2000);
		js.executeScript("scroll(0,1680)");
		Thread.sleep(2000);
		js.executeScript("scroll(0,10000)");
		Thread.sleep(2000);
		driver.findElement(By.id("goToTop")).click();
		Thread.sleep(2000);
		
		return new RegisterPage();
	}
}
