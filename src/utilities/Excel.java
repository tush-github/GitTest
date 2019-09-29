package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Excel 
{
	public static HashMap<Integer, ArrayList<String>> getAllData(String SheetName) throws Exception{
		File file = new File("C:\\Users\\admin\\workspace\\HybridRummy\\src\\testData\\TestCase.xls");
		
		FileInputStream input = new FileInputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook(input);
		HSSFSheet sheet = workbook.getSheet(SheetName);
		
		int maxRows = sheet.getLastRowNum();
		System.out.println(maxRows);
		
		HashMap<Integer, ArrayList<String>> map = new HashMap<>();
		
		for(int i = 0; i <= maxRows; i++) {
			
			ArrayList<String> list = new ArrayList<>();
			
			HSSFRow row = sheet.getRow(i);
			
			int maxCells = row.getLastCellNum();
			//System.out.println("Row: " + i + " Cells: " + maxCells);
			for(int j = 0; j < maxCells; j++) {
				HSSFCell cell = row.getCell(j);
				list.add(cell.getStringCellValue());
			}
			map.put(i, list);
	}
		
		return map;
}
	public static HashMap<Integer, ArrayList<String>> getTestCaseData() throws Exception{
		File file = new File("C:\\Users\\admin\\workspace\\HybridRummy\\src\\testData\\TestCase.xls");
		
		FileInputStream input = new FileInputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook(input);
		HSSFSheet sheet = workbook.getSheet("TestCase");
		
		int maxRows = sheet.getLastRowNum();
		System.out.println(maxRows);
		
		HashMap<Integer, ArrayList<String>> map = new HashMap<>();
		
		for(int i = 0; i <= maxRows; i++) {
			ArrayList<String> list = new ArrayList<>();
			HSSFRow row = sheet.getRow(i);
			int maxCells = row.getLastCellNum();
			//System.out.println("Row: " + i + " Cells: " + maxCells);
			for(int j = 0; j < maxCells; j++) {
				HSSFCell cell = row.getCell(j);
				list.add(cell.getStringCellValue());
			}
			map.put(i, list);
	}
		
		return map;
	
}
}
