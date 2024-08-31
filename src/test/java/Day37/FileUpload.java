package Day37;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();

		// Single file upload
		/*
		 * driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(
		 * "F:\\Selenium\\DropDown_Notes.txt");
		 * 
		 * if
		 * (driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText().equals(
		 * "DropDown_Notes.txt")) { System.out.println("File is successfully uploaded");
		 * } else { System.out.println("Upload filed."); }
		 */
		// Multiple file uploade
		String file1 = "F:\\\\Selenium\\\\DropDown_Notes.txt";
		String file2 = "F:\\Selenium\\File Handling.txt";

		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1 + "\n" + file2);

		int nooffile = driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();

		if (nooffile == 2) {
			System.out.println("All files are uploaded");
		} else {
			System.out.println("Uploaded filed");
		}

		// validate file name
		if (driver.findElement(By.xpath("//ul[@id='fileList']//li[1]")).getText().equals("DropDown_Notes.txt")
				&& driver.findElement(By.xpath("//ul[@id='fileList']//li[2]")).getText().equals("File Handling.txt")) {
			System.out.println("File name maching");
		} else {
			System.out.println("File name not matching");
		}
	}

}
