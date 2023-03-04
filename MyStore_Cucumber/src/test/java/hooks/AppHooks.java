package hooks;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks {
	private static final Logger logger = LogManager.getLogger();

	private ConfigReader configReader;
	private DriverFactory driverFactory;
	private WebDriver driver;
	Properties prop;

	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		logger.info("Fetching the property");
	}

	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
		logger.info("Launching the browser");
	}

	@After(order = 0)
	public void tearDown() {
		driver.quit();
		logger.info("Close browser");
	}

	@After(order = 1)
	public void failedTest(Scenario s) {
		logger.info("Failed test screenshot");
		if (s.isFailed()) {
			String screenshotName = s.getName().replace(" ", "_");
			byte[] soucePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			s.attach(soucePath, "image/png", screenshotName);
		} else {
			System.out.println("No failures");
		}
	}
}
