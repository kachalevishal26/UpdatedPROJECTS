import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class drag {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\chromedriver.exe\\");
		WebDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.get("https://demoqa.com");
		driver.findElement(By.xpath("//h5[contains(text(),'Alerts, Frame & Windows')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Alerts')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("alertButton")).click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		
		driver.findElement(By.id("timerAlertButton")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert2 = driver.switchTo().alert();
		alert.accept();
		
		driver.findElement(By.id("confirmButton")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert3 = driver.switchTo().alert();
		alert.accept();
		
		
		driver.findElement(By.id("promtButton")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert4 = driver.switchTo().alert();
		alert.sendKeys("Kachale Vishal");
		alert.accept();
		
		
		
	}

}
