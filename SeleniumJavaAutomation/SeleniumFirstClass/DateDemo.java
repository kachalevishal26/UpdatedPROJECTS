import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DateDemo {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Asus\\chromedriver.exe\\");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scroll(0,200)");
		driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[2]/*[1]")).click();
		js.executeScript("scroll(0,300)");
		driver.findElement(By.xpath("//span[contains(text(),'Date Picker')]")).click();
		js.executeScript("document.getElementById('datePickerMonthYearInput').value='06/26/1997'");
		
		
	}

}
