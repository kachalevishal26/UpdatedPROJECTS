package Interviews;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import java.util.List;import org.apache.commons.math3.ode.SecondaryEquations;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ashish 
{

	public static void main(String[] args) throws InterruptedException 
	{
//		String path = System.getProperty("user.dir");
//		System.setProperty("webdriver.chrome.driver", path + "C:\\Users\\Asus\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait d = new WebDriverWait(driver, Duration.ofSeconds(30));

		Scenario1(driver, d);
	}

	public static void Scenario1(WebDriver driver, WebDriverWait d) throws InterruptedException {

		driver.get("https://www.brakeworld.com/");
		driver.manage().window().maximize();

		d.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'home-page-filter-selectors-div')]/div[1]")));

		d.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'home-page-filter-selectors-div')]/div[1]")));
		WebElement e = driver.findElement(By.xpath("//div[contains(@class,'home-page-filter-selectors-div')]/div[1]"));
		e.click();

		driver.findElement(By.xpath("//ul[@id='categories_listbox']/li[2]")).click();

		d.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//ul[@id='manufacturers_listbox'] //li[@class='k-item']")));

		List<WebElement> l = driver.findElements(By.xpath("//ul[@id='manufacturers_listbox'] //li[@class='k-item']"));

		if (l.size() >= 1) {

			d.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'home-page-filter-selectors-div')]/div[2]")));

			driver.findElement(By.xpath("//div[contains(@class,'home-page-filter-selectors-div')]/div[2]")).click();

			driver.findElement(By.xpath("//ul[@id='manufacturers_listbox']/li[2]")).click();

			d.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='specification_1_listbox'] //li[@class='k-item']")));

			List<WebElement> i = driver.findElements(By.xpath("//ul[@id='manufacturers_listbox'] //li[@class='k-item']"));

			if (i.size() >= 1) {

				driver.findElement(By.xpath("//div[contains(@class,'home-page-filter-selectors-div')]/div[3]")).click();
				driver.findElement(By.xpath("//ul[@id='specification_1_listbox']/li[2]")).click();
				
				// click on search button
				d.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='search-button']")));
				driver.findElement(By.xpath("//button[@class='search-button']")).click();

				
				// adding first product to cart
				d.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='item-grid'] //div[@class='item-box'][1] //button[text()='ADD TO CART']")));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//div[@class='item-grid'] //div[@class='item-box'][1] //button[text()='ADD TO CART']")));

				d.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='item-grid'] //div[@class='item-box'][1] //button[text()='ADD TO CART']")));
				driver.findElement(By.xpath("//div[@class='item-grid'] //div[@class='item-box'][1] //button[text()='ADD TO CART']")).click();


			}

			else {
				System.out.println("No model present");
			}

		}

		else {
			System.out.println("No car maker present");
		}

	}

	}
