package practiceTestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseAction {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();

		WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
		search.sendKeys("laptop");
		search.sendKeys(Keys.ARROW_DOWN);
		search.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Processor selection
		driver.findElement(By.xpath("//div[contains(text(),'Processor')]//following::div[@title='Core i5']//input[@type='checkbox']")).click();
		
		 //Brand selection
        driver.findElement(By.xpath("//div[contains(text(),'Brand')]//following::div[@title='HP']//input[@type='checkbox']")).click();
        
        //Customer rating selection
        driver.findElement(By.xpath("//div[contains(text(),'Customer Ratings')]//following::div[@class='_4921Z t0pPfW']//input[@type='checkbox']")).click();
        
        //price selection
        driver.findElement(By.xpath("//div[contains(text(),'Price -- Low to High')]")).click();

	}

}
