package POM;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchPageObject {
	private static final Logger logger = LogManager.getLogger(SearchPageObject.class);

	WebDriver driver;

	
	
	private By searchBox = By.id("search_query_top");
	private By searchResult = By.xpath("//div[@class='ac_results']//ul//li");

	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}
	WebDriverWait wait;
   
	public void searchItems(String items) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		wait=new WebDriverWait(driver,20);
		logger.info("Search : "+ items);
		driver.findElement(searchBox).sendKeys(items);

	}

	public String searchResultValidation() {

		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		String txt = driver.findElement(searchResult).getText();
		
		logger.info(" When user search it will show entered text  : ");
		return txt;

	}

}
