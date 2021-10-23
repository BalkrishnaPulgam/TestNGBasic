package frameWork;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class B {
	
	
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
		
		WebDriver driver = SeleniumCommonFunctions.openBrowser(brType);
		SeleniumCommonFunctions.openurl(driver, url);
		SeleniumCommonFunctions.enterText(driver, "id", "email", "kiran@gmail.com");
		SeleniumCommonFunctions.enterText(driver, "id", "password", "123456");
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

}
