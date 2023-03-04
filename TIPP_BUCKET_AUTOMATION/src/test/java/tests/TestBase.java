package tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase {
	static AndroidDriver driver;
	
	public static AndroidDriver capabilities() throws MalformedURLException {
		File fileDir = new File("src/test/resources/apps");
		File file = new File(fileDir, "TIPP_BUCKET.apk");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android_Device");
		cap.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		return driver;
	}
}
