package com.demo.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class dataSupplier {
	
	static Workbook book;
	static Sheet sheet;
	
	public static String EXCEL_DATA_PATH = "C:\\Users\\Asus\\eclipse-workspace\\OrangeHRM\\src\\test\\java\\com\\demo\\test\\ExcelData.xlsx";
	
	public static Object[][] getData(String sheetName) {
		 FileInputStream file = null;
		 
		 try {
			file = new FileInputStream(EXCEL_DATA_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 
		 try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		 sheet = book.getSheet(sheetName);
		 Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		 
		 for (int i = 0; i < sheet.getLastRowNum(); i++) {
			 for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				 data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
}
