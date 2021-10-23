package frameWork;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class A {
			
	
	@Test
	public void VerifyBrowserLaunch() throws IOException {
		FileInputStream fis = new FileInputStream("config.properties");
		Properties properties = new Properties();
		properties.load(fis);		 
			
		WebDriver driver = SeleniumCommonFunctions.openBrowser(properties.getProperty("browser"));
		SeleniumCommonFunctions.openurl(driver, properties.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String act = SeleniumCommonFunctions.currenturl(driver);
		//String act = driver.getCurrentUrl();
		System.out.println("Actual: "+ act);
		String exp = properties.getProperty("expectedUrl");
		System.out.println("Expected: "+ exp);
		driver.close();
		Assert.assertEquals(act, exp);		
		}
	
	@Test 
	public void VerifyBrowserTitle() throws IOException {
		
		FileInputStream fis = new FileInputStream("config.properties");
		Properties properties = new Properties();
		properties.load(fis);
				
		WebDriver driver = SeleniumCommonFunctions.openBrowser(properties.getProperty("browser"));
		SeleniumCommonFunctions.openurl(driver, properties.getProperty("url"));
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
						
		WebDriver driver = SeleniumCommonFunctions.openBrowser(properties.getProperty("browser"));
		SeleniumCommonFunctions.openurl(driver, properties.getProperty("url"));
		SeleniumCommonFunctions.enterText(driver, "id", "email", properties.getProperty("userid"));
		SeleniumCommonFunctions.enterText(driver, "id", "password", properties.getProperty("userpass"));
		SeleniumCommonFunctions.clickButton(driver, "xpath", properties.getProperty("clickButtonXpath"));	
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
		
		WebDriver driver = SeleniumCommonFunctions.openBrowser(properties.getProperty("browser"));
		SeleniumCommonFunctions.openurl(driver, properties.getProperty("url"));
		SeleniumCommonFunctions.enterText(driver, "id", "email", properties.getProperty("Wrongid"));
		SeleniumCommonFunctions.enterText(driver, "id", "password", properties.getProperty("userpass"));
		SeleniumCommonFunctions.clickButton(driver, "xpath", properties.getProperty("clickButtonXpath"));
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
		
		WebDriver driver = SeleniumCommonFunctions.openBrowser(properties.getProperty("browser"));
		SeleniumCommonFunctions.openurl(driver, properties.getProperty("url"));
		SeleniumCommonFunctions.enterText(driver, "id", "email", properties.getProperty("userid"));
		SeleniumCommonFunctions.enterText(driver, "id", "password", "456");
		SeleniumCommonFunctions.clickButton(driver, "xpath",properties.getProperty("clickButtonXpath"));
		String act = SeleniumCommonFunctions.gettext(driver, "xpath", properties.getProperty("getTextPassEr"));
		System.out.println("Actual Suggestion: " + act );
		String exp = "Please enter password 123456";
		System.out.println("Expected Suggestion: " + exp);
		driver.close();
		Assert.assertEquals(act, exp);		
	}
	
	@Test 
	public void VerifyPlaceholderEmail() throws Exception {
		
		FileInputStream fis1 = new FileInputStream("config.properties");
		Properties properties = new Properties();
		properties.load(fis1);
		
		WebDriver driver =SeleniumCommonFunctions.openBrowser(properties.getProperty("browser"));
		SeleniumCommonFunctions.openurl(driver, properties.getProperty("url"));
		String act = SeleniumCommonFunctions.gettingValue(driver, "xpath",properties.getProperty("userIdXpath"), "placeholder");
		System.out.println("Actual Placeholder" + act);
		String exp = "Email";
		System.out.println("Expected Placeholder" + exp);
		driver.close();
		Assert.assertEquals(act, exp);
	}
	
	@Test
	public void VerifyPlaceholderPassword() throws Exception {	
		FileInputStream fis1 = new FileInputStream("config.properties");
		Properties properties = new Properties();
		properties.load(fis1);
		
		WebDriver driver = SeleniumCommonFunctions.openBrowser(properties.getProperty("browser"));
		SeleniumCommonFunctions.openurl(driver, properties.getProperty("url"));
		String act = SeleniumCommonFunctions.gettingValue(driver, "xpath", properties.getProperty("userIdXpath"), "placeholder");
		System.out.println("Actual Placeholder: "+act);
		String exp = "Password";
		System.out.println("Expected Placeholder: "+exp);
		driver.close();
		Assert.assertEquals(act, exp);
	
	}
	
	@Test
	public void checkErrorMsgOfEmail() throws Exception {
		
		FileInputStream fis1 = new FileInputStream("config.properties");
		Properties properties = new Properties();
		properties.load(fis1);
		
		WebDriver driver = SeleniumCommonFunctions.openBrowser(properties.getProperty("browser"));
		SeleniumCommonFunctions.openurl(driver, properties.getProperty("url"));
		SeleniumCommonFunctions.enterText(driver, "id", "email", "");
		SeleniumCommonFunctions.enterText(driver, "id", "password", properties.getProperty("userpass"));
		SeleniumCommonFunctions.clickButton(driver, "xpath", properties.getProperty("clickButtonXpath"));
		String act = SeleniumCommonFunctions.gettext(driver, "xpath",properties.getProperty("getTextEmailEr") );		
		System.out.println("Displayed Error: " + act);
		String exp = "Please enter email";
		System.out.println("Expected Error: " + exp);
		driver.close();
		Assert.assertEquals(act, exp);		
	}
	
	
}
