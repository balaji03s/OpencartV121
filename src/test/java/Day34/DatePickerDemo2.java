package Day34;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePickerDemo2 {

	// user defind method for converting month from string
	static Month convertMonth(String month) {
		HashMap<String, Month> monthMap = new HashMap<String, Month>();

		monthMap.put("January", Month.JANUARY);
		monthMap.put("February", Month.FEBRUARY);
		monthMap.put("March", Month.MARCH);
		monthMap.put("April", Month.APRIL);
		monthMap.put("May", Month.MAY);
		monthMap.put("June", Month.JUNE);
		monthMap.put("July", Month.JULY);
		monthMap.put("August", Month.AUGUST);
		monthMap.put("September", Month.SEPTEMBER);
		monthMap.put("October", Month.OCTOBER);
		monthMap.put("November", Month.NOVEMBER);
		monthMap.put("December", Month.DECEMBER);

		Month vmonth = monthMap.get(month);

		if (vmonth == null) {
			System.out.println("Invalid month");
		}

		return vmonth;

	}

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		// Input DOB
		String Year = "2025";
		String Month = "June";
		String Date = "15";

		driver.switchTo().frame("frame-one796456169");

		driver.findElement(By.xpath("//span[@class='icon_calendar']")).click();

		// year
		WebElement year = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select selectyear = new Select(year);
		selectyear.selectByVisibleText(Year);

		// select Month

		while (true) {

			String displayMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

			// convert required month & displayMonth in to Month object

			Month expectedMonth = convertMonth(Month);
			Month currentMonth = convertMonth(displayMonth);

			// compare

			int result = expectedMonth.compareTo(currentMonth);

			if (result < 0) {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();// past
			} else if (result > 0) {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();// feature
			} else {
				break;
			}

		}

		// date
		List<WebElement> allDate = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr/td//a"));
		for (WebElement da : allDate) {
			if (da.getText().equals(Date)) {
				da.click();
				break;
			}
		}

	}

}
