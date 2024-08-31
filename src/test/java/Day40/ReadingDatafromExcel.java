package Day40;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Execl file-->WorkBook-->Sheets-->Rows-->Cells

public class ReadingDatafromExcel {

	public static void main(String[] args) throws IOException {

		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\TestData\\BookData.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);

		XSSFSheet sheet = workbook.getSheet("Sheet1");

		int totalRows = sheet.getLastRowNum();

		int totalCells = sheet.getRow(0).getLastCellNum();

		System.out.println("Numer of Row:" + totalRows);// 5
		System.out.println("Number of Cells:" + totalCells);// 4

		for (int r = 0; r <= totalRows; r++) {
			XSSFRow CurrentRow = sheet.getRow(r);

			for (int c = 0; c < totalCells; c++) {
				XSSFCell cell = CurrentRow.getCell(c);
				System.out.print(cell.toString() + "\t");
			}
			System.out.println();
		}

		workbook.close();
		file.close();

	}

}
