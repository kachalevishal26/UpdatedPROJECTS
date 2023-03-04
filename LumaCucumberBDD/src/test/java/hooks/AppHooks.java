package hooks;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class AppHooks {
	private static final Logger logger = LogManager.getLogger();
	private ConfigReader configReader;
	private DriverFactory driverFactory;
	private WebDriver driver;
	Properties prop;

	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.initProp();

		logger.info("initialize the property");
	}

	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.initDriver(browserName);

		logger.info("launched the browser");
	}

	@After(order = 0)
	public void tearDown() {
		logger.info("closing the browser");

		driver.quit();
	}

	@After(order = 1)
	public void failedCase(Scenario sc) {
		if (sc.isFailed()) {
			String screenShotName = sc.getName().replace(" ", "_");
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file, new File(".//screenshots/" + screenShotName + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
