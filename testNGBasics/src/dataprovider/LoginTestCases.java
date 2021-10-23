package dataprovider;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.CellType;
import jxl.LabelCell;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class LoginTestCases {

	@Test(dataProvider = "loginData")
	public void blankUnameTest(String tcId, String testDesc, String uname, String passwd, String expResult) {

		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(passwd);
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
		String actResult = "";

		if ("blank username".equals(testDesc)) {
			actResult = driver.findElement(By.id("email_error")).getText();
			
		} else if ("blank password".equals(testDesc)) {
			actResult = driver.findElement(By.id("password_error")).getText();
			
		} else if ("invalid username".equals(testDesc)) {
			actResult = driver.findElement(By.id("email_error")).getText();
			
		} else if ("invalid password".equals(testDesc)) {
			actResult = driver.findElement(By.id("password_error")).getText();
			
		} else
			actResult = driver.getTitle();
		//TestCase="Pass";

		String exp1Result = expResult;
		Assert.assertEquals(actResult, exp1Result);
		driver.close();

	
	
	}

	@DataProvider
	public Object[][] loginData() throws Exception {
		/*
		 * return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" }, };
		 */

		return UtilityExcel.getExcelData("LoginData.xls", "Sheet1");
	}
	
}
