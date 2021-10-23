package practiceTestCase;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DropdownOptions {
	

static	WebDriver driver = null;
	WebElement WeUserName;
	WebElement WEPassword;
	WebElement WeSignbutton;
	WebElement erroMsg;

	@BeforeSuite
	public void setupEnvironMent() {
		DesiredCapabilities capabilities = new DesiredCapabilities().chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		capabilities.setCapability(ChromeOptions.CAPABILITY,options);
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver(capabilities);
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
	}

	@BeforeClass
	public void locateAllWebElements() {
		WeUserName = driver.findElement(By.id("email"));
		WEPassword = driver.findElement(By.id("password"));
		WeSignbutton = driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button"));
		WeUserName.sendKeys("kiran@gmail.com");
		WEPassword.sendKeys("123456");
		WeSignbutton.click();
	}
	
	
	
 static List<String> getAllOptions(By by) {
	    List<String> options = new ArrayList<String>();
	    for (WebElement option : new Select(driver.findElement(by)).getOptions()) {
	        String txt = option.getText();
	        if (option.getAttribute("value") != "") options.add(option.getText());
	    }
	    return options;
	}
 
 
 @Test 
 public void dropDownOptions(){
	 driver.findElement(By.xpath("/html/body/div[1]/aside/section/ul/li[3]/a")).click();
	 driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")).click();
		//getAllOptions(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[1]/div[6]/div/select"));
		System.out.println(getAllOptions(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[1]/div[6]/div/select")));
		
 }
 
 
 
	

}
