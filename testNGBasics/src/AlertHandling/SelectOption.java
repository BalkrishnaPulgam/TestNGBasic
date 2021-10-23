package AlertHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectOption {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.com");
		WebDriver driver = new ChromeDriver();
		
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/pages/examples/add_user.html");
		driver.findElement(By.id("male")).click();
		
		
		
		
		
	}

}
