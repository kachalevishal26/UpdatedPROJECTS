package tests;


import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class LoginPage extends TestBase {
	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		AndroidDriver driver = capabilities();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		 Thread.sleep(15000);
		 //Role
		 driver.findElement(By.xpath("(//android.widget.ImageView[@index='1']/android.view.View[@index='0'])[1]")).click();
		 driver.findElement(By.className("android.widget.Button")).click();
		 
		 //Login
		 driver.findElement(By.xpath("(//android.widget.Button)[2]")).click();
		 
		 WebElement emailAdd = driver.findElement(By.xpath("//android.widget.EditText[@text='Email Address']"));
		 emailAdd.click();
		 Thread.sleep(2000);
		 emailAdd.sendKeys("vktest26@gmail.com");
		 Thread.sleep(1000);
		 driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 
		 WebElement password = driver.findElement(By.xpath("//android.widget.EditText[@text='Password']"));
		 password.click();
		 Thread.sleep(2000);
		 password.sendKeys("123456");
		 Thread.sleep(1000);
		 driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("(//android.widget.Button)[3]")).click();
		 driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
		 Thread.sleep(2000);	
		 }
}