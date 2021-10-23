package screenShot;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alllinks {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");
		
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		
				
	List<WebElement> links = driver.findElements(By.tagName("a"));
	int linkCount=links.size();
	
	
		System.out.println("Total links on page : "+linkCount);
		
		String[] store=new String[linkCount];
		
		for(int i=0; i<linkCount; i++) {
			store[i]=links.get(i).getAttribute("href");
			System.out.println(links.get(i).getAttribute("href"));
		}
		
		for (WebElement webElement : links) {
			webElement.click();
			driver.navigate().back();
			
		}
		
		
	}

}
