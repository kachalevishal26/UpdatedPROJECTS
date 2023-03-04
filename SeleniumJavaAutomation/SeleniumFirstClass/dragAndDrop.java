import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dragAndDrop {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\chromedriver.exe\\");
		WebDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.brakeworld.com/2020#/specFilters=1!#-!890!-#!2!#-!1997&manFilters=43&pageSize=50&orderBy=11&pageNumber=1");
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body.notAndroid23:nth-child(2) div.master-wrapper-page:nth-child(10) div.master-wrapper-content div.master-column-wrapper:nth-child(13) div.side-2 div.nopAjaxFilters7Spikes:nth-child(1) div.filtersPanel div.block.filter-block.priceRangeFilterPanel7Spikes:nth-child(2) div.filtersGroupPanel.disabled div.price-range-slider.ui-slider.ui-corner-all.ui-slider-horizontal.ui-widget.ui-widget-content > span.ui-slider-handle.ui-corner-all.ui-state-default:nth-child(3)")));
		WebElement up = driver.findElement(By.cssSelector("body.notAndroid23:nth-child(2) div.master-wrapper-page:nth-child(10) div.master-wrapper-content div.master-column-wrapper:nth-child(13) div.side-2 div.nopAjaxFilters7Spikes:nth-child(1) div.filtersPanel div.block.filter-block.priceRangeFilterPanel7Spikes:nth-child(2) div.filtersGroupPanel.disabled div.price-range-slider.ui-slider.ui-corner-all.ui-slider-horizontal.ui-widget.ui-widget-content > span.ui-slider-handle.ui-corner-all.ui-state-default:nth-child(3)"));
		int ywidth = up.getSize().width;
		
		Actions s = new Actions(driver);
		s.dragAndDropBy(up, -ywidth*6,0);
		s.build().perform();
	}

}
