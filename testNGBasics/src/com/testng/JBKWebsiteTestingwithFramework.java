package com.testng;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class JBKWebsiteTestingwithFramework {

	WebDriver driver = null;
	SoftAssert softAssert = new SoftAssert();

	@BeforeMethod
	public void invokeBrowser() throws IOException {
		String browserName = CommonSeleniumFunctions.getFileParameterValue("config1.properties", "browser");
		driver = CommonSeleniumFunctions.openBrowser(browserName);
	}

	@DataProvider
	public Object[][] loginDataProvider() throws BiffException, IOException {
		String testInputFile = CommonSeleniumFunctions.getFileParameterValue("config1.properties", "testInputFile");
		String testInputSheet = CommonSeleniumFunctions.getFileParameterValue("config1.properties", "testInputSheet");

		Object[][] arrayObject = CommonSeleniumFunctions.getSheetDataFromExcel(testInputFile, testInputSheet);
		return arrayObject;
	}

	@Test(dataProvider = "loginDataProvider", description = "Verify login functionality")
	public void testLoginCredentials_TC007(String TCNo, String desc, String expEmail, String expPassword,
			String ExpEmailErrMsg, String ExpPasswordErrMsg) throws IOException, BiffException, WriteException {

		String JBKURL = CommonSeleniumFunctions.getFileParameterValue("config1.properties", "JBKURL");
		String useId = CommonSeleniumFunctions.getFileParameterValue("config1.properties", "userid");
		String userpass = CommonSeleniumFunctions.getFileParameterValue("config1.properties", "userpass");
		String clickButtonXpath = CommonSeleniumFunctions.getFileParameterValue("config1.properties",
				"clickButtonXpath");
		

		CommonSeleniumFunctions.openurl(JBKURL);
		CommonSeleniumFunctions.writeTextbox("id", "email",useId );
		System.out.println(1);
		CommonSeleniumFunctions.writeTextbox("xpath", "//*[@id=\"password\"]", userpass);
		CommonSeleniumFunctions.ClickTo("xpath", clickButtonXpath);

		
		try {
			if (!"Correct".equals(desc)) {
				String actemail_error = CommonSeleniumFunctions.getText("id", "email_error");
				String actpassword_error = CommonSeleniumFunctions.getText("id", "password_error");
				CommonSeleniumFunctions.closeBrowser(driver);
				Assert.assertEquals(actemail_error, ExpEmailErrMsg);
				softAssert.assertEquals(actpassword_error, ExpPasswordErrMsg);

			} else {
				String actTitle = driver.getTitle();
				CommonSeleniumFunctions.closeBrowser(driver);
				Assert.assertEquals(actTitle, ExpEmailErrMsg);
			}

			CommonSeleniumFunctions.collectResult("PASS", "E:\\Selenium\\chromedriver\\Test_Plan.xls");
			System.out.println(TCNo);
		} catch (Error e) {

			CommonSeleniumFunctions.collectResult("FAIL", "E:\\Selenium\\chromedriver\\Test_Plan.xls");

		}
		// CommonSeleniumFunctions.WriteTCResult("C:\\chromedriver\\Test_Plan.xls",
		// TCNo);
	}

}
