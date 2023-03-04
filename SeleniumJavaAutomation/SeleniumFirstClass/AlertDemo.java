import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\chromedriver.exe\\");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//JS Alert
		driver.findElement(By.cssSelector("div.row:nth-child(2) div.large-12.columns:nth-child(2) div.example:nth-child(2) ul:nth-child(3) li:nth-child(1) > button:nth-child(1)")).click();
		Alert alert= wait.until(ExpectedConditions.alertIsPresent());
		String text= alert.getText();
		System.out.println(text);
		alert.accept();
		
		
		//Confirmation Alert
		driver.findElement(By.cssSelector("div.row:nth-child(2) div.large-12.columns:nth-child(2) div.example:nth-child(2) ul:nth-child(3) li:nth-child(2) > button:nth-child(1)")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert2= driver.switchTo().alert();
		String text2= alert.getText();
		System.out.println(text2);
		alert.accept();
		
		//Prompt Alert
		driver.findElement(By.cssSelector("div.row:nth-child(2) div.large-12.columns:nth-child(2) div.example:nth-child(2) ul:nth-child(3) li:nth-child(3) > button:nth-child(1)")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert3 = driver.switchTo().alert();
		alert.sendKeys("Kachale Vishal");
		alert.accept();
		
		System.out.println(driver.findElement(By.id("result")).getText());

	}

}
