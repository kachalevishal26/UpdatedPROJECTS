package Hooks;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import POM.HomePageObject;
import POM.LogoPageObject;
import Utils.ConfigReader;
import WebDriverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks {
	
	private static final Logger logger = LogManager.getLogger(AppHooks.class);

	ConfigReader configReader;
	DriverFactory driverFactory;
	Properties prop = new Properties();
	WebDriver driver;

	@Before(order = 0)
	public void read_ConfigReader() throws IOException {
		configReader = new ConfigReader();
		prop = configReader.read_prop();
		logger.info("Config.properties file read");
	}

	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		logger.info("Get browser name from properties file");
		DriverFactory.init_Driver(browserName);
		logger.info("Initialize driver");
		driver = DriverFactory.getDriver();
		
	}

	@After(order = 1)
	public void failedScenario(Scenario sc) {
		if (sc.isFailed()) {
			String name = sc.getName().replaceAll(" ", "_");

			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] bytes = ts.getScreenshotAs(OutputType.BYTES);

			sc.attach(bytes, "image/png", name);

		}
		else
		{
			logger.info("Scenario not failed");
		}

	}

	@After(order = 0)
	public void tearDown() {
		driver.quit();
		logger.info("quit browser");
	}

}
