package screenShot;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class CheckingCopyPaste {
	
	 public static void main(String[] args) {
		 
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html#");
			 WebElement locOfOrder = driver.findElement(By.xpath("//body//*[text()='Sign in to start your session']"));
			 Actions act = new Actions(driver);
			 act.moveToElement(locOfOrder).doubleClick().build().perform();
		 
			// now apply copy command
			 // driver.findElement(By.xpath("//body//*[text()='Sign in to start your session']")).getText();
			driver.findElement(By.xpath("//body//*[text()='Sign in to start your session']")).sendKeys(Keys.chord(Keys.CONTROL,"c"));
			// now apply the command to paste
			 driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(Keys.chord(Keys.CONTROL,"v"));
			 
		 } 

}
