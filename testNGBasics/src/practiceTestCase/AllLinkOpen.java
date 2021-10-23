package practiceTestCase;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllLinkOpen {

	private static String[] links = null;
	private static int linksCount = 0;

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/pages/examples/dashboard.html");

		List<WebElement> linksize = driver.findElements(By.xpath("//a[@class='small-box-footer']"));
		linksCount = linksize.size();
		System.out.println("Total no of links Available: " + linksCount);
		links = new String[linksCount];
		System.out.println("List of links Available: ");
		// print all the links from webpage
		for (int i = 0; i < linksCount; i++) {
			links[i] = linksize.get(i).getAttribute("href");
			linksize.get(i).click();
			System.out.println(linksize.get(i).getAttribute("href"));
		}
		// navigate to each Link on the webpage
		/*
		 * for (int i = 0; i < linksCount; i++) { driver.navigate().to(links[i]);
		 * Thread.sleep(3000);
		 * 
		 * }
		 */
	}

}
