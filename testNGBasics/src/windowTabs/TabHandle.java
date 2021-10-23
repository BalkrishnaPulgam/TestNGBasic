package windowTabs;

import java.util.ArrayList;
import java.util.ResourceBundle.Control;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TabHandle {
	
	 public static void main(String[] args) {

		 WebDriver driver = new ChromeDriver();
			
			System.setProperty("webriver.chrome.driver", "chromedriver.exe");
			
	        driver.get("http://www.google.com");
	        
	        WebElement element= driver.findElement(By.xpath("//*[@id=\"gb\"]/div/div[1]/div/div[1]/a"));

	      
	        Actions action = new Actions(driver);

	        action.moveToElement(element).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).perform();
	      

	       
	 }

}
