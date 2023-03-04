import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\chromedriver.exe\\");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Datepicker.html");
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("document.getElementById('datepicker1').value='12-07-2007'");
		
		
		
		String targetDate = "30-Jan-2021";
		SimpleDateFormat targetDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		Date formattedTargetDate; 
		try {
			targetDateFormat.setLenient(false);
			formattedTargetDate = targetDateFormat.parse(targetDate);
			System.out.println(formattedTargetDate);
		} catch (ParseException e) {
				throw new Exception("Invalidate date, Please check the input date");
		} 
		 
		

	}

}
