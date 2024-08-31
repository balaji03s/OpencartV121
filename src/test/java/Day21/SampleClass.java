package Day21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleClass {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		String title=driver.getTitle();
		System.out.println(title);
		
		if(title.equals("Your Store"))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test failed");
		}
	
	
	}

}
