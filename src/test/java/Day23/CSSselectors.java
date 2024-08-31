package Day23;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CSSselectors {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//tag id
		//driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("Laptops");
		//driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("Laptops");
		
		//tag class  tag.class
		//driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("Mobile");
		//driver.findElement(By.cssSelector(".search-box-text")).sendKeys("Mobile");

		// tag attribute 
		//driver.findElement(By.cssSelector("input[placeholder='Search store'")).sendKeys("Tab");
		
		//tag class attribute
		driver.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("iPad");
	}
}