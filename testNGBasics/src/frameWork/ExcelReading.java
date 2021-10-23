package frameWork;

import java.io.FileInputStream;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelReading {
	
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("Book1.xls");
		Workbook workbook = Workbook.getWorkbook(fis);
		Sheet sheet = workbook.getSheet("Sheet1");
		Cell cell = sheet.getCell("B8");
		String val = cell.getContents();
		System.out.println(val);
		System.out.println("-------------");
		int rowCount = sheet.getRows();
		System.out.println("Total number of rows preset in the sheet "+rowCount);
		int colCount = sheet.getColumns();
		System.out.println("Total number of columns preset in the sheet "+colCount);
		
		System.out.println("-------------");
		
		for(int i=0; i<colCount; i++) {
			for(int j=0; j<rowCount; j++) {
				Cell a =sheet.getCell(i, j);
				
				String n=a.getContents();
				System.out.println(n+"    ");
				
			}
			System.out.println("-------------");
		}
		
		
		
		
		
		
		
	}

}
