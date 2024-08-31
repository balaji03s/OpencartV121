package Day39;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total numof Links: " + links.size());

		int noofBrokenLinks = 0;

		for (WebElement linkElement : links) {
			String hrefvalue = linkElement.getAttribute("href");

			if (hrefvalue == null || hrefvalue.isEmpty()) {
				System.out.println("href value is null or empty. So not possible to check");
				continue;
			}
			// hit url to the server

			try {

				URL url = new URL(hrefvalue);// conver href value string to URL format
				HttpURLConnection connurl = (HttpURLConnection) url.openConnection();
				connurl.connect();// connect to server and sent to request to the server

				if (connurl.getResponseCode() >= 400) {
					System.out.println(hrefvalue + "===>It is a broken link");
					noofBrokenLinks++;
				} else {
					System.out.println(hrefvalue + "===>Not a broken link");
				}

			} catch (Exception e) {
			}

		}

		System.out.println("Number of BorkenLinks:" + noofBrokenLinks);// 42

	}

}
