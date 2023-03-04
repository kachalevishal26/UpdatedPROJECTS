package com.bw.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bw.base.TestBase;
import com.bw.pages.HomePage;
import com.bw.pages.InitialPage;
import com.bw.pages.RegisterPage;
import com.bw.util.TestUtil;

public class HomePageTest extends TestBase
{
	InitialPage initialPage;
	RegisterPage registerPage;
	HomePage homePage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		initialPage = new InitialPage();
		homePage = new HomePage();
	}
	
	@DataProvider
	public Object[][] getTestData()
	{
		Object data[][] = TestUtil.getData("Filters");
		return data;
	}
	
	@Test(dataProvider = "getTestData")
	public void filterTest(String make, String model) throws InterruptedException
	{
		homePage.selectFilters(make, model);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
