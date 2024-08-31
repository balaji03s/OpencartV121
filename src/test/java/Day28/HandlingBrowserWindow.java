package Day28;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.base.Strings;

public class HandlingBrowserWindow {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		
		Set<String> WinIDs=driver.getWindowHandles();
		
		//1
		/*List<String> winList=new ArrayList(WinIDs);
		String ParendID=winList.get(0);
		String ChidID=winList.get(1);
		
		//swith child window
		driver.switchTo().window(ChidID);
		System.out.println(driver.getTitle());
		
		//swith to parent
		driver.switchTo().window(ParendID);
		System.out.println(driver.getTitle());
		*/
		
		//2
		for(String winID:WinIDs)
		{
			String title=driver.switchTo().window(winID).getTitle();
			if(title.equals("OrangeHRM"))
			{
				System.out.println(driver.getCurrentUrl());
			}
		}

		
		

	}

}
