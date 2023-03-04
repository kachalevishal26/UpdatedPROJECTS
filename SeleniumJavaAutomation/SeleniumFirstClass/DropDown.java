import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class DropDown {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\chromedriver.exe\\");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		//Single Selection DD
		WebElement dropdown =	driver.findElement(By.cssSelector("#select-demo"));
		Select countryName = new Select(dropdown);
		
		countryName.selectByValue("Monday");
		Thread.sleep(2000);
		
		countryName.selectByIndex(3);
		Thread.sleep(2000);
		
		countryName.selectByVisibleText("Saturday"); 
		
		//Multi Selection DD
		WebElement mdd = driver.findElement(By.id("multi-select"));
		Select option = new Select(mdd);
		
		option.selectByIndex(0);
		option.selectByValue("Florida");
		option.selectByVisibleText("Texas");

	}

}
