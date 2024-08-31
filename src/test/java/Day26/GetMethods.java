package Day26;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GetMethods {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		
		String Title=driver.getTitle();
		System.out.println(Title);
		
		System.out.println(driver.getCurrentUrl());
		
		//System.out.println(driver.getPageSource());
		
		String WinID=driver.getWindowHandle();
		System.out.println("Windowid "+WinID);
		
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		
		Set<String> WinsID=driver.getWindowHandles();
		System.out.println("Windosssid: "+WinsID);
		
		
		
		
	}

}
