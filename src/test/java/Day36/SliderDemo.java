package Day36;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();

		// Min
		WebElement minSlider = driver.findElement(By.xpath("//div[@class='price-range-block']//span[1]"));
		System.out.println("Location of the Min Slider:" + minSlider.getLocation());// 59,250

		Actions act = new Actions(driver);

		act.dragAndDropBy(minSlider, 100, 250).perform();

		System.out.println("Location of the Min Slider after moving:" + minSlider.getLocation());

		// Max

		WebElement maxSlider = driver.findElement(By.xpath("//span[2]"));
		System.out.println("Location of the Max Slider:" + maxSlider.getLocation());// 544,250
		act.dragAndDropBy(maxSlider, -100, 250).perform();
		System.out.println("Location of the Max Slider after moving:" + maxSlider.getLocation());

	}

}
