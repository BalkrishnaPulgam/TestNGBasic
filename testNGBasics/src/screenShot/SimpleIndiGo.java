package screenShot;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleIndiGo {
	
	
	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "E:/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		// Source input
		

		driver.findElement(By.id("gosuggest_inputSrc")).click();

		WebElement from = driver.findElement(By.id("gosuggest_inputSrc"));
		Thread.sleep(1500);
		from.sendKeys("Pune");
		Thread.sleep(1500);
		from.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1500);
		from.sendKeys(Keys.ENTER);

		// Destination selection
		Thread.sleep(1500);
		driver.findElement(By.id("gosuggest_inputDest")).click();
		WebElement to = driver.findElement(By.id("gosuggest_inputDest"));
		Thread.sleep(1500);
		to.sendKeys("Nagpur");
		Thread.sleep(1500);
		to.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1500);
		to.sendKeys(Keys.ENTER);

		Thread.sleep(3000); // */ /*
		
		driver.findElement(By.xpath("//input[@id='departureCalendar']")).click();

		driver.findElement(By.xpath("//div[@id='fare_20210922']")).click();

		Thread.sleep(2000);

		// search button
		driver.findElement(By.id("gi_search_btn")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"//div[text()='Preferred Airlines']//following::span[text()='IndiGo']//ancestor::span[1]//preceding-sibling::span"))
				.click();
		Thread.sleep(3000);
		List<WebElement> flightCount = driver.findElements(By.xpath("//div[@style='min-height: 110px;']"));
		System.out.println("Available IndiGo Flight count= " + flightCount.size());

	}

}
