package com.javabykiran;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class BeforeClass1 {
	
	WebDriver driver = null;
	
	@BeforeClass
	public void browserset() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");
		
	    }
	
	@AfterClass
		public void BrowserClose() {
	
				driver.close();		
        }
					
	@Test
	public void VerifyBroserLaunch() {
		
		String Act = driver.getCurrentUrl();
		System.out.println("Act:"+ Act);
		String Exp = "file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html";
		System.out.println("Exp:"+ Exp);
		Assert.assertEquals(Act, Exp);
				
	   }
	
	@Test
   public void VerifyLoginPage() {
		
		String Act = driver.getTitle();
		System.out.println("Act:"+ Act);
		String Exp = "JavaByKiran | Log in";
		System.out.println("Exp:"+ Exp);
		Assert.assertEquals(Act, Exp);
				
	   }
	
	

}
