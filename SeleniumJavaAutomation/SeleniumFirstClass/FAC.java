import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class FAC {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\chromedriver.exe\\");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver;

		//Home page
		//driver.get("https://cafifthavenuecollectionlatest.7bits.in/");
		driver.get("https://cafifthavenuecollectionlatest.7bits.in/");
		Actions action = new Actions(driver);
		WebElement hover = driver.findElement(By.cssSelector("div.master-wrapper-page:nth-child(6) div.main_header.sticky-header.color_four div.container-fluid div.header_container div.row.align-items-center div.col-lg-3 div.header_account_area.align-items-center div.header_account-list.top_links.user-info-header.user-info-header-mr:nth-child(2) a:nth-child(1) > i.icon.icon-User"));
		action.moveToElement(hover).build().perform();

		//Register page
		driver.findElement(By.cssSelector("div.master-wrapper-page:nth-child(6) div.main_header.sticky-header.color_four div.container-fluid div.header_container div.row.align-items-center div.col-lg-3 div.header_account_area.align-items-center div.header_account-list.top_links.user-info-header.user-info-header-mr:nth-child(2) div.dropdown_links:nth-child(2) div.dropdown_links_list ul:nth-child(1) li:nth-child(1) > a:nth-child(1)")).click();
		js.executeScript("scroll(0,850)");
		Thread.sleep(5000);
		driver.findElement(By.id("register-button")).click();
		driver.findElement(By.id("gender-male")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Karan");
		driver.findElement(By.id("LastName")).sendKeys("Chauhan");
		driver.findElement(By.id("Email")).sendKeys("kbc31@gmail.com");
		driver.findElement(By.id("Username")).sendKeys("kbc3107");
		driver.findElement(By.id("Company")).sendKeys("Kataria AM");
		driver.findElement(By.id("customer_attribute_2")).sendKeys("+91 8866278316");
		driver.findElement(By.id("customer_attribute_5")).sendKeys("English, Hindi, Gujarati");
		driver.findElement(By.id("Password")).sendKeys("123456");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("1234");
		driver.findElement(By.id("register-button")).click();
		js.executeScript("scroll(0,850)");
		Thread.sleep(2000);
		js.executeScript("scroll(0,850)");
		driver.findElement(By.id("ConfirmPassword")).clear();
		driver.findElement(By.id("ConfirmPassword")).sendKeys("123456");
		Thread.sleep(2000);
		driver.findElement(By.id("register-button")).click();

		//Hover
		WebElement hover2 = driver.findElement(By.cssSelector("div.master-wrapper-page:nth-child(6) div.main_header.sticky-header.color_four div.container-fluid div.header_container div.row.align-items-center div.col-lg-3 div.header_account_area.align-items-center div.header_account-list.top_links.user-info-header.user-info-header-mr:nth-child(2) a:nth-child(1) > i.icon.icon-User"));
		action.moveToElement(hover2).build().perform();

		//Login page
		driver.findElement(By.cssSelector("div.master-wrapper-page:nth-child(6) div.main_header.sticky-header.color_four div.container-fluid div.header_container div.row.align-items-center div.col-lg-3 div.header_account_area.align-items-center div.header_account-list.top_links.user-info-header.user-info-header-mr:nth-child(2) div.dropdown_links:nth-child(2) div.dropdown_links_list ul:nth-child(1) li:nth-child(2) > a:nth-child(1)")).click();
		
		driver.findElement(By.cssSelector("div.master-wrapper-page:nth-child(6) div.master-wrapper-content:nth-child(4) div.master-column-wrapper div.center-1 div.page.login-page.customer_login div.page-body.container div.customer-blocks.row div.col-lg-6.col-md-6:nth-child(1) div.account_form div.login-box:nth-child(2) div.login_submit:nth-child(2) > button.button-1.register-button")).click();
		js.executeScript("scroll(0,800)");
		driver.navigate().back();
		
		driver.findElement(By.cssSelector("#pills-profile-tab")).click();
		driver.findElement(By.id("pills-home-tab")).click();
	
		js.executeScript("scroll(0,200)");
		Thread.sleep(2000);
		driver.findElement(By.id("Username")).sendKeys("vk26");
		driver.findElement(By.id("Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("div.master-wrapper-page:nth-child(6) div.master-wrapper-content:nth-child(4) div.master-column-wrapper div.center-1 div.page.login-page.customer_login div.page-body.container div.customer-blocks.row div.col-lg-6.col-md-6:nth-child(2) div.account_form.login-tab-div div.login-box.returning-wrapper.fieldset.tab-content div.tab-pane.fade.show.active:nth-child(1) form:nth-child(1) div.login_submit:nth-child(3) > button:nth-child(4)")).click();
		
		//Home
		driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/nav[1]/ul[1]/li[1]/a[1]")).click();
		js.executeScript("scroll(0,15000)");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("body:nth-child(2) a:nth-child(19) > i.fa.fa-angle-double-up")).click();
		Thread.sleep(2000);
		
		//Category
		WebElement hover1 = driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/nav[1]/ul[1]/li[2]/a[1]"));
		action.moveToElement(hover1).build().perform();
		
		driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]")).click();
		js.executeScript("scroll(0,6000)");
		driver.findElement(By.cssSelector("body:nth-child(2) a:nth-child(19) > i.fa.fa-angle-double-up")).click();
		Thread.sleep(3000);
		js.executeScript("scroll(0,1300)");
		
		//QuickView
		WebElement hov= driver.findElement(By.cssSelector("div.master-wrapper-page:nth-child(6) div.master-wrapper-content:nth-child(4) div.master-column-wrapper div.shop_area.mt-100.mb-100.center-2:nth-child(5) div.container div.row div.col-lg-9.col-md-12.center-2 div.page.category-page div.page-body div.products-container div.products-wrapper div.row.shop_wrapper.grid_3 div.col-lg-4.col-md-4.col-sm-6:nth-child(2) article.single_product.product-item figure:nth-child(1) div.product_thumb:nth-child(1) a:nth-child(1) > img:nth-child(1)"));
		action.moveToElement(hov).build().perform();
		driver.findElement(By.cssSelector("div.master-wrapper-page:nth-child(6) div.master-wrapper-content:nth-child(4) div.master-column-wrapper div.shop_area.mt-100.mb-100.center-2:nth-child(5) div.container div.row div.col-lg-9.col-md-12.center-2 div.page.category-page div.page-body div.products-container div.products-wrapper div.row.shop_wrapper.grid_3 div.col-lg-4.col-md-4.col-sm-6:nth-child(2) article.single_product.product-item div.product_thumb:nth-child(1) div.action_links:nth-child(2) ul:nth-child(1) li.quick_button a:nth-child(1) > i.icon.icon-Eye")).click();
		String plp = driver.getWindowHandle();
		
		Set<String> tabs = driver.getWindowHandles();
		System.out.println(tabs);
		
		Iterator<String> i = tabs.iterator();
		while(i.hasNext())
		{
			String view = i.next();
			if(!view.equalsIgnoreCase(plp))
			{
				driver.switchTo().window(view);
				System.out.print(view);
				js.executeScript("scroll(0,500)");
				//driver.findElement(By.id("add-to-cart-button-996")).click();
				driver.close();
			}
		}

		/*
		//Home - Category (Repeat)
		driver.findElement(By.cssSelector("body:nth-child(2) a:nth-child(19) > i.fa.fa-angle-double-up")).click();
		
		WebElement h1 = driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/nav[1]/ul[1]/li[2]/a[1]"));
		action.moveToElement(h1).build().perform();
		
		driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]")).click();
		js.executeScript("scroll(0,1300)");
						
		//CompareList button
		WebElement CompareList = driver.findElement(By.cssSelector("div.master-wrapper-page:nth-child(6) div.master-wrapper-content:nth-child(4) div.master-column-wrapper div.shop_area.mt-100.mb-100.center-2:nth-child(5) div.container div.row div.col-lg-9.col-md-12.center-2 div.page.category-page div.page-body div.products-container div.products-wrapper div.row.shop_wrapper.grid_3 div.col-lg-4.col-md-4.col-sm-6:nth-child(2) article.single_product.product-item figure:nth-child(1) div.product_thumb:nth-child(1) a:nth-child(1) > img:nth-child(1)"));
		action.moveToElement(CompareList).build().perform();
		driver.findElement(By.cssSelector("div.master-wrapper-page:nth-child(6) div.master-wrapper-content:nth-child(4) div.master-column-wrapper div.shop_area.mt-100.mb-100.center-2:nth-child(5) div.container div.row div.col-lg-9.col-md-12.center-2 div.page.category-page div.page-body div.products-container div.products-wrapper div.row.shop_wrapper.grid_3 div.col-lg-4.col-md-4.col-sm-6:nth-child(2) article.single_product.product-item div.product_thumb:nth-child(1) div.action_links:nth-child(2) ul:nth-child(1) li.compare a.button-2.add-to-compare-list-button > i.icon.icon-MusicMixer")).click();
		
		//AddToWishlist
		WebElement WishList = driver.findElement(By.cssSelector("div.master-wrapper-page:nth-child(6) div.master-wrapper-content:nth-child(4) div.master-column-wrapper div.shop_area.mt-100.mb-100.center-2:nth-child(5) div.container div.row div.col-lg-9.col-md-12.center-2 div.page.category-page div.page-body div.products-container div.products-wrapper div.row.shop_wrapper.grid_3 div.col-lg-4.col-md-4.col-sm-6:nth-child(2) article.single_product.product-item figure:nth-child(1) div.product_thumb:nth-child(1) a:nth-child(1) > img:nth-child(1)"));
		action.moveToElement(WishList).build().perform();
		driver.findElement(By.cssSelector("div.master-wrapper-page:nth-child(6) div.master-wrapper-content:nth-child(4) div.master-column-wrapper div.shop_area.mt-100.mb-100.center-2:nth-child(5) div.container div.row div.col-lg-9.col-md-12.center-2 div.page.category-page div.page-body div.products-container div.products-wrapper div.row.shop_wrapper.grid_3 div.col-lg-4.col-md-4.col-sm-6:nth-child(2) article.single_product.product-item div.product_thumb:nth-child(1) div.action_links:nth-child(2) ul:nth-child(1) li.wishlist a.button-2.add-to-wishlist-button > i.icon.icon-Heart")).click();
		driver.navigate().back();
		
		//AddToCart
		WebElement AddToCart = driver.findElement(By.cssSelector("div.master-wrapper-page:nth-child(6) div.master-wrapper-content:nth-child(4) div.master-column-wrapper div.shop_area.mt-100.mb-100.center-2:nth-child(5) div.container div.row div.col-lg-9.col-md-12.center-2 div.page.category-page div.page-body div.products-container div.products-wrapper div.row.shop_wrapper.grid_3 div.col-lg-4.col-md-4.col-sm-6:nth-child(2) article.single_product.product-item figure:nth-child(1) div.product_thumb:nth-child(1) a:nth-child(1) > img:nth-child(1)"));
		action.moveToElement(AddToCart).build().perform();
		driver.findElement(By.cssSelector("div.master-wrapper-page:nth-child(6) div.master-wrapper-content:nth-child(4) div.master-column-wrapper div.shop_area.mt-100.mb-100.center-2:nth-child(5) div.container div.row div.col-lg-9.col-md-12.center-2 div.page.category-page div.page-body div.products-container div.products-wrapper div.row.shop_wrapper.grid_3 div.col-lg-4.col-md-4.col-sm-6:nth-child(2) article.single_product.product-item figure:nth-child(1) div.product_content.grid_content:nth-child(2) div.add_to_cart > a.button-2.product-box-add-to-cart-button")).click();
		
		System.out.println("Successfull");
		*/

		
	}

}
