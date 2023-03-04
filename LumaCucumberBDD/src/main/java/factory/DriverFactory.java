package factory;

import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	private static final Logger logger = LogManager.getLogger();
	public static WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public WebDriver initDriver(String browserName) {
		System.out.println("Browser name is " + browserName);
		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			tlDriver.set(driver = new ChromeDriver());

			logger.info("chrome browser invoked");
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(driver = new FirefoxDriver());

			logger.info("firefox browser invoked");
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			tlDriver.set(driver = new EdgeDriver());

			logger.info("edge browser invoked");
			break;

		case "headless":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			tlDriver.set(driver = new ChromeDriver(options));

			logger.info("headless chrome browser invoked");
			break;

		default:
			logger.fatal("No such browser! Please verify the browser name " + browserName);
			break;
		}

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return getDriver();
	}

	public static void launchUrl() {
		getDriver().get("https://magento.softwaretestingboard.com/customer/account/login");
		logger.info("redirect to url ");
	}

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}