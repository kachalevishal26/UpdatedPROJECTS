
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\chromedriver.exe\\");
		WebDriver driver= new ChromeDriver();
		driver.get("https://cafifthavenuecollection.7bits.in");
		driver.manage().window().maximize();
		
		Actions action = new Actions(driver);
		
		WebElement hover = driver.findElement(By.cssSelector("div.master-wrapper-page:nth-child(6) div.main_header.sticky-header.color_four div.container-fluid div.header_container div.row.align-items-center div.col-lg-3 div.header_account_area.align-items-center div.header_account-list.top_links.user-info-header.user-info-header-mr:nth-child(2) a:nth-child(1) > i.icon.icon-User"));
		
		action.moveToElement(hover).build().perform();
		
		driver.findElement(By.cssSelector("div.master-wrapper-page:nth-child(6) div.main_header.sticky-header.color_four div.container-fluid div.header_container div.row.align-items-center div.col-lg-3 div.header_account_area.align-items-center div.header_account-list.top_links.user-info-header.user-info-header-mr:nth-child(2) div.dropdown_links:nth-child(2) div.dropdown_links_list ul:nth-child(1) li:nth-child(1) > a:nth-child(1)")).click();
		
		System.out.println(driver.getPageSource());


	}

}
