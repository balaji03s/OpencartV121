package Day33;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaginationTable {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	      
		 driver.get("https://testautomationpractice.blogspot.com/");
		 driver.manage().window().maximize();
		 
		 for(int p=1;p<=4;p++)
		 {
			 int noofRows=driver.findElements(By.xpath("//table[@id='productTable']//tbody/tr")).size(); 
		 
		
		 
		 
		 for(int r=1;r<=noofRows;r++)
		 {
			String name=driver.findElement(By.xpath("//table[@id='productTable']//tbody/tr["+r+"]//td[2]")).getText();
			String price=driver.findElement(By.xpath("//table[@id='productTable']//tbody/tr["+r+"]//td[3]")).getText();
			driver.findElement(By.xpath("(//input[@type='checkbox'])[8]")).click();
			System.out.println(name+"\t"+price);
		 }
		 
		 }
	}

}
