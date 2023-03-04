package POM;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TwitterPageObjectMoel {

	WebDriver driver;

	private By twitterLink = By.xpath("//li[@class='twitter']");
	private By accountName = By.xpath("//span[text()='Selenium Framework']");

	public TwitterPageObjectMoel(WebDriver driver) {
		this.driver = driver;
	}

	public void linkedToTwitter() {
		driver.findElement(twitterLink).click();
	}

	public String openNewWindow() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String txt = "";
		Set<String> s = driver.getWindowHandles();

		for (String windowHandles : s) {
			txt = driver.switchTo().window(windowHandles).getCurrentUrl();
		}
		return txt;

	}

	public String AccountName() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actName = driver.findElement(accountName).getText();

		return actName;
	}

}
