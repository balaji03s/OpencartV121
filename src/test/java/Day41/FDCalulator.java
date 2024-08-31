package Day41;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FDCalulator {

	public static void main(String[] args) throws IOException, InterruptedException {

		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		
		String filePath=System.getProperty("user.dir")+"\\TestData\\FDCalculate.xlsx";
		
		int rows=ExcelUtility.getRowCount(filePath, "Sheet1");
		
		for(int i=1;i<=rows;i++)
		{
			//read date form excel
			String pric=ExcelUtility.getCellData(filePath, "Sheet1", i, 0);
			String reteofIntrest=ExcelUtility.getCellData(filePath, "Sheet1", i, 1);
			String period1=ExcelUtility.getCellData(filePath, "Sheet1", i, 2);
			String period2=ExcelUtility.getCellData(filePath, "Sheet1", i, 3);
			String fre=ExcelUtility.getCellData(filePath, "Sheet1", i, 4);
			String exp_maturity=ExcelUtility.getCellData(filePath, "Sheet1", i, 5);
			
			//pass above date into application 
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(pric);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(reteofIntrest);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(period1);
			
			Select predrp=new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			predrp.selectByVisibleText(period2);
			
			Select fredrp=new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			fredrp.selectByVisibleText(fre);
			
			driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click();//click calculate//
			
			//validation
			String act_mvalue=driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			
			if(Double.parseDouble(exp_maturity)==Double.parseDouble(act_mvalue))
			{
				System.out.println("Test passed");
				ExcelUtility.setCellData(filePath, "Sheet1", i, 7,"Passed");
				ExcelUtility.fillGreenColor(filePath, "Sheet1",i,7);
			}
			else
			{
				System.out.println("Test failed");
				ExcelUtility.setCellData(filePath, "Sheet1", i, 7,"Failed");
				ExcelUtility.fillRedColor(filePath, "Sheet1", i,7);
			}
			Thread.sleep(3000);
			driver.findElement(By.xpath("//img[@class='PL5']")).click();
			
			
		}//ending for for loop
		
		driver.close();
		
		
		
		
	}

}
