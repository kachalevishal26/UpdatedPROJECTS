package com.factory;

import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.utils.TestUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	private static final Logger logger = LogManager.getLogger();

	public WebDriver driver;
	public Properties prop;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public static WebDriver init_driver(String browser) {
		System.out.println("Browser name is " + browser);
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
			logger.info("Launching chrome..");
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
			logger.info("Launching firefox..");
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
			logger.info("Launching edge..");
		} else {
			System.out.println("Invalid browser name " + browser);
			logger.fatal("Invalid browser " + browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtils.IMPLICITLY_WAIT));

		return getDriver();
	}

	public static void launchURL() {
		getDriver().get("http://automationpractice.com/index.php");
	}

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}