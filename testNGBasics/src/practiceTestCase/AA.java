package practiceTestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AA {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.flipkart.com/search?q=laptop&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off");
		Thread.sleep(3000);

		 WebElement processor=driver.findElement(By.xpath("//div[text()='Processor']"));
		        WebDriverWait wait = new WebDriverWait(driver, 20);
		        wait.until(ExpectedConditions.visibilityOf(processor));
		
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
