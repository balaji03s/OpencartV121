package Day29;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleChekboxs {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		// specific check box
		// driver.findElement(By.xpath("//input[@id='sunday']")).click();

		// all checkbox
		List<WebElement> allchkbx = driver
				.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));

		/*
		 * for(int i=0;i<allchkbx.size();i++) { allchkbx.get(i).click();
		 * 
		 * }
		 * 
		 * for(WebElement checkbox:allchkbx) { checkbox.click(); }
		 * 
		 * 
		 * //Select last 3 checkboxs //total num.of txbox-how many check box want to
		 * select//7-3=4 for(int i=4;i<allchkbx.size();i++) { allchkbx.get(i).click(); }
		 */

		// select first 3 txtbox
		for (int i = 0; i < 3; i++) {
			allchkbx.get(i).click();
		}

		Thread.sleep(5000);

		// unselect chekbox
		for (int i = 0; i < allchkbx.size(); i++) {
			if (allchkbx.get(i).isSelected()) {
				allchkbx.get(i).click();
			}
		}

	}

}
