package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
	private WebDriver driver;

	private By section = By.xpath("//div[@class='list-group']/a");

	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}

	public int secCount() {
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='list-group']/a"));
		boolean b;
		String s = "";
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			b = list.get(i).isDisplayed();

			if (b == true) {
				s = list.get(i).getText();
				if (s != " ") {
					count++;
				}
			}
		}
		return count;
	}

	public List<String> verifySection() {
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='list-group']/a"));
		boolean b;
		String s;
		List<String> arr = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			b = list.get(i).isDisplayed();

			if (b == true) {
				s = list.get(i).getText();
				if (s != " ") {
					arr.add(s);
				}
			}
		}
		return arr;
	}
}