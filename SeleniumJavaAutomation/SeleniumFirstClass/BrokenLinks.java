import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());

		for (WebElement link : links) {
			String linkUrl = link.getAttribute("href");
			URL url = new URL(linkUrl);
			URLConnection urlConnection = url.openConnection();
			HttpURLConnection httpUrlConn = (HttpURLConnection) urlConnection;
			httpUrlConn.setConnectTimeout(5000);
			httpUrlConn.connect();
			if (httpUrlConn.getResponseCode() == 200)
				System.out.println(linkUrl + " - " + httpUrlConn.getResponseMessage());
			else
				System.err.println(
						linkUrl + " - " + httpUrlConn.getResponseCode() + " - " + httpUrlConn.getResponseMessage());

			httpUrlConn.disconnect();
		}
	}
}