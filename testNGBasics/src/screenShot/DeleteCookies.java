package screenShot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DeleteCookies {
	
	
	@Test
	public void deleteCookieNamedExample()
	{
		WebDriver  driver = new ChromeDriver();
		String URL="file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html";
		driver.navigate().to(URL);
		driver.manage().deleteAllCookies();
	}

}
