package practiceTestCase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A {
	
	// All links open by simple method
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/pages/examples/dashboard.html");

		List<WebElement> linksize = driver.findElements(By.xpath("//a[@class='small-box-footer']"));
		
		System.out.println("Total no of links Available: " + linksize.size());
		
		int size =linksize.size();
		
		for(int i=0; i<size; i++) {
			linksize.get(i).click();
			String links=linksize.get(i).getAttribute("href");
			System.out.println(links);
		
		}
		
		
	}

}
