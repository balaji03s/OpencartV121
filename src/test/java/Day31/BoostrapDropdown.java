package Day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;

public class BoostrapDropdown {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	      
		 driver.get("https://jquery-az.com/boots/demo.php?ex=63.0_2");
		 driver.manage().window().maximize();
		 
		 driver.findElement(By.xpath("//span[@class='multiselect-selected-text']")).click();
		 
		 //single options
		 driver.findElement(By.xpath("//input[@value='Java']")).click();
		 
		 //capture all the options and find the size
		 List<WebElement>options=driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));
		 System.out.println(options.size());
		 
		 //printing options
		 for(int i=0;i<options.size();i++)
		 {
			 System.out.println(options.get(i).getText());
		 }
		 
		 //select multiple options
		 for(WebElement op:options)
		 {
			 String option=op.getText();
			 
			 if(option.equals("Java")|| option.equals("Python")||option.equals("MySQL"));
			 {
				 op.click();
			 }
		 }
		 
		 
		
	}

}
