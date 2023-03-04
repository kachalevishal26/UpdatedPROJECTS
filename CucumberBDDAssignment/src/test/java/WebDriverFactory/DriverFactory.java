package WebDriverFactory;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import StepDefinition.HomeStepDef;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private static final Logger logger = LogManager.getLogger(DriverFactory.class);

	static WebDriver driver;

	public static WebDriver init_Driver(String browser) {

		switch (browser) {
		case "chrome":

//			System.setProperty("webdriver.chrome.driver",
//					"C:\\Users\\Pooja\\Documents\\Automation\\Driver\\chromedriver.exe");

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//Driver//chromedriver.exe");
			driver = new ChromeDriver();
			logger.info("Chrome Browser invoked");
			break;

		case "firefox":
//			System.setProperty("webdriver.gecko.driver",
//					"C:\\Users\\Pooja\\Documents\\Automation\\Driver\\geckodriver.exe");

//			System.setProperty("webdriver.gecko.driver",
//					System.getProperty("user.dir") + "//Driver//geckodriver.exe");
			WebDriverManager.chromedriver().setup();

			driver = new FirefoxDriver();
			logger.info("Firefox Browser invoked");
			break;

		case "headless":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			driver = new ChromeDriver(options);
			logger.info("Headless Chrome Browser invoked");
			break;

		default:
			logger.fatal("No such browser is implemented.Browser name sent: " + browser);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("Driver maximized and implicit time out set to 20 seconds");

		return driver;
	}

	public static void launchUrl() {

		driver.get("http://automationpractice.com/");

	}

	public static WebDriver getDriver() {
		return driver;
	}

}