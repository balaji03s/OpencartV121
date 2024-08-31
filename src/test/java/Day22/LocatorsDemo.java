package Day22;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorsDemo {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("search")).sendKeys("Mac");
		
		boolean logos=driver.findElement(By.id("logo")).isDisplayed();
		System.out.println(logos);
		
		//driver.findElement(By.linkText("Tablets")).click();
		
		//driver.findElement(By.partialLinkText("Table")).click();
		
		List<WebElement>headerLinks=driver.findElements(By.className("list-inline-item"));
		System.out.println("Total num.of header links: "+headerLinks.size());
		
		List<WebElement>AllLinks=driver.findElements(By.tagName("a"));
		System.out.println("Total num.of links "+AllLinks.size());
		
		List<WebElement>AllImages=driver.findElements(By.tagName("img"));
		System.out.println("Total num.of Images: "+AllImages.size());
	}

}
