import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\chromedriver.exe\\");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://demo.automationtesting.in/Datepicker.html");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('datepicker1').value='06/26/1997'");

	}

}
