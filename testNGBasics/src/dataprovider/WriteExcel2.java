package dataprovider;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.demo.Write;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class WriteExcel2 {
	
	public static void main(String[] args) throws Exception {
		
		File file = new File("D:\\\\StudyURL\\\\MyFirstExcel.xls");
		WritableWorkbook wb= Workbook.createWorkbook(file);
		WritableSheet sheet =wb.createSheet("Practice", 1);
		
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(i==j) {
					Label label = new Label(i, j, "Pass");
					sheet.addCell(label);
				}


			}
		}
		
		wb.write();
		wb.close();
		System.out.println("Workbook Created Successfully");
		
	}

}
