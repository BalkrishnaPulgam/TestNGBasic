package windowTabs;

import java.awt.AWTException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowHandle {
	public static void main(String[] args) throws AWTException {
		WebDriver driver = new ChromeDriver();

		System.setProperty("webriver.chrome.driver", "chromedriver (2).exe");

		driver.get("file:/E:/Selenium/Offline%20Website/Offline%20Website/pages/examples/dashboard.html");

		WebElement element = driver.findElement(By.xpath("//h3[text()='Selenium']//parent::div//following-sibling::a"));
		element.click();
	//	Actions actionOpenLinkInNewTab = new Actions(driver);
	//	actionOpenLinkInNewTab.moveToElement(element).keyDown(Keys.CONTROL) // MacOS: Keys.COMMAND
    //			.keyDown(Keys.SHIFT).click(element).keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).perform();

		ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("http://www.yahoo.com");
		// driver.close();

}
}