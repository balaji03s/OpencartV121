package Day22;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Assignment {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoblaze.com/index.html");
		driver.manage().window().maximize();
		
		List<WebElement>Totlinks=driver.findElements(By.tagName("a"));
		System.out.println("Total num of Links: "+Totlinks.size());
		
		for(WebElement link:Totlinks)
		{
			System.out.println(link.getText());
		}
		
		List<WebElement>Allimg=driver.findElements(By.tagName("img"));
		System.out.println("Total num of images: "+Allimg.size());
		
		
		//driver.findElement(By.linkText("Laptops")).click();
		
		driver.findElement(By.partialLinkText("Lapto")).click();
	}

}
