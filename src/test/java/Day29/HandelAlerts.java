package Day29;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandelAlerts {

	public static void main(String[] args) throws InterruptedException {
		
        WebDriver driver=new ChromeDriver();
        
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		//Normal alert with ok button
		/*driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		Thread.sleep(5000);
		//driver.switchTo().alert().accept();
		Alert myalert=driver.switchTo().alert();
		System.out.println(myalert.getText());
		myalert.accept();
		
		//Alert with ok and cancel button
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		Thread.sleep(5000);
		driver.switchTo().alert().dismiss();*/
		
		//Prompt alert
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Thread.sleep(5000);
		Alert myalert=driver.switchTo().alert();
		myalert.sendKeys("Hi Java");
		myalert.accept();
		
		
		
		
		
	}

}
