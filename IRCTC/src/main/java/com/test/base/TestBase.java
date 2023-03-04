package com.test.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.util.TimeUtils;

import com.test.utils.TestUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	private static final Logger logger = LogManager.getLogger();
	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(
					"C:\\Users\\Asus\\eclipse-workspace\\IRCTC\\src\\main\\java\\com\\test\\config\\config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void initialization(String browserName) {
		System.out.println("Browser name is " + browserName);

		ChromeOptions options = new ChromeOptions();
		HashMap<String, Integer> contentSettings = new HashMap<String, Integer>();
		HashMap<String, Object> profile = new HashMap<String, Object>();
		HashMap<String, Object> prefs = new HashMap<String, Object>();

		contentSettings.put("notifications", 1);
		profile.put("managed_default_content_settings", contentSettings);
		prefs.put("profile", profile);

		options.setExperimentalOption("prefs", prefs);

		switch (browserName) {
		case "chrome":
			logger.info("selecting browser as chrome");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			break;

		case "firefox":
			logger.info("selecting browser as firefox");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "edge":
			logger.info("selecting browser as edge");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			logger.fatal("Invalid browser " + browserName);
			break;
		}
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtils.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtils.IMPLICIT_WAIT));
	}
}