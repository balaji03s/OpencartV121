package Day39;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDomElements {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://books-pwakit.appspot.com/");
		driver.manage().window().maximize();
		
		//This Element is inside single shadow DOM.
		String cssSelectorForHost1 = "book-app[apptitle='BOOKS']";
		Thread.sleep(1000);
		SearchContext shadow = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
		Thread.sleep(1000);
		shadow.findElement(By.cssSelector("#input")).sendKeys("Welcome");
		
		//This Element is inside 2 nested shadow DOM.
		String cssSelectorForHost0 = "book-app[apptitle='BOOKS']";
		String cssSelectorForHost2 = "book-input-decorator";
		Thread.sleep(1000);
		SearchContext shadow0 = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
		Thread.sleep(1000);
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("book-input-decorator")).getShadowRoot();
		Thread.sleep(1000);
		shadow1.findElement(By.cssSelector("svg")).click();
		
		
		
		
		
		
		
		
		
		
	}

}
