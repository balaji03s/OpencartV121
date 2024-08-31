package Day28;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("Java");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		List<WebElement>links=driver.findElements(By.tagName("a"));
		System.out.println("Number of links: "+links.size());
		
		for(WebElement Alllink:links)
		{
			String link=Alllink.getText();
			System.out.println(Alllink);
			
		}
		
	}

}
