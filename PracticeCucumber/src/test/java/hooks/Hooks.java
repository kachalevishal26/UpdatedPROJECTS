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

public class Hooks {
	
	private static final Logger logger = LogManager.getLogger(Hooks.class);
	
	private ConfigReader configReader;
	private DriverFactory driverFactory;
	private WebDriver driver;
	Properties prop;
	
	@Before(order=0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		logger.info("Config.properties file read");
	}
	
	@Before(order=1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		logger.info("Get browser name from properties file");
		driverFactory = new DriverFactory();
		logger.info("Initialize driver");
		driver = driverFactory.init_driver(browserName);
	}
	
	@After(order=0)
	public void closeBrowser() {
		driver.quit();
		logger.info("quit browser");
	}
	
	@After(order=1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			String screenshotName = scenario.getName().replace(" ","_");
			byte [] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
		else
		{
			logger.info("Scenario not failed");
		}
	}
	
}
