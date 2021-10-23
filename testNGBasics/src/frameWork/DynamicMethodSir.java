package frameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DynamicMethodSir {

	static WebDriver driver = null;

	public static WebDriver openBrowser(String brName) {

		WebDriver driver = null;

		if ("chrome".equals(brName)) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if ("firefox".equals(brName)) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}

		return driver;

	}

	public static void openurl(WebDriver driver, String urlOpen) {
		driver.get(urlOpen);
	}

	public static void writeTextbox(WebDriver driver, String locType, String locValue, String data) {
		getElementasPerLocator(locType, locValue).sendKeys(data);
	}

	public static void ClickTo(WebDriver driver, String locType, String locValue) {
		getElementasPerLocator(locType, locValue).click();
	}

	private static WebElement getElementasPerLocator(String locatorName, String locValue) {
		WebElement we = null;
		switch (locatorName) {
		case "id":
			we = driver.findElement(By.id(locValue));
			break;
		case "xpath":
			we = driver.findElement(By.xpath(locValue));
			
			break;
		default:
			break;
		}
		return we;

	}

}
