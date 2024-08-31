package Day38;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RunTesnIncognito {

	public static void main(String[] args) {

		ChromeOptions option=new ChromeOptions();
		option.addArguments("--incognito");
		
		WebDriver driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		String title=driver.getTitle();
		
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
