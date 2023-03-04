import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {
		ImplicitWait();
		
	}

	private static void ImplicitWait() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\chromedriver.exe\\");
		WebDriver driver= new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("body:nth-child(2) div.row:nth-child(2) div.large-12.columns:nth-child(2) div.example > a:nth-child(2)")).click();
		String currentwindow= driver.getWindowHandle();
		
		java.util.Set<String> tabs= driver.getWindowHandles();
		System.out.println(tabs);
		
		Iterator<String> i= tabs.iterator();
		while(i.hasNext()) {
			String childwindow = i.next();
			if(!childwindow.equalsIgnoreCase(currentwindow)) 
			{
				driver.switchTo().window(childwindow);
				System.out.println("The child window is "+childwindow);
			}
		}
		driver.quit();
		
	}

}
