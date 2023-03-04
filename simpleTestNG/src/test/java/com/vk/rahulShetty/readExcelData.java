package com.vk.rahulShetty;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


//Identify testcases column by scanning the entire 1st row
//Once coloumn is identified then scan entire testcase coloumn to identify purchase testcase row
//After you grab the purchase testcase row = pull all the data of that row and feed into test

public class readExcelData {

	public ArrayList<String> getData(String testCaseName) throws IOException {
		ArrayList<String> data = new ArrayList<String>();
		File excelFile = new File("./src/test/resources/Test.xlsx");
		FileInputStream fis = new FileInputStream(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) 
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("Sheet2"))
			{
				XSSFSheet sheet = workbook.getSheetAt(i);

				//Identify testcases column by scanning the entire 1st row

				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();

				Iterator<Cell> ce = firstRow.cellIterator();
				int k=0;
				int coloum = 0;
				while(ce.hasNext())
				{
					Cell value = ce.next();
					if(value.getStringCellValue().equalsIgnoreCase("Header"))
					{
						coloum = k;
					}
					k++;
				}
				System.out.println(coloum);

				//				Once coloumn is identified then scan entire Header coloumn to identify purchase testcase row
				while (rows.hasNext()) 
				{
					Row r = rows.next();
					if(r.getCell(coloum).getStringCellValue().equalsIgnoreCase(testCaseName))
					{
						//After you grab the purchase testcase row = pull all the data of that row and feed into test
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) 
						{
							Cell c = cv.next();
							if(c.getCellType()==CellType.STRING) {
								data.add(c.getStringCellValue());
							}
							else
							{
								data.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}

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
