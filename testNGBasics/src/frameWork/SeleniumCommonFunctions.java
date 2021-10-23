package frameWork;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class SeleniumCommonFunctions {

	public static WebDriver openBrowser(String brName) {

		WebDriver driver = null;

		if ("chrome".equals(brName)) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if ("firefox".equals(brName)) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}

		return driver;

	}

	/**
	 * @param driver
	 * @param urlOpen This method is used to open a browser for any website
	 */
	public static void openurl(WebDriver driver, String urlOpen) {
		driver.get(urlOpen);
	}
	
	
	public static void enterText(WebDriver driver, String locname, String locvalue, String dataToEnter) {

		if ("id".equals(locname)) {
			driver.findElement(By.id(locvalue)).sendKeys(dataToEnter);
		}
		if ("xpath".equals(locname)) {
			driver.findElement(By.xpath(locvalue)).sendKeys(dataToEnter);
		}
	}
	
	  public static void clickButton(WebDriver driver, String locname, String
	  locvalue) { driver.findElement(By.xpath(locvalue)).click(); }
	 

	public static String gettext(WebDriver driver, String locname, String locvalue) {

		return driver.findElement(By.xpath(locvalue)).getText();
	}

	public static String titleName(WebDriver driver) {
		return driver.getTitle();
	}

	public static String gettingValue(WebDriver driver, String locname, String locvalue, String attributeName) {
		String attributeValu = "";
		if ("id".equals(locname)) {
			attributeValu = driver.findElement(By.id(locvalue)).getAttribute(attributeName);
		}
		if ("xpath".equals(locname)) {
			attributeValu = driver.findElement(By.xpath(locvalue)).getAttribute(attributeName);
		}
		return attributeValu;

	}

	public static String currenturl(WebDriver driver) {

		return driver.getCurrentUrl();
	}
	
	public static String getFileParameter(String filename, String Parameter) throws IOException {
		
		FileInputStream fis = new FileInputStream(filename);
		Properties properties = new Properties();
		properties.load(fis);
		return properties.getProperty(Parameter);
		
	}
	
	  public static boolean checkingDisplay(WebDriver driver, String locname,
	  String locvalue) { 
	driver.findElement(By.xpath(locvalue)).isDisplayed();
	  return true;
	  }
	 
}