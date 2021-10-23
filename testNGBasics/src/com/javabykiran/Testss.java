package com.javabykiran;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testss {
	
	@Test(description="Verifying Titlename")
	public void Titlecheck() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");
		String actual = driver.getTitle();
		System.out.println(actual);
		String exp = "JavaByKiran | Log in";
		System.out.println(exp);
		Assert.assertEquals(actual, exp);

	}
	@Test (description="Verifying Text box")
	public void verifytextBox() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");
		String act =driver.findElement(By.id("email")).getAttribute("placeholder");
		String exp = "Email";
		Assert.assertEquals(act, exp);
	}
	
	
	
	

	@Test
	public void lableCheck() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");
		String lableHeading = driver.findElement(By.xpath("/html/body/div/div[1]/a/b")).getText();
		System.out.println("lableHeading>>" + lableHeading);
		String exp = "Java By Kiran";
		driver.close();
		
		Assert.assertEquals(lableHeading, exp);

	}

	@Test
	public void membershipcheck() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");
		String act = driver.findElement(By.xpath("/html/body/div/div[2]/a")).getText();
		System.out.println("Text:" + act);
		String exp ="Register a new membership"; 
		driver.close();
		Assert.assertEquals(act, exp);

	}
	
	@Test
	public void loginError() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys(" ");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
		String act = driver.findElement(By.id("email_error")).getText();
		System.out.println(act);
		String exp = "Please enter valid email.";
		Assert.assertEquals(act, exp);
		
			}
	
	@Test
	public void user() {
		System.getProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/pages/examples/users.html");
		String act = driver.getTitle();
		System.out.println("actual:"+act);;
		String exp = "JavaByKiran | User";
		System.out.println("Exp:"+ exp);
		driver.close();
		Assert.assertEquals(act, exp);
		
	}
	
	@Test
	public void operator() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/pages/examples/operators.html");
		String act = driver.getTitle();
		System.out.println("Actual"+ act );
		String exp = "JavaByKiran | Operators";
		System.out.println("Exp" + exp);
		Assert.assertEquals(act, exp);
		
	}
	
	@Test
	public void usefulLinks() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/pages/examples/links.html");
		String act = driver.getTitle();
		System.out.println("act" + act);
		String exp = "JavaByKiran | Useful Links";
		System.out.println("exp" + exp);
		driver.close();
		Assert.assertEquals(act, exp);
	}
	
	@Test
	public void downloads() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/pages/examples/downloads.html");
		String act = driver.getTitle();
		System.out.println("act"+act);
		String exp = "JavaByKiran | Downloads";
		System.out.println("exp" + exp );
		driver.close();
		Assert.assertEquals(act, exp);
	}
	
	@Test
	public void useAdd() {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");
	driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
	driver.findElement(By.id("password")).sendKeys("123456");
	driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a")).click();
	driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")).click();
	driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Pulgam");
	driver.findElement(By.xpath("//*[@id=\"mobile\"]")).sendKeys("8482808639");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("pulgambalkrishna47@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"course\"]")).sendKeys("Java");
	driver.findElement(By.xpath("//*[@id=\"Male\"]")).click();
	Select sel = new Select(driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[1]/div[6]/div/select")));
	sel.selectByValue("Maharashtra");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456789");
	driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
	String act = driver.switchTo().alert().getText();
	driver.switchTo().alert().accept();
	System.out.println("act: " + act);
	String exp = "User Added Successfully. You can not see added user.";
	System.out.println("exp " + exp);
	driver.close();
	Assert.assertEquals(act, exp);
	
	}
	

	
}
