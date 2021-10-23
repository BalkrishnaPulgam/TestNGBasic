package practiceTestCase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.testng.CommonSeleniumFunctions;

import frameWork.SeleniumCommonFunctions;

public class WindowHandling {
	
	WebDriver driver=null;
	
	@Test
	public void window() throws IOException {
		String Brname=CommonSeleniumFunctions.getFileParameterValue("Config.properties", "browser");
		String url=CommonSeleniumFunctions.getFileParameterValue("Config.properties", "url");
		CommonSeleniumFunctions.openBrowser(Brname);
		CommonSeleniumFunctions.openurl(url);
	//	CommonSeleniumFunctions.writeTextbox("id", "email", CommonSeleniumFunctions.getFileParameterValue("Config.properties", "userid");
		
	}
	

}
