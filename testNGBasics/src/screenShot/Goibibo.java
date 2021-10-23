package screenShot;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Goibibo {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.goibibo.com/hotels/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[@class='SearchBlockUIstyles__RadioButtonWrap-sc-fity7j-4 eEVxPE'][1]//input")).click();
		
		WebElement from=driver.findElement(By.xpath("//input[@placeholder='e.g. - Area, Landmark or Hotel Name']"));
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		from.sendKeys("pune");
		from.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(3000);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		from.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//input[@type='text']")).click();
		driver.findElement(By.xpath("//span[text()='Guests & Rooms']//following::span[4]")).click();
		driver.findElement(By.xpath("//span[text()='Guests & Rooms']//following::span[8]")).click();
		
	}

}
