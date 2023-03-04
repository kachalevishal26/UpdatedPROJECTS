import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.agent.builder.AgentBuilder.CircularityLock.Global;

public class ExplicitWait {

	public static void main(String[] args) {
		
		ExplicitWait();
	}

	private static void ExplicitWait() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\chromedriver.exe\\");
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Scrolltest"+Keys.ENTER);
		WebElement firstResult = new WebDriverWait(driver, 10).
		until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[contains(text(),'Software Testing & Automation: Scrolltest')]")));
		System.out.println(firstResult.getText());
	
		
	}

}
