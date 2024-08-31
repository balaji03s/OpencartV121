package Day32;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTable {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	      
		 driver.get("https://testautomationpractice.blogspot.com/");
		 driver.manage().window().maximize();
		 
		 //total num.of rows in table
		 int rows=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		 
		 //int rows1=driver.findElements(By.tagName("tr")).size();---if only one table
		 
		 System.out.println("Total num.of rows: "+rows);
		 
		 
		 //total num.of column
		 int column=driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		 System.out.println("Total num.of column: "+column);
		 
		 //Read data from specific row and column (6th row and 1 column)
		 String Bookname=driver.findElement(By.xpath("//table[@name='BookTable']//tr[6]//td[1]")).getText();
		 System.out.println(Bookname);
		 
		 //Read date from all the row and columns
		 
		 System.out.println("BookName"+"\t"+"Author"+"\t"+"Subject"+"\t"+"Price");
		 for(int r=2;r<=rows;r++)
		 {
			 for(int c=1;c<=column;c++)
			 {
				 String values=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
				 System.out.println(values+"\t");
			 }
			 System.out.println();
		 }
		 
		 
		 //print book names whose author is Mukesh
		 
		/* for(int r =2;r<=rows;r++)
		 {
			String authorName= driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
			 if(authorName.equals("Mukesh"))
			 {
				 String bookName=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
				 System.out.println(bookName+"\t"+authorName);
			 }*/
			 
			 //find the total price of all the books
			 int total=0;
			 for(int r=2;r<=rows;r++)
			 {
				 String price=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
				 System.out.println(price);
				 total=total+Integer.parseInt(price);
			 }
			 System.out.println("Total price:"+total);
			 
		 }
		 
		 
		 
		 
		 
	}


