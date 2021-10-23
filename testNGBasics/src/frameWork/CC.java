package frameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CC {
	
	WebDriver driver=null;
	
	
	@Test
	public void chck() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.jbktest.com/online-exam#Java");
		driver.findElement(By.xpath("//*[@id=\"Java\"]/div/div[8]/a/div")).click();
		driver.findElement(By.xpath("//*[@id=\"quizcount\"]/div[1]/input[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"countbtn\"]")).click();
		driver.switchTo().alert().sendKeys("8482808639");
	}

}
