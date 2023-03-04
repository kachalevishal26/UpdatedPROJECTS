package com.bw.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.bw.base.TestBase;

public class TestUtil extends TestBase 
{
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICITLY_WAIT = 10;
	

	static Workbook book;
	static Sheet sheet;
	
	public static String EXCEL_DATA_SHEET = "C:\\Users\\Asus\\eclipse-workspace\\POM_BrakeWorld\\src\\main\\java\\com\\bw\\util\\BrakeWorld.xlsx";
	
	public static Object[][] getData(String sheetName) 
	{
		FileInputStream file = null;
		try 
		{
			file = new FileInputStream(EXCEL_DATA_SHEET); 
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		try 
		{
			book = WorkbookFactory.create(file);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i = 0; i < sheet.getLastRowNum(); i++) 
		{
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) 
			{
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
}
