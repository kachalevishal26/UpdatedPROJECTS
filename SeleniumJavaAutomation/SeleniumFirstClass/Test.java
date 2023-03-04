import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Asus\\chromedriver.exe\\");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
//		driver.findElement(By.xpath("//h5[contains(text(),'Widgets')]")).click();
		
		//Textbox
//		driver.findElement(By.xpath("//body/div[@id='fixedban']/div[1]/div[1]/a[1]/img[1]")).click();
//		driver.findElement(By.id("item-0")).click();
//		driver.findElement(By.id("userName")).sendKeys("vk26");
//		driver.findElement(By.id("userEmail")).sendKeys("vishal@sevenbits.in");
//		driver.findElement(By.id("currentAddress")).sendKeys("Vrajdham Society, Shree Riddhi Siddhi Apparment, H Blog, 1ST Floor, Flat No. 106 Dadra. DNH pin code - 396193.");
//		driver.findElement(By.id("permanentAddress")).sendKeys("Vrajdham Society, Shree Riddhi Siddhi Apparment, H Blog, 1ST Floor, Flat No. 106 Dadra. DNH pin code - 396193.");
//		driver.findElement(By.id("submit")).click();
		
		//Buttons
//		driver.findElement(By.id("item-4")).click();
//		WebElement dClick = driver.findElement(By.id("rightClickBtn"));
//		
//		action.contextClick(dClick).build().perform();
		
		//Links
//		driver.findElement(By.id("item-5")).click();
//		driver.findElement(By.id("simpleLink")).click();
//		String cWindow = driver.getWindowHandle();
//		
//		Set<String> tabs = driver.getWindowHandles();
//		Iterator<String> i = tabs.iterator();
//		System.out.println(tabs);
//		while(i.hasNext())
//		{
//			String chWindow = i.next();
//			if(!chWindow.equalsIgnoreCase(cWindow))
//			{
//				driver.switchTo().window(cWindow);
//			}
//		}
		
		//Windows
//		driver.findElement(By.xpath("//span[contains(text(),'Alerts')]')]")).click();
//		driver.findElement(By.id("tabButton")).click();
//		String cTab = driver.getWindowHandle();
//		
//		Set<String> tabs = driver.getWindowHandles();
//		Iterator<String> i = tabs.iterator();
//		while(i.hasNext())
//		{
//			String nTab = i.next();
//			if(!nTab.equalsIgnoreCase(cTab))
//			{
//				driver.switchTo().window(cTab);
//			}
//		}

		}

}
