import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class scrollIntoVie {
	public static void main(String[] args) throws InterruptedException {
//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://magento.softwaretestingboard.com/gear/watches.html?product_list_order=price");
		driver.manage().window().maximize();
		
		WebElement elm = driver.findElement(By.xpath("//a[contains(text(),'Dash Digital Watch')]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", elm);
		Thread.sleep(5000);
	}
}
