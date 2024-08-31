package Day38;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaputreScreenshot {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

		/*
		 * //full page screenshot TakesScreenshot ts= (TakesScreenshot)driver; File
		 * sourceFile=ts.getScreenshotAs(OutputType.FILE); File targetFile=new
		 * File(System.getProperty("user.dir")+"\\Screenshot\\fullpage.png");
		 * sourceFile.renameTo(targetFile);//copy source to target
		 */

		// specific section

		/*
		 * WebElement featureProeuct=driver.findElement(By.
		 * xpath("//div[@class='product-grid home-page-product-grid']")); File
		 * sourceFile=featureProeuct.getScreenshotAs(OutputType.FILE); File
		 * targeFile=new
		 * File(System.getProperty("user.dir")+"\\Screenshot\\featurepro.png");
		 * sourceFile.renameTo(targeFile);
		 */

		// Specific Webelement
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		File sourceFile = logo.getScreenshotAs(OutputType.FILE);
		File targeFile = new File(System.getProperty("user.dir") + "\\Screenshot\\logo.png");
		sourceFile.renameTo(targeFile);

	}

}
