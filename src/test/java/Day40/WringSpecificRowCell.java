package Day40;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WringSpecificRowCell {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\TestData\\Mydata_Dynamic1.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("Data1");
		
		XSSFRow row=sheet.createRow(4);

		XSSFCell cell=row.createCell(5);
		
		cell.setCellValue("Selenium");
		
		
		workbook.write(file);
		workbook.close();
		file.close();
		
	}

}
