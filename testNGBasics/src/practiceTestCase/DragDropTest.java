package practiceTestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDropTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://javabykiran.com/playground/drag-and-drop");

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		WebElement from = driver.findElement(By.xpath("//div[text()='Home ']"));
		WebElement to = driver.findElement(By.xpath("//div[text()='Contact Us']"));
		Thread.sleep(2000);

		Actions act = new Actions(driver);
		act.clickAndHold(from).perform();
		act.dragAndDrop(from, to).build().perform();
	}

}
