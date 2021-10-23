package screenShot;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practicee {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.goibibo.com/flights/air-PNQ-NAG-20210914--1-0-0-E-D/?exp=v1");
		Thread.sleep(3000);
	//	driver.manage().window().maximize();
	//	Thread.sleep(3000);
		
		
		List<WebElement> name=driver.findElements(By.className("font14 padL5 black"));
		Thread.sleep(3000);
		int a=name.size();
		System.out.println("IndiGO Fight Available Count ="+a);
		
		for(int i=0; i<a; i++) {
		
			String flight=driver.findElements(By.className("font14 padL5 black")).get(i).getText();
			
		if(flight.equalsIgnoreCase("IndiGo")) {
				String aa=driver.findElements(By.className("font14 padL5 black")).get(i).getText();
			System.out.println(aa);
					
				} 
		}
		
	}

}
