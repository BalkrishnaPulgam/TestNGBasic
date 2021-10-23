package practiceTestCase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.GetAlertText;

public class RefreshTypes {

	public static void main(String[] args) throws InterruptedException, AWTException {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");

		Thread.sleep(3000);

		// 1
		driver.get(driver.getCurrentUrl());

		Thread.sleep(3000);
		// 2
		driver.navigate().to(driver.getCurrentUrl());
		Thread.sleep(3000);
		// 3
		driver.navigate().refresh();
		Thread.sleep(3000);

		// 4
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.id("password")).sendKeys(Keys.F5);
		System.out.println("11");
		
		
		//sendKeys() method:
		
		driver.findElement(By.id("email")).sendKeys(Keys.chord(Keys.CONTROL.F5));
		
		System.out.println("111");
		Thread.sleep(5000);
		

		// Robot class

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_R);
		r.keyRelease(KeyEvent.VK_R);
		r.keyRelease(KeyEvent.VK_CONTROL);

		System.out.println("22");

		Thread.sleep(3000);
		// Robot class-2

		Robot rr = new Robot();
		rr.keyPress(KeyEvent.VK_F5);
		rr.keyRelease(KeyEvent.VK_F5);
		System.out.println("33");

		Thread.sleep(3000);

		// using action class-1;

		
		  Actions action = new Actions(driver);
		  action.keyDown(Keys.F5).keyUp(Keys.F5).build().perform();
		  
		  System.out.println("44");
		  
		  Thread.sleep(3000);
		 

		// using action class-2

		Actions action1 = new Actions(driver);
		action1.keyDown(Keys.CONTROL).sendKeys("r").keyUp(Keys.CONTROL).build().perform();
		System.out.println("44");

	}

}
