package practiceTestCase;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestCaseNew {

	static WebDriver driver = null;
	WebElement WeUserName;
	WebElement WEPassword;
	WebElement WeSignbutton;
	WebElement erroMsg;

	@BeforeSuite
	public void setupEnvironMent() {
		DesiredCapabilities capabilities = new DesiredCapabilities().chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
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

	/*
	 * @BeforeMethod public void beforeMethod(Method method) { Test test =
	 * method.getAnnotation(Test.class); System.out.println("Test name is: " +
	 * test.testName()); System.out.println("Test description is: " +
	 * test.description()); }
	 */

	@Test(priority = 1, testName = "Test1", description = "verify that appearing test(Sr) is correct or not")
	public void chekingSr() {

		driver.findElement(By.xpath("/html/body/div/aside[1]/section/ul/li[5]/a")).click();
		String act = driver
				.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[1]/th[1]"))
				.getText();
		String Exp = "Sr";
		Assert.assertEquals(act, Exp);
	}

	@Test(priority = 2, dependsOnMethods = "chekingSr", testName = "Test1", description = "verify that appearing test(Click) is correct or not")
	public void CheckTestClick() {
		String act = driver
				.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[1]/th[3]"))
				.getText();
		String exp = "Click";
		Assert.assertEquals(act, exp);

	}

	@Test(priority = 3)
	public void CheckTextSchedule() {
		String act = driver
				.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[2]/td[2]"))
				.getText();
		String exp = "Schedule";
		Assert.assertEquals(act, exp);

	}

	@Test(priority = 4)
	public void CheckTextVideoLacturesAllTopics() {
		String act = driver
				.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[3]/td[2]"))
				.getText();
		String exp = "Video Lactures All Topics";
		Assert.assertEquals(act, exp);

	}

	@Test(priority = 5)
	public void CheckTextSeleniumInterviewQuestions() {
		String act = driver
				.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[4]/td[2]"))
				.getText();
		String exp = "Selenium Interview Questions";
		Assert.assertEquals(act, exp);

	}

	@Test(priority = 6)
	public void CheckTextJavaInterviewQuestions() {
		String act = driver
				.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[5]/td[2]"))
				.getText();
		String exp = "Java Interview Questions";
		Assert.assertEquals(act, exp);

	}

	@Test(priority = 7)
	public void CheckTextCourses() {
		String act = driver
				.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[6]/td[2]"))
				.getText();
		String exp = "Courses";
		Assert.assertEquals(act, exp);

	}

	@Test(priority = 8)
	public void CheckTextPlacement() {
		String act = driver
				.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[7]/td[2]"))
				.getText();
		String exp = "Placement";
		Assert.assertEquals(act, exp);

	}

	@Test(priority = 9)
	public void CheckTextInternetRequired() {
		String act = driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/div[1]/h3")).getText();
		String exp = "* Internet Required";
		Assert.assertEquals(act, exp);

	}

	@Test(priority = 10)
	public void usefullinktable() {

		WebElement table = driver.findElement(By.xpath("//table[@class='table table-hover']"));

		List<WebElement> tr = table.findElements(By.tagName("tr"));
		System.out.println("total number of rows " + tr.size());
		for (WebElement row : tr) {
			List<WebElement> td = row.findElements(By.tagName("td"));
			for (WebElement col : td) {
				System.out.println(col.getText());

			}
			System.out.println("............");

		}
	}

	@Test(priority = 11)
	public void operatorlinktable() {

		driver.findElement(By.xpath("//span[text()='Operators']")).click();

		List<WebElement> table = driver.findElements(By.tagName("tr"));
		System.out.println("no of rows " + table.size());
		for (WebElement row : table) {
			List<WebElement> header = row.findElements(By.tagName("th"));
			for (WebElement col : header) {
				System.out.println(col.getText());
			}
		}

		System.out.println("Available content:");

		for (WebElement row1 : table) {
			List<WebElement> row = row1.findElements(By.tagName("td"));
			for (WebElement col : row) {
				System.out.println(col.getText());
			}
		}
	}
	
	
	@Test(priority = 12)
	public void operatorlinktable1() {

		driver.findElement(By.xpath("//span[text()='Operators']")).click();

		List<WebElement> table = driver.findElements(By.tagName("tr"));
		System.out.println("no of columns " + table.size());
		for (WebElement row : table) {
			List<WebElement> header = row.findElements(By.tagName("th"));
			for (WebElement col : header) {
				System.out.println(col.getText());
			}
		}

		System.out.println("Available content:");

		for (WebElement row1 : table) {
			List<WebElement> row = row1.findElements(By.tagName("td"));
			for (WebElement col : row) {
				System.out.println(col.getText());
			}
		}
	}
	
	@Test(priority=13)
	public void downloadtable() {
		
		driver.findElement(By.xpath("//table[@class='table table-hover']")).click();
		
		List<WebElement> table = driver.findElements(By.tagName("tr"));
		
		System.out.println("No of download Columns"+table.size());
				
		for (WebElement row : table) {
			List<WebElement> rows=row.findElements(By.tagName("th"));
			for (WebElement column : rows) {
				System.out.println("Download:"+column.getText());
				
			}
			
		}
		
	}
	
	
	
	@Test(priority=14)
	public void downloadtable1() {
		List<WebElement> column = driver.findElements(By.tagName("th"));
		int cl=column.size();
		List<WebElement> row =driver.findElements(By.tagName("td"));
		int rows=row.size();
		
				
		for(int i=0; i<=cl; i++) {
			for(int j=0;j<=rows; j++) {
				
				
				System.out.println("Download11");
				
				
			}
				
			}
			
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
