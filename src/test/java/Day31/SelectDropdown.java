package Day31;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdown {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
	      
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement drpCountry=driver.findElement(By.xpath("//select[@id='country']"));
		Select sc=new Select(drpCountry);
		
		//select option from drop down
		//sc.selectByVisibleText("France");
		//sc.selectByValue("uk");
		//sc.selectByIndex(4);
		
		List<WebElement>options=sc.getOptions();
		System.out.println("Number of option in dropdown: "+options.size());
		
		//print the options
		for(int i=0;i<options.size();i++)
		{
			String Alldrpdown=options.get(i).getText();
			System.out.println(Alldrpdown);
		}
		
		for(WebElement op:options)
		{
			System.out.println(op.getText());
		}
		
		
		
		
	}

}
