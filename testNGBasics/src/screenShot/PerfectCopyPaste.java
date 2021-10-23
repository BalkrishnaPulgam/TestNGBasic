package screenShot;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PerfectCopyPaste {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");

		driver.manage().window().maximize();

		WebElement locOfOrder = driver.findElement(By.xpath("//body//*[text()='Sign in to start your session']"));

		Actions act = new Actions(driver);

		// catch here is double click on the text will by default select the text
		act.contextClick(locOfOrder).doubleClick(locOfOrder).click().perform();
		
		//act.contextClick(locOfOrder).doubleClick().build().perform();
		
		Thread.sleep(1500);
		// now apply copy command
		act.keyDown(Keys.CONTROL).sendKeys("c").perform();

		System.out.println("LOC TEST:" + locOfOrder.getText());

		// now apply the command to paste
		driver.findElement(By.xpath("//input[@id='email']")).click();
		
		act.keyDown(Keys.CONTROL).sendKeys("v").perform();
		Thread.sleep(1500);
		driver.close();

	}
}
