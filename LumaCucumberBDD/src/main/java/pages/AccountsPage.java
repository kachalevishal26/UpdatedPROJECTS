package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	private WebDriver driver;

	private By myAcc = By.xpath("//ul[@class='nav items']/li");

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPageTitle() {
		
		return driver.getTitle();
	}

	public List<String> accountSection() {
		List<WebElement> listItems = driver.findElements(By.xpath("//ul[@class='nav items']/li"));
		boolean b;
		String s;
		List<String> accList = new ArrayList<>();

		for (int i = 0; i < listItems.size(); i++) {
			b = listItems.get(i).isDisplayed();

			if (b == true) {
				s = listItems.get(i).getText();
				if (s != " ") {
					accList.add(s);
				}
			}
		}
		return accList;
	}

	public int accountSectionCount() {
		List<WebElement> listItems = driver.findElements(By.xpath("//ul[@class='nav items']/li"));
		boolean b;
		String s;
		int count = 0;

		for (int i = 0; i < listItems.size(); i++) {
			b = listItems.get(i).isDisplayed();

			if (b == true) {
				s = listItems.get(i).getText();
				if (s != " ") {
					count++;
				}
			}
		}
		return count;
	}
}