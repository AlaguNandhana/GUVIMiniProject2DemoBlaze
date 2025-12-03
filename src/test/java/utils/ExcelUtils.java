package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils {
	
	public static Object[][] getTestData(String filepath,String sheetName) throws IOException{
		 
		
		try(FileInputStream file  = new FileInputStream(filepath);
				Workbook workbook = new XSSFWorkbook(file)) {
			
			Sheet sheet = workbook.getSheet(sheetName);
			int rows = sheet.getPhysicalNumberOfRows();
			int cols = sheet.getRow(0).getPhysicalNumberOfCells();
			
			Object[][] data = new Object[rows-1][cols];
			
			for (int i=1;i<rows;i++) {
				Row row = sheet.getRow(i);
				for (int j=0;j<cols;j++) {
					Cell cell = row.getCell(j);
					data [i-1][j] = (cell == null) ? "" : cell.toString();
				}
			}
			return data;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;		
		}	
	}
}
