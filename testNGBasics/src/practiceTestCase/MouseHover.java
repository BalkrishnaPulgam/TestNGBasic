package practiceTestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.guru99.com/top-100-selenium-interview-questions-answers.html");
		
		Thread.sleep(42000);
		
	WebElement move =driver.findElement(By.xpath("//*[@id=\"post-1087\"]/div/div/ul[1]/li[10]"));
		
		Actions action =new Actions(driver);
		
		action.moveToElement(move).perform();
		
	}

}
