package com.loginTestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenusingPOI {

	public void readExcell() throws IOException {
		//1)Read excell File
		
		FileInputStream excell = new FileInputStream("C:\\Users\\Luman\\Desktop\\Book1.xls");
		Workbook workbookk = new XSSFWorkbook(excell);
		
		Sheet sheet  = workbookk.getSheet("Sheet2");// or getsheeetat(0)
		
		//2) iterator
		
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Row rowValue = rowIterator.next();
			
			Iterator<Cell> coloumnIterator = rowValue.iterator();
			while (coloumnIterator.hasNext()) {
				Cell columnValue = coloumnIterator.next();
				System.out.println("columnValue ==" + columnValue);
				System.out.println(columnValue);
			}
			
		}

	}
	public static void main(String[] args) throws IOException {
	DataDrivenusingPOI  usingggpoi = new DataDrivenusingPOI();
		usingggpoi.readExcell();
		
		
		
	}

}
