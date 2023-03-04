import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Liminal {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Asus\\chromedriver.exe\\");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev2.lmnl.dev/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//Login
		driver.findElement(By.linkText("Login with Google")).click(); 
	
		String currentwindow= driver.getWindowHandle();	
		
		java.util.Set<String> tabs= driver.getWindowHandles();
		System.out.println(tabs);
		Iterator<String> i= tabs.iterator();
		while(i.hasNext()) {
			String childwindow = i.next();
			if(!childwindow.equalsIgnoreCase(currentwindow)) 
			{
				driver.switchTo().window(childwindow);
				driver.findElement(By.tagName("button")).click();
				
				driver.findElement(By.id("identifierId")).sendKeys("vishal@sevenbits.in");
				driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
				driver.findElement(By.name("password")).sendKeys("AzcO017GGs0C");
				WebElement enter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Next')]")));
				enter.click();
				Thread.sleep(30,000);
				driver.switchTo().window(currentwindow);
				System.out.println("The child window is "+childwindow);
			}
		}
		
		//HomePage
		js.executeScript("scroll(0,600)");
		js.executeScript("scroll(0,-100)");
		
		//Send
		driver.findElement(By.className("btn btn-info-primary-blue-color btn-md")).click();
		driver.findElement(By.linkText(" mansi-wallet")).click();
		driver.findElement(By.id("dropdownManual")).click();
		driver.findElement(By.linkText("rsdp2BT5rG9U7tx4q7tzQTU4rs9A1NuG3J")).click();
		driver.findElement(By.tagName("input")).sendKeys("5");
		WebElement sub = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body.modal-open:nth-child(2) ngb-modal-window.d-block.modal.modal-custom-background.fade.show:nth-child(16) div.modal-dialog.modal-dialog-centered div.modal-content div.ng-star-inserted div.modal-footer.border-0.ng-star-inserted > button.btn.btn-info-primary-blue-color.btn-md")));
		sub.click();
	}

}
