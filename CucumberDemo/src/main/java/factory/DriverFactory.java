package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	public WebDriver initDriver(String browser) {
		System.out.println("Browser name is "+browser);
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		} else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		} else {
			System.err.println("Invalid browser name" +browser);
		}
//		getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
//		getDriver().manage().window().maximize();
		
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}
