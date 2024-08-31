package Day36;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpentheLinkinNewTab {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

		WebElement register = driver.findElement(By.xpath("//a[normalize-space()='Register']"));

		Actions act = new Actions(driver);

		act.keyDown(Keys.CONTROL).click(register).keyUp(Keys.CONTROL).perform();

		// switching to register page
		List<String> ids = new ArrayList(driver.getWindowHandles());

		driver.switchTo().window(ids.get(1));// swithc to register page

		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Balaji");

		// Parent page
		driver.switchTo().window(ids.get(0));
		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("TShirts");

	}

}
