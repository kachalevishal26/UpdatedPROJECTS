package com.vk.dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataSupplier {

//	public static void main(String[] args) throws Exception   {
	@DataProvider(name = "loginData")
	@Test
	public String[][] getData() throws Exception {

		File excelFile = new File("./src/test/resources/Test.xlsx");
		FileInputStream fis = new FileInputStream(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int noOfRows = sheet.getPhysicalNumberOfRows();
		int noOfColumns = sheet.getRow(0).getLastCellNum();

		String[][] data = new String[noOfRows-1][noOfColumns];
		
		for (int i = 0; i < noOfRows-1; i++) {
			for (int j = 0; j < noOfColumns; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
//				System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());	
			}
			System.out.println();
		}
		workbook.close();
		fis.close();
		
		return data;
//		for (String[] dataArr: data) {
//			System.out.println(Arrays.toString(dataArr));
//		}
	}
}