package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private WebDriver driver;
	private static final Logger logger = LogManager.getLogger();

	private By abLogo = By.xpath("//a[@class='logo']");
	private By menuOptions = By.xpath("//ul[@id='ui-id-2']/li");
	private By searchBar = By.id("search");
	private By searchSugg = By.id("search_autocomplete");
	private By cardIcon = By.xpath("//a[@class='action showcart']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean chkLogo() {
		boolean l = driver.findElement(abLogo).isDisplayed();
		logger.info("check logo is visible or not");

		return l;
	}

	// Scenario: verify the logo
//	public void chkLogoWidth() {
//		String actualWidth = driver.findElement(abLogo).getAttribute("width");
//		System.out.println(actualWidth);
//		logger.info("check the logo width");
//		return actualWidth;
//	}

//	public void chkLogoHeight() {
//		String actualHeight = driver.findElement(abLogo).getAttribute("height");
//		System.out.println(actualHeight);
//		logger.info("check the logo height");
//		return actualHeight;
//	}

//	Scenario: verify the menubar
	public boolean menuVisible() {
		boolean menu = driver.findElement(menuOptions).isDisplayed();

		logger.info("menu bar is displayed");
		return menu;
	}

	public List<String> chkMenubar() {
		List<WebElement> list = driver.findElements(By.xpath("//ul[@id='ui-id-2']/li"));
		boolean b;
		String s;
		List<String> menuList = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			b = list.get(i).isDisplayed();

			if (b == true) {
				s = list.get(i).getText();
				if (s != "") {
					menuList.add(s);
				}
			}
		}
		logger.info("menubar text check");
		return menuList;
	}

	public int chkMenubarCount() {
		List<WebElement> list = driver.findElements(By.xpath("//ul[@id='ui-id-2']/li"));
		boolean b;
		String s;
		int counter = 0;

		for (int i = 0; i < list.size(); i++) {
			b = list.get(i).isDisplayed();

			if (b == true) {
				s = list.get(i).getText();
				if (s != "") {
					counter++;
				}
			}
		}
		logger.info("menubar text count check");
		return counter;
	}

	public boolean chkSearch() {
		boolean sBar = driver.findElement(searchBar).isDisplayed();

		logger.info("search bar visiblity check");
		return sBar;
	}

	public boolean chkSearchSuggestions() throws InterruptedException {
		driver.findElement(searchBar).sendKeys("watch");
		driver.findElement(searchBar).sendKeys(" ");
//		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("search_autocomplete")));
		Thread.sleep(3000);
		boolean elm = driver.findElement(searchSugg).isDisplayed();

		logger.info("checking the suggestions visiblity");
		return elm;
	}

	public boolean cartIcon() {
		boolean cart = driver.findElement(cardIcon).isDisplayed();

		logger.info("checking the cart icons visibility");
		return cart;
	}
}