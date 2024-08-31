package Day24;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathDemo {

	public static void main(String[] args) {
		
		WebDriver driver =new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php");
		driver.manage().window().maximize();
		
		//single attribute
		//driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Laptops");;
		
		//Multiple attribute
		
		//xpath with inner text	
		//driver.findElement(By.xpath("////a[text()='iPhone']")).click();
		/*
		//boolean displayed=driver.findElement(By.xpath("//h3[text()='Featured']")).isDisplayed();
		System.out.println(displayed);
		
		String value=driver.findElement(By.xpath("//h3[text()='Featured']")).getText();
		System.out.println(value);*/
		
		//xpath with contains
		driver.findElement(By.xpath("//input[contains(@placeholder, 'Sea')]")).sendKeys("Mac");
		
		
		//xpath starts-with
		driver.findElement(By.xpath("//input[starts-with(@placeholder, 'Sea')]")).sendKeys("Tab");
		
		//chained xpath
		 boolean img=driver.findElement(By.xpath("//div[@id='logo']/a/img")).isDisplayed();
		System.out.println(img);
		
		
		
	}

}
