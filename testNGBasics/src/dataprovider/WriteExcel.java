package dataprovider;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class WriteExcel {
	
	public static void main(String[] args) throws IOException {
		
       	
    	
        //1. Create an Excel file
        WritableWorkbook myFirstWbook = null;
        try {

            myFirstWbook = Workbook.createWorkbook(new File("D:\\StudyURL\\MyFirstExcel.xls"));

            // create an Excel sheet
            WritableSheet excelSheet = myFirstWbook.createSheet("Sheet 1", 2);
             
			/*
			 * if(strData.equalsIgnoreCase("TC ID")) { WritableFont cellFont = new
			 * WritableFont(WritableFont.TIMES, 12); cellFont.setColour(Colour.GREEN);
			 * cellFont.setBoldStyle(WritableFont.BOLD);
			 * 
			 * WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
			 * cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN); }
			 */
            

            // add something into the Excel sheet
            Label label = new Label(0, 0, "TC ID");
            excelSheet.addCell(label);

            
            label = new Label(0, 1, "TC001");
            excelSheet.addCell(label);
            label = new Label(0, 2, "TC002");
            excelSheet.addCell(label);
            label = new Label(0, 3, "TC003");
            excelSheet.addCell(label);
            label = new Label(0, 4, "TC004");
            excelSheet.addCell(label);
            label = new Label(0, 5, "TC005");
            excelSheet.addCell(label);

            label = new Label(1, 0, "testDesc");
            excelSheet.addCell(label);

            label = new Label(1, 1, "blank username");
            excelSheet.addCell(label);
            label = new Label(1, 2, "blank password");
            excelSheet.addCell(label);
            label = new Label(1, 3, "invalid username");
            excelSheet.addCell(label);
            label = new Label(1, 4, "invalid password");
            excelSheet.addCell(label);
            label = new Label(1, 5, "valid");
            excelSheet.addCell(label);
            
            label = new Label(2, 0, "Uname");
            excelSheet.addCell(label);
            
            label = new Label(2, 1, "");
            excelSheet.addCell(label);
            label = new Label(2, 2, "kiran@gmail.com");
            excelSheet.addCell(label);
            label = new Label(2, 3, "ki@gmail.com");
            excelSheet.addCell(label);
            label = new Label(2, 4, "kiran@gmail.com");
            excelSheet.addCell(label);
            label = new Label(2, 5, "kiran@gmail.com");
            excelSheet.addCell(label);

            
            label = new Label(3, 0, "Passwd");
            excelSheet.addCell(label);
            label = new Label(3, 1, "123456");
            excelSheet.addCell(label);
            label = new Label(3, 2, "");
            excelSheet.addCell(label);
            label = new Label(3, 3, "123456");
            excelSheet.addCell(label);
            label = new Label(3, 4, "46589");
            excelSheet.addCell(label);
            label = new Label(3, 5, "123456");
            excelSheet.addCell(label);
            
            
            label = new Label(4, 0, "expresult");
            excelSheet.addCell(label);
            label = new Label(4, 1, "Please enter email");
            excelSheet.addCell(label);
            label = new Label(4, 2, "Please enter password.");
            excelSheet.addCell(label);
            label = new Label(4, 3, "Please enter email as kiran@gmail.com");
            excelSheet.addCell(label);
            label = new Label(4, 4, "Please enter password 123456");
            excelSheet.addCell(label);
            label = new Label(4, 5, "JavaByKiran | Dashboard");
            excelSheet.addCell(label);
                        
            
            myFirstWbook.write();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        } finally {

            if (myFirstWbook != null) {
                try {
                    myFirstWbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (WriteException e) {
                    e.printStackTrace();
                }
            }


        }

    }

}
