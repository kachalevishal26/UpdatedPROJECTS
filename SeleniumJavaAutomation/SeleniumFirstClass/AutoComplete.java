import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AutoComplete {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/autoComplete.html");
		Actions action = new Actions(driver);
		
		WebElement textField = driver.findElement(By.id("tags"));
		textField.sendKeys("w");
		Thread.sleep(2000);
		action.sendKeys(textField, Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

	}

}
