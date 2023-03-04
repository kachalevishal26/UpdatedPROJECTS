import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracaticeForm {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Asus\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.findElement(By.xpath("//h5[contains(text(),'Forms')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Practice Form')]")).click();
		
		driver.findElement(By.id("firstName")).sendKeys("Vishal");
		driver.findElement(By.id("lastName")).sendKeys("Kachale");
		driver.findElement(By.id("userEmail")).sendKeys("vishal@sevenbits.in");
		driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();
		driver.findElement(By.id("userNumber")).sendKeys("7600768118");
		js.executeScript("document.getElementById('dateOfBirthInput').value='26/06/1997'");
		
		Thread.sleep(4000);
		//WebElement op = driver.findElement(By.id("subjectsContainer"));
		List<WebElement> op = wait.until(ExpectedConditions.visibilityOfAllElements((List<WebElement>) By.id("subjectsContainer")));
		((WebElement) op).sendKeys("a");
		List<WebElement> optionSelect = driver.findElements(By.tagName("li"));
		
		for(WebElement option : optionSelect)
		{
			System.out.println(option);
			
			if(option.getText().equals(optionSelect))
			{
				System.out.println(optionSelect);
				option.click();
				break;
			}
		}
		
		
		
		
	}

}
