package com.vk.rahulShetty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class verticalStoredData {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/Test.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		  XSSFSheet sheet = workbook.getSheetAt(0); // open sheet 1
		  
	        Iterator<Row> rowIterator = sheet.iterator();
	 
	               // Traversing over each row of XLSX file
	                while (rowIterator.hasNext())
	                {
	                    Row row = rowIterator.next();
	 
	                       if(row.getRowNum()!=0) // skip title row
	                       {
	                           Iterator  cellIterator = row.cellIterator();
	 
	                           while (cellIterator.hasNext())
	                            {
	 
	                               Cell cell = (Cell) cellIterator.next();
	 
	                               System.out.print(cell.getStringCellValue() + "\t");
	                            }
	 
	                        }
	               }
			

	}

}
