package windowTabs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowTab {
	
	// using action class
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		System.setProperty("webriver.chrome.driver", "chromedriver.exe");
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/pages/examples/dashboard.html");
		
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='small-box-footer'][1]")).sendKeys(selectLinkOpeninNewTab);
	 
		
	}

}
