package Day35;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleclickAction {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();

		// switch to frame
		driver.switchTo().frame("iframeResult");

		WebElement box1 = driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement box2 = driver.findElement(By.xpath("//input[@id='field2']"));
		WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));

		box1.clear();
		box1.sendKeys("Welcome to Capgemini");

		Actions ac = new Actions(driver);
		ac.doubleClick(button).perform();

		// validation same text or not
		
		/*String text=box2.getText();
		System.out.println("Captureed value: "+text);

		if (text.equals("Welcome to Capgemini")) {
			System.out.println("Text copied");
		} else {
			System.out.println("Text not copied properly");
		}*/
	}

}
