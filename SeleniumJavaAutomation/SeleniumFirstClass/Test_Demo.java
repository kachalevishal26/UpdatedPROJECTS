import java.awt.Desktop.Action;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.AcceptedW3CCapabilityKeys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test_Demo {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\chromedriver.exe\\");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Actions action = new Actions(driver);
		driver.get("https://demoqa.com/");
		js.executeScript("scroll(0,300)");
		driver.findElement(By.cssSelector("div.body-height:nth-child(2) div.home-content div.home-body div.category-cards div.card.mt-4.top-card:nth-child(1) div:nth-child(1) div.avatar.mx-auto.white > svg:nth-child(1)")).click();
	
		//Ad
		driver.findElement(By.cssSelector("div:nth-child(1) div:nth-child(1) div:nth-child(4) a:nth-child(1) > img:nth-child(1)")).click();
		
		//TextBox
		driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]")).click();
		Thread.sleep(2000);
		js.executeScript("scroll(0,200)");
		driver.findElement(By.id("userName")).sendKeys("Vishal Anand Kachale");
		driver.findElement(By.id("userEmail")).sendKeys("vishal@sevenbits.in");
		driver.findElement(By.id("currentAddress")).sendKeys("R.B.L Dungra Colony Vapi");
		driver.findElement(By.id("permanentAddress")).sendKeys("Post: Kachalwadi, Taluka: Junnar, Dist: Pune");
		driver.findElement(By.id("submit")).click();
		js.executeScript("scroll(0,250)");
		Thread.sleep(2000);
		
		//CheckBox
		driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]")).click();
		driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/ol[1]/li[1]/span[1]/label[1]/span[1]/*[1]")).click();
		Thread.sleep(2000);
		
		//RadioButton
		driver.findElement(By.id("item-2")).click();
		driver.findElement(By.cssSelector("div.body-height:nth-child(2) div.container.playgound-body div.row div.col-12.mt-4.col-md-6:nth-child(2) div:nth-child(1) div.custom-control.custom-radio.custom-control-inline:nth-child(3) > label.custom-control-label")).click();
		
		js.executeScript("scroll(0,100)");
		Thread.sleep(2000);
		
		//WebTables
		driver.findElement(By.id("item-3")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#addNewRecordButton")).click();
		driver.findElement(By.id("submit")).click();
		driver.findElement(By.id("firstName")).sendKeys("Vishal");
		driver.findElement(By.id("lastName")).sendKeys("Kachale");
		driver.findElement(By.id("userEmail")).sendKeys("vishal@sevenbits.in");
		driver.findElement(By.id("age")).sendKeys("24");
		driver.findElement(By.id("salary")).sendKeys("10000");
		driver.findElement(By.id("department")).sendKeys("IT");
		Thread.sleep(2000);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(2000);
		
		js.executeScript("scroll(0,150)");
		
		//Button
		driver.findElement(By.id("item-4")).click();
		WebElement dc = driver.findElement(By.id("doubleClickBtn"));
		action.doubleClick(dc).build().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement rc = driver.findElement(By.id("rightClickBtn"));
		action.contextClick(rc).build().perform();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[3]/button[1]")).click();
		Thread.sleep(2000);
		js.executeScript("scroll(0,300)");
		
		//Links
		driver.findElement(By.id("item-5")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("simpleLink")).click();
		String current = driver.getWindowHandle();
		Set<String> tabs = driver.getWindowHandles();
		System.out.println(tabs);
		Iterator<String> i = tabs.iterator();
		while(i.hasNext())
		{
			String child = i.next();
			if(!child.equalsIgnoreCase(current))
			{
				driver.switchTo().window(child);
				Thread.sleep(6000);
				driver.switchTo().window(current);
			}
		}

		//DynamicProperties
		js.executeScript("scroll(0,1000)");
		driver.findElement(By.id("item-8")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("enableAfter")).click();
		Thread.sleep(5000);
		
		//UploadFile
		js.executeScript("scroll(0,1000)");
		driver.findElement(By.id("item-7")).click();
		driver.findElement(By.id("downloadButton")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("uploadFile")).sendKeys("C:\\Users\\Asus\\Pictures\\Saved Pictures\\sampleFile.jpg");
		Thread.sleep(5000);
		
		driver.findElement(By.cssSelector("div.body-height:nth-child(2) div.container.playgound-body div.row div.col-12.mt-4.col-md-3:nth-child(1) div.left-pannel div.accordion div.element-group:nth-child(1) span.group-header > div.header-wrapper")).click();
		
		//FrameAndWindows
		js.executeScript("scroll(0,500)");
		driver.findElement(By.cssSelector("div.body-height:nth-child(2) div.container.playgound-body div.row div.col-12.mt-4.col-md-3:nth-child(1) div.left-pannel div.accordion div.element-group:nth-child(3) span.group-header div.header-wrapper > div.header-text")).click();
		//BrowserWindows
		driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[1]")).click();
		Thread.sleep(2000);
		//NewTab
		driver.findElement(By.id("tabButton")).click();
		String current1 = driver.getWindowHandle();
		Set<String> tabs1 = driver.getWindowHandles();
		Iterator<String> i1 = tabs1.iterator();
		while(i1.hasNext())
		{
			String child1 = i1.next();
			if(!child1.equalsIgnoreCase(current1))
			{
				Thread.sleep(1000);
				driver.switchTo().window(current1);
			}
		}
		
		//NewWindow
		Thread.sleep(1000);
		driver.findElement(By.id("windowButton")).click();
		Thread.sleep(1000);
		String cw= driver.getWindowHandle();
		Set<String> tabs2 = driver.getWindowHandles();
		Iterator<String> i2 = tabs2.iterator();
		while(i2.hasNext())
		{
			String cw1 = i2.next();
			if(!cw1.equalsIgnoreCase(cw))
			{
				Thread.sleep(2000);
				driver.switchTo().window(cw);
			}
		}
		Thread.sleep(2000);
		
		//NewWindowMessage
		driver.findElement(By.id("messageWindowButton")).click();
		Thread.sleep(2000);
		String cw1= driver.getWindowHandle();
		Set<String> tabs3 = driver.getWindowHandles();
		Iterator<String> i3 = tabs3.iterator();
		while(i3.hasNext())
		{
			String cw2 = i3.next();
			if(!cw2.equalsIgnoreCase(cw1))
			{
				Thread.sleep(2000);
				driver.switchTo().window(cw1);
			}
		}
		Thread.sleep(1000);
		js.executeScript("scroll(0,300)");
		
		//Alerts
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("alertButton")).click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Alert text = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		
		driver.findElement(By.id("timerAlertButton")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert2 = driver.switchTo().alert();
		Thread.sleep(6000);
		alert.accept();
		
		driver.findElement(By.id("confirmButton")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert3 = driver.switchTo().alert();
		Thread.sleep(1000);
		alert.accept();
		System.out.println(driver.findElement(By.id("confirmResult")).getText());
		
		driver.findElement(By.id("promtButton")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert4 = driver.switchTo().alert();
		Thread.sleep(1000);
		alert.sendKeys("Seven Bits Technologies LLP");
		Thread.sleep(1000);
		alert.accept();
		System.out.println(driver.findElement(By.id("promptResult")).getText());
		Thread.sleep(3000);
		
		//ModalDialogs
		js.executeScript("scroll(0,500)");
		driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[5]")).click();
		driver.findElement(By.id("showSmallModal")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("closeSmallModal")).click();
		
		driver.findElement(By.id("showLargeModal")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("closeLargeModal")).click();
		
		driver.findElement(By.cssSelector("div.body-height:nth-child(2) div.container.playgound-body div.row div.col-12.mt-4.col-md-3:nth-child(1) div.left-pannel div.accordion div.element-group:nth-child(3) span.group-header div.header-wrapper > div.header-text")).click();
		Thread.sleep(3000);
		
		//Widgets
		driver.findElement(By.cssSelector("div.body-height:nth-child(2) div.container.playgound-body div.row div.col-12.mt-4.col-md-3:nth-child(1) div.left-pannel div.accordion div.element-group:nth-child(4) span.group-header div.header-wrapper > div.header-text")).click();
		
		//Accordian
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("div.body-height:nth-child(2) div.container.playgound-body div.row div.col-12.mt-4.col-md-3:nth-child(1) div.left-pannel div.accordion div.element-group:nth-child(4) div.element-list.collapse.show ul.menu-list li.btn.btn-light:nth-child(1) > span.text:nth-child(2)")).click();
		driver.findElement(By.cssSelector("#section1Heading")).click();
		driver.findElement(By.cssSelector("#section2Heading")).click();
		js.executeScript("scroll(0,500)");
		Thread.sleep(2000);
		
		//DatePicker
		driver.findElement(By.cssSelector("div.body-height:nth-child(2) div.container.playgound-body div.row div.col-12.mt-4.col-md-3:nth-child(1) div.left-pannel div.accordion div.element-group:nth-child(4) div.element-list.collapse.show ul.menu-list li.btn.btn-light:nth-child(3) > span.text:nth-child(2)")).click();
		Thread.sleep(2000);
		js.executeScript("document.getElementById('datePickerMonthYearInput').value='06/26/1997'");
		Thread.sleep(2000);
		js.executeScript("document.getElementById('dateAndTimePickerInput').value='June 26, 1997 11:12 AM'");
		Thread.sleep(3000);
		js.executeScript("scroll(0,300)");
		
		//Slider
		driver.findElement(By.xpath("//span[contains(text(),'Slider')]")).click();
		WebElement slider = driver.findElement(By.cssSelector("div.body-height:nth-child(2) div.container.playgound-body div.row div.col-12.mt-4.col-md-6:nth-child(2) form:nth-child(1) div.form-group.row div.col-9 span.range-slider__wrap > input.range-slider.range-slider--primary"));
		action.dragAndDropBy(slider, 80, 0).build().perform();
		Thread.sleep(3000);
		js.executeScript("scroll(0,400)");
		
		//ProgressBar
		driver.findElement(By.xpath("//span[contains(text(),'Progress Bar')]")).click();
		driver.findElement(By.id("startStopButton")).click(); //Start
		Thread.sleep(1000);
		driver.findElement(By.id("startStopButton")).click(); //Stop
		Thread.sleep(3000);
		js.executeScript("scroll(0,600)");
		
		//ToolTips
		driver.findElement(By.xpath("//span[contains(text(),'Tool Tips')]")).click();
		WebElement ToolHover = driver.findElement(By.id("toolTipButton"));
		action.moveToElement(ToolHover).build().perform();
		Thread.sleep(2000);
		WebElement ToolH = driver.findElement(By.id("toolTipTextField"));
		action.moveToElement(ToolH).build().perform();
		Thread.sleep(3000);
		
		//Menu
		js.executeScript("scroll(0,600)");
		driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[8]/span[1]")).click();
		Thread.sleep(2000);
		WebElement item2 = driver.findElement(By.xpath("//a[contains(text(),'Main Item 2')]"));
		action.moveToElement(item2).build().perform();
		Thread.sleep(2000);
		WebElement item2a = driver.findElement(By.xpath("//a[contains(text(),'SUB SUB LIST »')]"));
		action.moveToElement(item2a).build().perform();
		Thread.sleep(2000); 	 	
		
		
		
		
		
		
	}

}
