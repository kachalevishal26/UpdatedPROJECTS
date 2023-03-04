package page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class RegisterPage extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	@FindBy(id = "input-firstname")
	WebElement fName;

	@FindBy(id = "input-lastname")
	WebElement lName;

	@FindBy(id = "input-email")
	WebElement eMail;

	@FindBy(id = "input-telephone")
	WebElement telePhone;

	@FindBy(xpath = "//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]")
	WebElement pPolicy;

	@FindBy(id = "input-password")
	WebElement uPwd;

	@FindBy(id = "input-confirm")
	WebElement uCpwd;

	@FindBy(xpath = "//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[2]")
	WebElement searchBtn;

	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}

	public void navToReg() {
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='nav pull-right']/ul/li "));
		for (int i = 0; i < list.size(); i++) {
			String txt = list.get(i).getText();
			if (txt.equals("My Account")) {
				list.get(i).click();

				List<WebElement> listReg = driver
						.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li/a"));
				for (int j = 0; j < listReg.size(); j++) {
					String text = listReg.get(j).getText();
					System.out.println(text);
					if (text.equals("Register")) {
						listReg.get(j).click();
					}
				}
			}
		}
	}

	public void regPage() {
		driver.navigate().refresh();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("scroll(0,320)");
		
			fName.sendKeys("Vishal");
			lName.sendKeys("Kachale");
			eMail.sendKeys("test@gmail.com");
			telePhone.sendKeys("7600768111");
			uPwd.sendKeys("123456");
			uCpwd.sendKeys("123456");
			pPolicy.click();
//			searchBtn.click();
		}
	}