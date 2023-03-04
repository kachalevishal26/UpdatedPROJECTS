import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstScript {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\chromedriver.exe\\");
		System.out.println("Hello world");
		WebDriver driver= new ChromeDriver();
		driver.get("https://cafifthavenuecollection.7bits.in");
		driver.findElement(By.xpath("/html/body/div[6]/header/div/div/div/div/div[3]/div/div[2]/a/i")).click();
		driver.findElement(By.xpath("/html/body/div[6]/header/div/div/div/div/div[3]/div/div[2]/div/div/ul/li[2]/a")).click();
		driver.findElement(By.id("Username")).sendKeys("Vk1997");
		driver.findElement(By.id("Password")).sendKeys("Vishal@26");
		driver.findElement(By.xpath("//*[@id=\"pills-home\"]/form/div[3]/button")).click();
		driver.wait(200000);
		
	}		
}
	