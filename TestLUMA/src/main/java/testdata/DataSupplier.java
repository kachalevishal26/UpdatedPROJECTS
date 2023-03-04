package testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import base.TestBase;

public class DataSupplier extends TestBase {
	public static Object getData(String sheetName) {
		String ExcelPath = "C:\\Users\\Asus\\eclipse-workspace\\TestLUMA\\src\\main\\java\\testdata\\LumaDemo.xlsx";
		FileInputStream file = null;
		XSSFWorkbook book;
		XSSFSheet sheet = null;
		int rows = 0;
		int cols = 0;
		
		try {
			file = new FileInputStream(ExcelPath);
			book = new XSSFWorkbook(file);
			sheet = book.getSheet(sheetName);
			rows = sheet.getLastRowNum();
			cols = sheet.getRow(0).getLastCellNum();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Object[][] data = new Object[rows][cols];
		
		for (int i = 0; i < rows; i++) {
			XSSFRow row = sheet.getRow(i+1);
			for (int j = 0; j < cols; j++) {
				XSSFCell cell = row.getCell(j);
				
				switch (cell.getCellType()) {
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
					
				case NUMERIC:
					if(DateUtil.isCellDateFormatted(cell)) {
						data[i][j] = String.valueOf(cell.getDateCellValue());
					} else {
						data[i][j] = String.valueOf((long)cell.getNumericCellValue());
					}
					break;
					
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
					
				case BLANK:
					cell.setBlank();
					break;

				default:
					System.err.println("invalid data type");
					break;
				}
			}
		}
		return data;
	}
}
