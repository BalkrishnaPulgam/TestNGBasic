package windowTabs;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class usingActionClass {

	// To open new tab using the robot class,
	public static void main(String[] args) throws AWTException {
		WebDriver driver = new ChromeDriver();

		System.setProperty("webriver.chrome.driver", "chromedriver.exe");

		driver.get("http://www.google.com");

		WebElement element = driver.findElement(By.linkText("Gmail"));
		Actions actionOpenLinkInNewTab = new Actions(driver);
		actionOpenLinkInNewTab.moveToElement(element).keyDown(Keys.CONTROL) // MacOS: Keys.COMMAND
				.keyDown(Keys.SHIFT).click(element).keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).perform();

		ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("http://www.yahoo.com");
		// driver.close();

	}

}
