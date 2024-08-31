package Day40;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataintoExcel {

	public static void main(String[] args) throws IOException {

		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\TestData\\Mydata.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("Data");

		XSSFRow row1 = sheet.createRow(0);
		row1.createCell(0).setCellValue("Java");
		row1.createCell(1).setCellValue(20);
		row1.createCell(2).setCellValue("Automation");

		XSSFRow row2 = sheet.createRow(1);
		row2.createCell(0).setCellValue("Moni");
		row2.createCell(1).setCellValue(2.5);
		row2.createCell(2).setCellValue("Uma");

		XSSFRow row3 = sheet.createRow(2);
		row3.createCell(0).setCellValue("Balaji");
		row3.createCell(1).setCellValue(25);
		row3.createCell(2).setCellValue("Uma");
		
		workbook.write(file);
		workbook.close();
		file.close();
		
		System.out.println("File is created");

	}

}
