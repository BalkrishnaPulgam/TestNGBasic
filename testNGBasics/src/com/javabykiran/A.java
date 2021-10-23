package com.javabykiran;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class A {
	
	WebDriver driver =null;
	@BeforeClass
	public void open() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");
		
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
		
	}
	

	
	@Test
	public void VerifyBrowserTitle() {
		
		String act= driver.getTitle();
		System.out.println("Actual Browser Title: "+act);
		String exp = "JavaByKiran | Log in";
		System.out.println("Expected Browser Title "+exp);
		driver.close();
		Assert.assertEquals(act, exp);
	}
	
	@Test
	public void openLinkJBK() {
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	}
	@Test(dependsOnMethods = "openLinkJBK")
	public void checkingUsefulLinks() {
		driver.findElement(By.xpath("/html/body/div/aside[1]/section/ul/li[5]/a")).click();
		String act = driver.getTitle();
		Assert.assertEquals(act, "JavaByKiran | Useful Links");				
	}
		
	@Test(dependsOnMethods = "openLinkJBK")
	public void CheckOperatorLink() {
		driver.findElement(By.linkText("/html/body/div/aside[1]/section/ul/li[4]/a")).click();
		String act = driver.getTitle();
		Assert.assertEquals(act, "JavaByKiran | Operators");
	}
	
	@Test(dependsOnMethods = "openLinkJBK")
	public void checkFooterText() {
		String act =driver.findElement(By.xpath("/html/body/div/footer/div/b")).getText();
		System.out.println("Actual :" + act);
		String exp = "Design for Selenium Automation Test";
		System.out.println("Expceted: " + exp);
		Assert.assertEquals(act, exp);
		
	}
	
	
	
	
}
