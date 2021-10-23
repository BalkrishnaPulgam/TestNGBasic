package practiceTestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class B {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		 driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/pages/examples/logout.html#");

		  WebElement ele=driver.findElement(By.linkText("Register a new membership"));
		  Actions action = new Actions(driver);
		  action.moveToElement(ele).contextClick().perform();
		  action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	}
	
}
