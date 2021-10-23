package com.javabykiran;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropDownSelection {

	WebDriver driver = null;

	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();

	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

	@Test
	public void login() {
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
		String act = driver.getTitle();
		String exp = "JavaByKiran | Dashboard";
		Assert.assertEquals(act, exp);

	}

	@Test(dependsOnMethods = "login")
	public void addUser() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[1]/aside/section/ul/li[3]/a")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")).click();
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Balkrishna");
		driver.findElement(By.xpath("//*[@id=\"mobile\"]")).sendKeys("8482808639");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("pulgam@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"course\"]")).sendKeys("Java");
		driver.findElement(By.xpath("//*[@id=\"Male\"]")).click();
		WebElement sel = driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[1]/div[6]/div/select"));
		Select select = new Select(sel);
		select.selectByIndex(1);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		Thread.sleep(1000);
		String act = driver.switchTo().alert().getText();
		String exp = "User Added Successfully. You can not see added user.";
		Assert.assertEquals(act, exp);

	}
	
	@Test(dependsOnMethods = "addUser")
	public void alertdismiss() {
		driver.switchTo().alert().dismiss();
		
	}
	
	@Test(dependsOnMethods = "alertdismiss")
	public void chck() throws InterruptedException {
		driver.navigate().back();
		Thread.sleep(1000);
	}
	
	@Test(dependsOnMethods = "chck")
	public void navigateChecking() throws InterruptedException {
		driver.navigate().forward();
		Thread.sleep(800);
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().to("file:///E:/Selenium/Offline%20Website/Offline%20Website/pages/examples/operators.html");
		
	}
	

	
	
	
	
}
