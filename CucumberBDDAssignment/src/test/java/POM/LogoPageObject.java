package POM;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoPageObject {

	private static final Logger logger = LogManager.getLogger(LogoPageObject.class);

	WebDriver driver;

	private By logo=By.id("header_logo");
	private By logoWidthandHeight=By.xpath("//img[@class='logo img-responsive']");
	
	public LogoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean chkLogoVisibility() {
		boolean result=driver.findElement(logo).isDisplayed();
		logger.info("Checked logo is visible or not");
		return result;
	}
	
	public void  ChkLogoEidthHeight(String expectedWidth,String expectedHeight) {
		String actualWidth=driver.findElement(logoWidthandHeight).getAttribute("width");
		String actualHeight=driver.findElement(logoWidthandHeight).getAttribute("height");
	
		Assert.assertEquals(expectedHeight, actualHeight);
		Assert.assertEquals(expectedWidth, actualWidth);
		
//		if(actualWidth.equals(expectedWidth) && actualHeight.equals(expectedHeight))
//		{
//			
//		}
//		else
//		{
//			Assert.assertFalse(false);
//		}
//		
		
	}
}
