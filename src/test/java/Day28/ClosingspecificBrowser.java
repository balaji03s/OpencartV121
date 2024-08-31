package Day28;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClosingspecificBrowser {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		
		Set<String> WinIDs=driver.getWindowHandles();
		
		for(String wind:WinIDs)
		{
		String title=driver.switchTo().window(wind).getTitle();
		System.out.println(title);
		
		if(title.equals("OrangeHRM"))
		{
			driver.close();
			break;
		}
		}
		
	}

}
