package com.vk.rahulShetty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

	public ArrayList<String> getData(String getExcelData) throws IOException {

		//Identify testcases column by scanning the entire 1st row
		//Once coloumn is identified then scan entire testcase coloumn to identify purchase testcase row
		//After you grab the purchase testcase row = pull all the data of that row and feed into test

		FileInputStream fis = new FileInputStream("./src/test/resources/Test.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		ArrayList<String> data = new ArrayList<>();

		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {

			if(workbook.getSheetName(i).equalsIgnoreCase("Sheet2"))
			{
				XSSFSheet sheet = workbook.getSheetAt(i);
				//Identify testcases column by scanning the entire 1st row
				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();
			
				Iterator<Cell> cell = firstRow.cellIterator();
				int k = 0;
				int coloumn = 0;
				while (cell.hasNext()) 
				{
					Cell value = cell.next();
					if(value.getStringCellValue().equalsIgnoreCase("Test Cases"))
					{
						coloumn = k;
					}
					k++;
				}
				System.out.println(coloumn);
				//Once coloumn is identified then scan entire testcase coloumn to identify purchase testcase row
				while (rows.hasNext()) 
				{
					Row r= rows.next();
					if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase("getExcelData"))
					{
						//After you grab the purchase testcase row = pull all the data of that row and feed into test
						Iterator<Cell> cv = r.cellIterator();
								while (cv.hasNext()) 
								{
									data.add(cv.next().getStringCellValue());
									
								}
					}
					
				}
			}
		}
		return data;

	}
	
	public static void main(String[] args) throws IOException {

	}

}
