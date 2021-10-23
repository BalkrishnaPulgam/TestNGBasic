package com.testng;




import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class CommonSeleniumFunctions {
	
	
	static WebDriver driver = null;
	static ArrayList<String> list = new ArrayList<String>();

	CommonSeleniumFunctions(WebDriver driver) {
		this.driver = driver;
	}

	public static WebDriver openBrowser(String brName) {

		if ("chrome".equals(brName)) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		} else if ("firefox".equals(brName)) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.chrome.driver",  "chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;

	}

	public static void collectResult(String result, String fileName) throws BiffException, WriteException, IOException {

		list.add(result);
		System.out.println(list);
		int rowCount = getRowcount(fileName) - 1;
		if (list.size() == rowCount) {
			writeResult(fileName);
		}

	}

	public static void writeResult(String fileName) throws BiffException, IOException, WriteException {

		int rw = list.size();
		String resultColumnIndexSt = CommonSeleniumFunctions.getFileParameterValue("config1.properties",
				"resultColumnIndex");

		int resultColumnIndex = Integer.parseInt(resultColumnIndexSt);

		String newFileName = fileName + "_Executed.xls";

		Workbook workbook = Workbook.getWorkbook(new File(fileName));
		WritableWorkbook copy = Workbook.createWorkbook(new File(newFileName), workbook);
		WritableSheet sheet2 = copy.getSheet(0);

		for (int i = 1; i <= list.size(); i++) {

			WritableCell cell = sheet2.getWritableCell(resultColumnIndex, i);
			Label l = (Label) cell;
			l.setString(list.get(i - 1));
			l.setString(resultColumnIndexSt);

		}
		copy.write();
		copy.close();
		workbook.close();

	}

	
	private static Cell getResultCell(String filename, String TCNo) throws BiffException, IOException {

		FileInputStream ff = new FileInputStream(filename);
		Workbook workbook = Workbook.getWorkbook(ff);
		Sheet sheet = workbook.getSheet(0);
		return sheet.findCell(TCNo);

	}

	public static String getFileParameterValue(String fileName, String parameter) throws IOException {

		FileInputStream ff = new FileInputStream(fileName);
		Properties properties = new Properties();
		properties.load(ff);
		return properties.getProperty(parameter);

	}

	public static String[][] getSheetDataFromExcel(String fileName, String sheetName)
			throws BiffException, IOException {

		String[][] arrayExcelData = null;

		FileInputStream fs = new FileInputStream(fileName);
		Workbook wb = Workbook.getWorkbook(fs);
		Sheet sh = wb.getSheet(sheetName);

		int totalNoOfCols = sh.getColumns() - 1;
		int totalNoOfRows = sh.getRows();

		arrayExcelData = new String[totalNoOfRows - 1][totalNoOfCols];

		for (int i = 1; i < totalNoOfRows; i++) {

			for (int j = 0; j < totalNoOfCols; j++) {
				arrayExcelData[i - 1][j] = sh.getCell(j, i).getContents();
			}

		}
		return arrayExcelData;
	}

	private static int getRowcount(String fileName) throws BiffException, IOException {

		FileInputStream fs = new FileInputStream(fileName);
		Workbook wb = Workbook.getWorkbook(fs);
		Sheet sh = wb.getSheet(0);
		return sh.getRows();

	}
	
		

	public static void openurl(String urlOpen) {
		driver.get(urlOpen);
	}
	
	public static void closeBrowser(WebDriver driver) {
		driver.close();
	}

	public static void writeTextbox(String locType, String locValue, String data) {
		getElementasPerLocator(locType, locValue).sendKeys(data);
	}

	public static void ClickTo(String locType, String locValue) {
		getElementasPerLocator(locType, locValue).click();
	}
	
	public static String getText(String locType, String locValue) {

		return getElementasPerLocator(locType, locValue).getText();
	}

	private static WebElement getElementasPerLocator(String locType, String locValue) {
		WebElement we = null;
		switch (locType) {
		case "id":
			we = driver.findElement(By.id(locValue));
			break;
		case "xpath":
			we = driver.findElement(By.xpath(locValue));
			
			break;
		default:
			break;
		}
		return we;

	}

}
