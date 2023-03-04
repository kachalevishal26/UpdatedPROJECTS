import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScrollIntoView {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\chromedriver.exe\\");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/");
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='category-cards']/div")));
		List<WebElement> list = driver.findElements(By.xpath("//*[@class='category-cards']/div"));

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().contains("Widgets")) {
				list.get(i).click();
				break;
			}
		}

		driver.findElement(By.xpath("//span[contains(text(),'Date Picker')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("dateAndTimePickerInput")).click();
		String monthYear = driver.findElement(By.xpath(
				"//*[@class='react-datepicker__current-month react-datepicker__current-month--hasYearDropdown react-datepicker__current-month--hasMonthDropdown']"))
				.getText();
		System.out.println(monthYear);
		String month = monthYear.split(" ")[0].trim();
		String year = monthYear.split(" ")[1].trim();
		while (!(month.equals("June") && year.equals("2023"))) {
			driver.findElement(By.xpath("//button[contains(text(),'Next Month')]")).click();
			monthYear = driver.findElement(By.xpath(
					"//*[@class='react-datepicker__current-month react-datepicker__current-month--hasYearDropdown react-datepicker__current-month--hasMonthDropdown']"))
					.getText();
			System.out.println(monthYear);
			month = monthYear.split(" ")[0].trim();
			year = monthYear.split(" ")[1].trim();
		}
		
		
		driver.findElement(By.xpath("//div[contains(text(),'26')]")).click();
		List<WebElement> ls = driver.findElements(By.xpath("//div/div/ul/li"));
		WebElement elmt = driver.findElement(By.xpath("//li[contains(text(),'08:30')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", elmt);
		elmt.click();
	
	}
}
