package Day35;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.manage().window().maximize();

		Actions ac = new Actions(driver);

		WebElement rome = driver.findElement(By.xpath("//div[@id='box6']"));
		WebElement italy = driver.findElement(By.xpath("//div[@id='box106']"));

		ac.dragAndDrop(rome, italy).perform();

		WebElement wash = driver.findElement(By.xpath("//div[@id='box3']"));
		WebElement us = driver.findElement(By.xpath("//div[@id='box103']"));

		ac.dragAndDrop(wash, us).perform();
	}

}
