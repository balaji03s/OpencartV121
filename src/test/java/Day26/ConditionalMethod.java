package Day26;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConditionalMethod {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();
		
		WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		System.out.println("Display status of logo: "+logo.isDisplayed());
		
		boolean firstname=driver.findElement(By.xpath("//input[@id='FirstName']")).isEnabled();
		System.out.println("Enable status:"+firstname);
		
		WebElement male=driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement female=driver.findElement(By.xpath("//input[@id='gender-female']"));
		
		System.out.println("Before selected");
		System.out.println(male.isSelected());
		System.out.println(female.isSelected());
		
		System.out.println("After selected");
		male.click();
		System.out.println(male.isSelected());
		System.out.println(female.isSelected());
		
		boolean newletter=driver.findElement(By.xpath("//input[@id='Newsletter']")).isSelected();
		System.out.println("Newletter status: "+newletter);
		
		
		;
	}

}
