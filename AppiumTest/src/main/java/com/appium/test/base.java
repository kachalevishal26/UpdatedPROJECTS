package com.appium.test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class base 
{
//	public static void main(String[] args) throws Exception
//	Change it to method so that we can use it in other programs as the code we need to write is same
	public static AndroidDriver<AndroidElement> capabilities(String device) throws MalformedURLException
	{
		File appDir = new File("src/main/java");
		File app = new File(appDir, "ApiDemos-debug.apk");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		if(device.equals("emulator"))
		{
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "VishalEmulator");
		}
		else if(device.equals("real"))
		{
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		}
		
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		//Also we need to return driver so that in which we extend this method will able to use all elements of this method.
		return driver;
	}
}
