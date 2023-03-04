package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class HomePage extends TestBase {
	Actions action = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void product() throws InterruptedException {
		js.executeScript("scroll(0,1680)");
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='product-item-info']"));
		System.out.println("There are " + list.size() + "products");
		js.executeScript("scroll(0,-1680)");
	}

	public void menu() {
		List<WebElement> list = driver
				.findElements(By.xpath("//ul[@class='ui-menu ui-widget ui-widget-content ui-corner-all']/li"));
		for (int i = 0; i < list.size(); i++) {
			String txt = list.get(i).getText();

			if (txt.equals("Women")) {
				WebElement prod = list.get(i);
				action.moveToElement(prod).build().perform();
			}
		}

		List<WebElement> subList = driver.findElements(
				By.xpath("//ul[@class='level0 submenu ui-menu ui-widget ui-widget-content ui-corner-all']/li"));
		for (int i = 0; i < subList.size(); i++) {
			String txt = subList.get(i).getText();
			if (txt.equals("Bottoms")) {
				subList.get(i).click();
			}
		}
	}

}