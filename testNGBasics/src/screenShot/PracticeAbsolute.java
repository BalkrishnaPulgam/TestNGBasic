package screenShot;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeAbsolute {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.goibibo.com/flights/air-PNQ-NAG-20210923--1-0-0-E-D/?exp=v1");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div[1]/div/div/div[11]/div/div[2]/div[2]/div[1]/label/span[1]")).click();
		Thread.sleep(3000);
	List<WebElement> flightCount=driver.findElements(By.xpath("//div[@style='min-height: 110px;']"));
	System.out.println("Available IndiGo Flight count= "+flightCount.size());
		
	}

}
