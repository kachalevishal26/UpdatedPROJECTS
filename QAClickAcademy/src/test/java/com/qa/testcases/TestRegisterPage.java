package com.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.RegisterPage;
import com.qa.utils.TestUtils;

public class TestRegisterPage extends TestBase 
{
	RegisterPage regPage;
	
	public TestRegisterPage()
	{
		super();
	}
	
	@BeforeTest
	public void setUp()
	{
		initialization();
		regPage = new RegisterPage();
	}
	
	@DataProvider
	public Object[][] testData()
	{
		Object data[][] = TestUtils.getData("Register");
		
		return data;
	}
	
	@Test(dataProvider = "testData")
	public void regUser(String fName, String email, String pwd)
	{
		regPage.registerUser(fName, email, pwd);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
