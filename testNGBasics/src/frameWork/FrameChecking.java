package frameWork;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameChecking {
	
	
	
	@Test
	public void VerifyBrowserLaunch() throws IOException {
		FileInputStream fis = new FileInputStream("config.properties");
		Properties properties = new Properties();
		properties.load(fis);
		String brType = properties.getProperty("browser");
		String url = properties.getProperty("url");
		String expUrl = properties.getProperty("expectedUrl");
		System.out.println(expUrl);
		
		WebDriver driver = SeleniumCommonFunctions.openBrowser(brType);
		SeleniumCommonFunctions.openurl(driver, url);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String act = SeleniumCommonFunctions.currenturl(driver);
		//String act = driver.getCurrentUrl();
		System.out.println("Actual: "+ act);
		String exp = expUrl;
		System.out.println("Expected: "+ exp);
		driver.close();
		Assert.assertEquals(act, exp);		
		}
	
	@Test 
	public void VerifyBrowserTitle() throws IOException {
		FileInputStream fis = new FileInputStream("config.properties");
		Properties properties = new Properties();
		properties.load(fis);
		String brType = properties.getProperty("browser");
		String url = properties.getProperty("url");
		
		WebDriver driver = SeleniumCommonFunctions.openBrowser(brType);
		SeleniumCommonFunctions.openurl(driver, url);
		String act= driver.getTitle();
		System.out.println("Actual Browser Title: "+act);
		String exp = "JavaByKiran | Log in";
		System.out.println("Expected Browser Title "+exp);
		driver.close();
		Assert.assertEquals(act, exp);
	   }
	
	@Test
	public void loginChecking() throws IOException {
		
		FileInputStream fis1 = new FileInputStream("config.properties");
		Properties properties = new Properties();
		properties.load(fis1);
		String brType = properties.getProperty("browser");
		String url = properties.getProperty("url");
		//String xpathvalue = properties.getProperty("clickButtonXpath");
		String xpathvalue = properties.getProperty("clickButtonXpath");
		System.out.println(xpathvalue);
		String userEmail=properties.getProperty("userid");
		System.out.println(userEmail);
		String userPassword=properties.getProperty("userpass");
		System.out.println(userPassword);
		
				
		WebDriver driver = SeleniumCommonFunctions.openBrowser(brType);
		SeleniumCommonFunctions.openurl(driver, url);
		SeleniumCommonFunctions.enterText(driver, "id", "email", userEmail);
		SeleniumCommonFunctions.enterText(driver, "id", "password", userPassword);
		System.out.println(xpathvalue);
		SeleniumCommonFunctions.clickButton(driver, "xpath", xpathvalue);	
		//String act = SeleniumCommonFunctions.titleName(driver);
		String act = driver.getTitle();
		System.out.println("Actual Page:"+act);
		String exp ="JavaByKiran | Dashboard";
		System.out.println("Expected Page:"+exp);
		driver.close();
		Assert.assertEquals(act, exp);
				
	}	
	
	@Test
	public void checkErrorMsgColor() throws Exception {
		FileInputStream fis1 = new FileInputStream("config.properties");
		Properties properties = new Properties();
		properties.load(fis1);
		String brType = properties.getProperty("browser");
		String url = properties.getProperty("url");
		String wrongId = properties.getProperty("Wrongid");
		String userPassword=properties.getProperty("userpass");
		String xpathvalue = properties.getProperty("clickButtonXpath");
		
		
		WebDriver driver = SeleniumCommonFunctions.openBrowser(brType);
		SeleniumCommonFunctions.openurl(driver, url);
		SeleniumCommonFunctions.enterText(driver, "id", "email", wrongId);
		SeleniumCommonFunctions.enterText(driver, "id", "password", userPassword);
		SeleniumCommonFunctions.clickButton(driver, "xpath", xpathvalue);
		String act = SeleniumCommonFunctions.gettingValue(driver, "xpath", "//*[@id=\"password_error\"]", "style");
		System.out.println("Actual clr = " + act);
		String exp = "color: red;";
		System.out.println("Expected clr = " + exp);
		driver.close();
		Assert.assertEquals(act, exp);
	}
	
	@Test
	public void passwordSuggestion() throws Exception {
		FileInputStream fis1 = new FileInputStream("config.properties");
		Properties properties = new Properties();
		properties.load(fis1);
		String brType = properties.getProperty("browser");
		String url = properties.getProperty("url");
		String userEmail=properties.getProperty("userid");
		String xpathvalue = properties.getProperty("clickButtonXpath");
		
		WebDriver driver = SeleniumCommonFunctions.openBrowser(brType);
		SeleniumCommonFunctions.openurl(driver, url);
		SeleniumCommonFunctions.enterText(driver, "id", "email", userEmail);
		SeleniumCommonFunctions.enterText(driver, "id", "password", "456");
		SeleniumCommonFunctions.clickButton(driver, "xpath",xpathvalue);
		String act = SeleniumCommonFunctions.gettext(driver, "xpath", "//*[@id=\"password_error\"]");
		System.out.println("Actual Suggestion: " + act );
		String exp = "Please enter password 123456";
		System.out.println("Expected Suggestion: " + exp);
		driver.close();
		Assert.assertEquals(act, exp);		
	}
	
	
	@Test 
	public void VerifyPlaceholderEmail() {
		WebDriver driver =SeleniumCommonFunctions.openBrowser("chromedriver.exe");
		SeleniumCommonFunctions.openurl(driver, "file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");
		String act = SeleniumCommonFunctions.gettingValue(driver, "xpath", "//*[@id=\"email\"]", "placeholder");
		System.out.println("Actual Placeholder" + act);
		String exp = "Email";
		System.out.println("Expected Placeholder" + exp);
		driver.close();
		Assert.assertEquals(act, exp);
	}
	
	@Test
	public void VerifyPlaceholderPassword() {						
		WebDriver driver = SeleniumCommonFunctions.openBrowser("chromedriver.exe");
		SeleniumCommonFunctions.openurl(driver, "file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");
		String act = SeleniumCommonFunctions.gettingValue(driver, "xpath", "//*[@id=\"password\"]", "placeholder");
		System.out.println("Actual Placeholder: "+act);
		String exp = "Password";
		System.out.println("Expected Placeholder: "+exp);
		driver.close();
		Assert.assertEquals(act, exp);
	
	}
	
		
	@Test	
	public void VerifyInputType() {
		WebDriver driver = SeleniumCommonFunctions.openBrowser("chromedriver.exe");
		SeleniumCommonFunctions.openurl(driver, "file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");
		String act = SeleniumCommonFunctions.gettingValue(driver, "id", "email", "type");
		System.out.println("Actual Input Type" + act);
		String exp = "text";
		System.out.println("Expected Input Type" + exp);
		driver.close();
		Assert.assertEquals(act, exp);		
	}
	
	
	@Test
	public void checkErrorMsgOfEmail() {
		WebDriver driver = SeleniumCommonFunctions.openBrowser("chromedriver.exe");
		SeleniumCommonFunctions.openurl(driver, "file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");
		SeleniumCommonFunctions.enterText(driver, "id", "email", "");
		SeleniumCommonFunctions.enterText(driver, "id", "password", "123456");
		SeleniumCommonFunctions.clickButton(driver, "xpath", "//*[@id=\"form\"]/div[3]/div/button");
		String act = SeleniumCommonFunctions.gettext(driver, "xpath", "//*[@id=\"email_error\"]");		
		System.out.println("Displayed Error: " + act);
		String exp = "Please enter email";
		System.out.println("Expected Error: " + exp);
		driver.close();
		Assert.assertEquals(act, exp);		
	}
	
/*	@Test
	public void VerifyingLogo() {
		WebDriver driver = SeleniumCommonFunctions.openBrowser("chromedriver.exe");
		SeleniumCommonFunctions.openurl(driver, "file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");
		boolean act = SeleniumCommonFunctions.checkingDisplay(driver, "xpath", "//*[@id=\"email\"]");
		
		
	//	boolean act = driver.findElement(By.xpath("/html/body/div/center/img")).isDisplayed();
		Assert.assertEquals(act, true);
	}
	
	*/

}
