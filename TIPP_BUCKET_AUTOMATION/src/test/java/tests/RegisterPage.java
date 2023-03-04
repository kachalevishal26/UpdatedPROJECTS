package tests;


import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;

public class RegisterPage extends TestBase {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		AndroidDriver driver = capabilities();
		TouchAction touch;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		 Thread.sleep(1000);
		 //Role
		 driver.findElement(By.xpath("(//android.widget.ImageView[@index='1']/android.view.View[@index='0'])[1]")).click();
		 Thread.sleep(1000);
//		 driver.findElement(By.className("android.widget.Button")).click();
		 driver.findElement(By.xpath("//android.widget.Button[@content-desc='Continue']")).click();
		 
		 //SignUp
		 driver.findElement(By.xpath("(//android.widget.Button)[4]")).click();
		 
		 //Scroll
		 
		 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().description(\"Sign Up\"));"));
		 driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().description(\"Sign Up\")")).click();

		 //Register - Invalid Data
		 WebElement fName = driver.findElement(By.xpath("//android.widget.EditText[@text='First Name']"));
		 fName.click();
		 fName.sendKeys("Wade");
		 Thread.sleep(1000);
		 driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 
		 WebElement lName = driver.findElement(By.xpath("//android.widget.EditText[@text='Last Name']"));
		 lName.click();
		 lName.sendKeys("Fleming");
		 Thread.sleep(1000);
		 driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 
		 WebElement signUpEmail = driver.findElement(By.xpath("(//android.widget.EditText)[3]"));
		 signUpEmail.click();
		 signUpEmail.sendKeys("wade.fleming@example.com");
		 Thread.sleep(1000);
		 driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 
		 WebElement countryCode = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='+1']"));
		 Thread.sleep(1000);
		 countryCode.click();
//		 WebElement searchCountry = driver.findElement(By.xpath("//android.widget.EditText[@text='Search country']"));
//		 Thread.sleep(1000);
//		 searchCountry.click();
//		 searchCountry.sendKeys("India");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).click();
		 driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 Thread.sleep(1000);
		 
		 WebElement phNo = driver.findElement(By.xpath("//android.widget.EditText[@text='Phone Number']"));
		 phNo.click();
		 phNo.sendKeys("345345345");
		 Thread.sleep(1000);
		 driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 
		 WebElement signupPassword = driver.findElement(By.xpath("//android.widget.EditText[@text='Password']"));
		 signupPassword.click();
		 signupPassword.sendKeys("123456");
		 Thread.sleep(1000);
		 driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 
		 driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().description(\"Sign Up\"));"));
		 driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().description(\"Sign Up\")")).click();
		 
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//android.view.View)[1]")).click();
		 Thread.sleep(1000);
		 WebElement OTP = driver.findElement(By.xpath("(//android.view.View)[0]"));
		 OTP.sendKeys("123456");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//android.view.View[@text='Confirm']")).click();
		 //Location_Allow
//		 driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
	}
}
