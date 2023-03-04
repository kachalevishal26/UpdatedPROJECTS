import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class date {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\chromedriver.exe\\");
		WebDriver driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("datepicker")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.xpath("//body/div[@id='ui-datepicker-div']/table[1]")));
		String monYear = driver.findElement(By.xpath("//body/div[@id='ui-datepicker-div']/div[1]/div[1]")).getText();
		String month = monYear.split(" ")[0].trim();
		String year = monYear.split(" ")[1].trim();
		while (!(month.equals("June") && year.equals("2025"))) {
			driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();

			monYear = driver.findElement(By.xpath("//body/div[@id='ui-datepicker-div']/div[1]/div[1]")).getText();
			month = monYear.split(" ")[0].trim();
			year = monYear.split(" ")[1].trim();
		}
		driver.findElement(By.xpath("//a[contains(text(),'26')]")).click();
	}
}