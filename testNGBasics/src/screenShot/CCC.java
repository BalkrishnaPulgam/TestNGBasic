package screenShot;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CCC {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.id("departureCalendar")).click();
		Thread.sleep(1000);
		
		while(!driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div[1]/div/div[6]/div/div/div/div[2]/div/div[1]/div")).getText().contains("October 2021"))
				{
			driver.findElement(By.xpath("//div[@class='DayPicker-NavBar']/span[2][@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			
		}
		
			
		Thread.sleep(2000);
		List<WebElement> dateList=driver.findElements(By.className("calDate"));
		
		int count=dateList.size();
		
		for(int i=0; i<count; i++) {
			String text=driver.findElements(By.className("calDate")).get(i).getText();
			System.out.println("text is"+text);
			if(text.equalsIgnoreCase("14")) {
				driver.findElements(By.className("calDate")).get(i).click();
				break;
			}
		}
	}
	
	
	

}
