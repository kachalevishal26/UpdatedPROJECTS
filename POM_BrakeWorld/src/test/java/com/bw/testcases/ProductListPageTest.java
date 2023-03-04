package com.bw.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bw.base.TestBase;
import com.bw.pages.HomePage;
import com.bw.pages.ProductListPage;
import com.bw.util.DataSupplier;
import com.bw.util.TestUtil;

public class ProductListPageTest extends TestBase {
	
	HomePage homePage;
	ProductListPage productListPage;

	public ProductListPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		homePage = new HomePage();
		productListPage = new ProductListPage();
	}

	@DataProvider
	public Object[][] getTestData() {
		Object data[][] = DataSupplier.getData("Filters");
		return data;
	}

	@Test(dataProvider = "getTestData", priority = 1)
	public void productListTest(String make, String model) throws InterruptedException, IOException {
		homePage.selectFilters(make, model);
		productListPage.sortByPage();
		productListPage.clickProduct();
	}

//	@AfterMethod
//	public void tearDown()
//	{
//		driver.quit();
//	}
}
