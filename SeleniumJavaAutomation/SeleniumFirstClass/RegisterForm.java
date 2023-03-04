import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterForm {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\chromedriver.exe\\");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		driver.get("https://demoqa.com/automation-practice-form");
		driver.findElement(By.cssSelector("div:nth-child(1) div:nth-child(1) div:nth-child(4) a:nth-child(1) > img:nth-child(1)")).click();
		js.executeScript("scroll(0,350)");
		driver.findElement(By.id("submit")).click();
		js.executeScript("scroll(0,-350)");
		driver.findElement(By.id("firstName")).sendKeys("Vishal");
		driver.findElement(By.id("lastName")).sendKeys("Kachale");
		driver.findElement(By.id("userEmail")).sendKeys("vishal@sevenbits.in");
		driver.findElement(By.cssSelector("div.body-height:nth-child(2) div.container.playgound-body div.row div.col-12.mt-4.col-md-6:nth-child(2) div.practice-form-wrapper form.was-validated:nth-child(2) div.mt-2.row:nth-child(3) div.col-md-9.col-sm-12 div.custom-control.custom-radio.custom-control-inline:nth-child(1) > label.custom-control-label")).click();
		driver.findElement(By.id("userNumber")).sendKeys("7600768118");
		js.executeScript("document.getElementById('dateOfBirthInput').value='26-06-1997'");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.findElement(By.cssSelector("div.body-height:nth-child(2) div.container.playgound-body div.row div.col-12.mt-4.col-md-6:nth-child(2) div.practice-form-wrapper div.mt-2.row:nth-child(6) div.col-md-9.col-sm-12 div.css-2b097c-container div.subjects-auto-complete__control.css-yk16xz-control > div.subjects-auto-complete__value-container.subjects-auto-complete__value-container--is-multi.css-1hwfws3")).sendKeys("English");
		driver.findElement(By.cssSelector("div.body-height:nth-child(2) div.container.playgound-body div.row div.col-12.mt-4.col-md-6:nth-child(2) div.practice-form-wrapper form.was-validated:nth-child(2) div.mt-2.row:nth-child(7) div.col-md-9.col-sm-12 div.custom-control.custom-checkbox.custom-control-inline:nth-child(1) > label.custom-control-label")).click();
		driver.findElement(By.cssSelector("div.body-height:nth-child(2) div.container.playgound-body div.row div.col-12.mt-4.col-md-6:nth-child(2) div.practice-form-wrapper form.was-validated:nth-child(2) div.mt-2.row:nth-child(7) div.col-md-9.col-sm-12 div.custom-control.custom-checkbox.custom-control-inline:nth-child(2) > label.custom-control-label")).click();
		js.executeScript("scroll(0,500)");
		driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\Vishal\\Downloads\\sampleFile.jpeg");
		driver.findElement(By.id("currentAddress")).sendKeys("R.B.L Dungra Colony Vapi");
		/* List<WebElement> list = driver.findElements(By.xpath("//div[contains(text(),'Select State')]"));
		for(WebElement ele : list)
		{
			System.out.println("Values" + ele.getAttribute("innerHTML"));
			
			if(ele.getAttribute("innerHTML").contains("NCR"))
			{
				ele.click();
				break;
			}
		} */
		driver.findElement(By.id("submit")).click();

	}

}
