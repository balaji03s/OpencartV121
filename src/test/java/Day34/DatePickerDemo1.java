package Day34;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo1 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();

		// swithc to fram
		driver.switchTo().frame(0);

		// 1.Useing sendkey method
		// driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("11/20/2024");

		// 2. Using datepicker element
		String year = "2025";
		String month = "March";
		String date = "20";

		driver.findElement(By.xpath("//input[@id='datepicker']")).click();

		// select monthe and year
		while (true) {
			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();// month
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			if (currentMonth.equals(month) && currentYear.equals(year)) {
				break;
			}

			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();// next year
			// driver.findElement(By.xpath("//span[@class='ui-icon
			// ui-icon-circle-triangle-w']")).click();//previous

		}
		// Select the date
		List<WebElement> allDates = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody/tr//td//a"));

		for (WebElement dt : allDates) {
			if (dt.getText().equals(date)) {
				dt.click();
				break;
			}
		}

	}

}
