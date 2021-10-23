package screenShot;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BB {
	
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		//Source input
	//	driver.findElement(By.id("//*[@id=\"root\"]/div[1]/header/ul/li[1]/a")).click();
		
		driver.findElement(By.id("gosuggest_inputSrc")).click();
		
		WebElement from= driver.findElement(By.xpath("//*[@id=\"gosuggest_inputSrc\"]"));
		Thread.sleep(1500);
		from.sendKeys("Pune");
		Thread.sleep(1500);
		from.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1500);
		from.sendKeys(Keys.ENTER);
		
		//Destination selection
		Thread.sleep(1500);
		driver.findElement(By.id("gosuggest_inputDest")).click();
		WebElement to=driver.findElement(By.id("gosuggest_inputDest"));
		Thread.sleep(1500);
		to.sendKeys("Nagpur");
		Thread.sleep(1500);
		to.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1500);
		to.sendKeys(Keys.ENTER);
		
		Thread.sleep(1500);  //  */  /*
		
		driver.findElement(By.id("departureCalendar")).click();
		Thread.sleep(2000);
		List<WebElement> dateList=driver.findElements(By.className("calDate"));
		
		int count=dateList.size();
		
		for(int i=0; i<count; i++) {
			String text=driver.findElements(By.className("calDate")).get(i).getText();
			System.out.println("text is"+text);
			if(text.equalsIgnoreCase("14")) {
				driver.findElements(By.className("calDate")).get(i).click();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		//search button
		driver.findElement(By.id("gi_search_btn")).click();
		Thread.sleep(2000);
	}
}
