package screenShot;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class CheckCopyPaste {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");
		WebElement locOfOrder = driver.findElement(By.xpath("/html/body/div/div[2]/p"));
		Actions act = new Actions(driver);
		act.moveToElement(locOfOrder).doubleClick().click().perform();

		// now apply copy command
		//String mycopytext = driver.findElement(By.xpath("/html/body/div/div[2]/p")).getText();

		 driver.findElement(By.xpath("/html/body/div/div[2]/p")).sendKeys(Keys.chord(Keys.CONTROL,"c"));
		// now apply the command to paste
		driver.findElement(By.id("email")).sendKeys(Keys.chord(Keys.CONTROL,"v"));

	}
}
