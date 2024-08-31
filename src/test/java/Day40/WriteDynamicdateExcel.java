package Day40;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDynamicdateExcel {

	public static void main(String[] args) throws IOException {
		
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\TestData\\Mydata_Dynamic.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("DynaicData");
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter how may rows");
		int noOfrows=sc.nextInt();
		
		System.out.println("Enter how may cells");
		int noOfcell=sc.nextInt();
		
		for(int r=0;r<noOfrows;r++)
		{
			XSSFRow currentRow=sheet.createRow(r);
			
			for(int c=0;c<noOfcell;c++) 
			{
				XSSFCell cell=currentRow.createCell(c);
				cell.setCellValue(sc.next());
			}
		}

				
		workbook.write(file); //attache workbook to the file
		workbook.close();
		file.close();
		
		System.out.println("File is created");

		
		
		
	}

}
