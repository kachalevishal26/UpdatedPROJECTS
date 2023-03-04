package com.qa.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.qa.base.TestBase;

public class TestUtils extends TestBase 
{
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	public static Workbook book;
	public static Sheet sheet;
	public static String EXCEL_DATA_SHEET = "C:\\Users\\Asus\\eclipse-workspace\\QAClickAcademy\\src\\main\\java\\com\\qa\\utils\\qa_academy.xlsx";
	
	public static Object[][] getData(String sheetName)
	{
		FileInputStream file = null;
		try 
		{
			file = new FileInputStream(EXCEL_DATA_SHEET);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		try 
		{
			book = WorkbookFactory.create(file);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
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
