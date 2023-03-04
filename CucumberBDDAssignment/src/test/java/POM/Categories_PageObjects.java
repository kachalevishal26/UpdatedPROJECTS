package POM;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Categories_PageObjects {

	WebDriver driver;

	private By category = By.xpath("//div[@id='block_top_menu']//ul//li");

	public Categories_PageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public int countCategory() {

		List<WebElement> e = driver.findElements(category);
		String s = "";
		boolean b;
		List<String> l=new ArrayList<String>();
		int iCnt=0;
		
		for (int i = 0; i < e.size(); i++) {
			b = e.get(i).isDisplayed();

			if (b == true) {
				s = e.get(i).getText();
				if (s != " ")
					l.add(s);
				iCnt++;
			}
		}
		return iCnt;
	}
	
	
	
	public List<String> DisplayCategory() {

		List<WebElement> e = driver.findElements(category);
		String s = "";
		List<String> l=new ArrayList();
		boolean b;
		for (int i = 0; i < e.size(); i++) {
			b = e.get(i).isDisplayed();

			if (b == true) {
				s = e.get(i).getText();
				if (s != " ")
					l.add(s);
			}
		}
		
		return l;

	}

}
