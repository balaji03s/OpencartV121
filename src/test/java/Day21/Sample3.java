package Day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample3 {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/login");
		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
		System.out.println(driver.getTitle());
	}

}
