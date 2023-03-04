

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

public class FluentWait {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\chromedriver.exe\\");
		WebDriver driver= new ChromeDriver();
		Wait<WebDriver> wait = new org.openqa.selenium.support.ui.FluentWait<WebDriver>(driver)
		.withTimeout(Duration.ofSeconds(30))
		.pollingEvery(Duration.ofSeconds(5))
		.ignoring(NoSuchElementException.class);
		
		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver t) {
				// TODO Auto-generated method stub
				return null;
			}
			
		});

	}

}
