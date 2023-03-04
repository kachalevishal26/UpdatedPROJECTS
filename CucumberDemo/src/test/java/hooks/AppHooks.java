package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class AppHooks {
	private ConfigReader configReader;
	private DriverFactory driverFactory;
	private WebDriver driver;
	Properties prop;

	@Before(order = 0)
	public void getProp() {
		configReader = new ConfigReader();
		prop = configReader.initProp();
	}

	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.initDriver(browserName);
	}

	@After(order = 0)
	public void tearDown() {
		driver.quit();
	}

	@After(order = 1)
	public void failedCase(Scenario s) {
		if (s.isFailed()) {
			String screenshotName = s.getName().replace(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			s.attach(sourcePath, "image/png", screenshotName);
		}
	}
}