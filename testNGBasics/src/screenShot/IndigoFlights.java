package screenShot;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class IndigoFlights {

	public static void main(String[] args) {

		 System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		    WebDriver driver = new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//driver.findElement(By.id("gosuggest_inputSrc")).click();
		
		WebElement sel = driver.findElement(By.id("gosuggest_inputSrc"));
		Select select = new Select(sel);
		select.selectByValue("Pune");

		System.out.println(22);
		// Select destination
		driver.findElement(By.id("gosuggest_inputDest")).click();
		driver.findElement(By.id("gosuggest_inputSrc")).sendKeys("Nagpur");
		WebElement sel1 = driver.findElement(By.id("gosuggest_inputSrc"));
		Select select1 = new Select(sel1);
		select1.selectByValue("Nagpur");

		driver.findElement(By.id("departureCalendar")).sendKeys("20/09");

	}

}
