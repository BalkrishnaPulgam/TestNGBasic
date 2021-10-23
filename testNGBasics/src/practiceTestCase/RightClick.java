package practiceTestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

public class RightClick {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		 driver.get("http://javabykiran.com/playground/");

		
		  WebElement ele=driver.findElement(By.linkText("UPDATE User"));
		  Actions action = new Actions(driver);
		  action.moveToElement(ele).contextClick().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).
		  build().perform();
		  
		  
	
	}

}
