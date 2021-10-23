package com.javabykiran;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCases20 {
		WebDriver driver =null;	
		
	
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
	
		
			
	@Test(priority = 1,description = "1=Verifying Browser launch" ) 
	public void VerifyBrowserLaunch() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String act = driver.getCurrentUrl();
		System.out.println("Actual: "+ act);
		String exp = "file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html";
		System.out.println("Expected: "+ exp);
		Assert.assertEquals(act, exp);		
		}
	
				
	@Test (priority = 2,description = "2=Verifying Browser Title")
	public void VerifyBrowserTitle() {
		String act= driver.getTitle();
		System.out.println("Actual Browser Title: "+act);
		String exp = "JavaByKiran | Log in";
		System.out.println("Expected Browser Title "+exp);
		Assert.assertEquals(act, exp);
	   }
	
	@Test (priority = 3,description = "3=Verifying Placeholder Email")
	public void VerifyPlaceholderEmail() {
		String act = driver.findElement(By.xpath("//*[@id=\"email\"]")).getAttribute("placeholder");
		System.out.println("Actual Placeholder" + act);
		String exp = "Email";
		System.out.println("Expected Placeholder" + exp);
		Assert.assertEquals(act, exp);
		
   	}
	
	@Test(priority = 3,description = "4=Verifying Placeholder Password")
	public void VerifyPlaceholderPassword() {						
		String act = driver.findElement(By.xpath("//*[@id=\"password\"]")).getAttribute("placeholder");
		System.out.println("Actual Placeholder: "+act);
		String exp = "Password";
		System.out.println("Expected Placeholder: "+exp);
		Assert.assertEquals(act, exp);
	}
	
	@Test(priority = 4,description = "5=Verifying Input Type-Text or Radio button")	
	public void VerifyInputType() {
		String act = driver.findElement(By.id("email")).getAttribute("type");
		System.out.println("Actual Input Type" + act);
		String exp = "text";
		System.out.println("Expected Input Type" + exp);
		Assert.assertEquals(act, exp);		
	}
		
	@Test (priority = 5,description = "6=Verifying Logo")
	public void VerifyingLogo() {
		boolean act = driver.findElement(By.xpath("//*[@id=\"email\"]")).isDisplayed();
		Assert.assertEquals(act, true);
	}
	
	
	@Test (priority = 6,description = "7=Check Logo Height")
	public void CheckLogoHeight() {
		int act = driver.findElement(By.xpath("/html/body/div/center/img")).getSize().height;
		System.out.println("Actual Height: " + act);
		int exp = 150;
		System.out.println("Exp Height: " + exp);
		Assert.assertEquals(act, exp);
	}
	
	@Test (priority = 7,description = "8=Verifying Tag Name Sign in")
	public void VerifyingTagName() {
		String act = driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).getTagName();
		System.out.println("Actual TagName: " + act);
		String exp = "button";
		System.out.println("Exp TagName: " + exp);
		Assert.assertEquals(act, exp);
	}
	
	
	@Test(priority = 8)
	public void checkErrorMsgOfEmail() {
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
		
		String act = driver.findElement(By.xpath("//*[@id=\"email_error\"]")).getText();
		System.out.println("Displayed Error: " + act);
		String exp = "Please enter email";
		System.out.println("Expected Error: " + exp);
		Assert.assertEquals(act, exp);		
	}
	
	@Test(priority = 9)
	public void checkErrorMsgColor() {
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
		
		String act = driver.findElement(By.xpath("//*[@id=\"email_error\"]")).getAttribute("style");
		System.out.println("Actual clr = " + act);
		String exp = "color: red;";
		System.out.println("Expected clr = " + exp);
		Assert.assertEquals(act, exp);
	}
	
	
	@Test(priority = 10)
	public void checkErrorMsgOfPassword() {
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("789456");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
		String act = driver.findElement(By.xpath("/html/body/div/div[2]/form/div[2]/div")).getText();
		System.out.println("Displayed Error: " + act);
		String exp = "Please enter password 123456";
		System.out.println("Expected Error: " + exp);
		Assert.assertEquals(act, exp);		
	}
	
	@Test(priority = 11)
	public void emailSuggestion() {
		driver.findElement(By.id("email")).sendKeys("b@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
		String act = driver.findElement(By.xpath("//*[@id=\"email_error\"]")).getText();
		System.out.println("Actual Suggestion: " + act );
		String exp = "Please enter email as kiran@gmail.com";
		System.out.println("Expected Suggestion: " + exp);
		Assert.assertEquals(act, exp);		
	}
	
	@Test(priority = 12)
	public void passwordSuggestion() {
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("546");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
		String act = driver.findElement(By.xpath("//*[@id=\"password_error\"]")).getText();
		System.out.println("Actual Suggestion: " + act );
		String exp = "Please enter password 123456";
		System.out.println("Expected Suggestion: " + exp);
		Assert.assertEquals(act, exp);		
	}
	
	@Test(priority = 13)
	public void registerMembership() {
		driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();
		String act = driver.getCurrentUrl();
		String exp ="file:///E:/Selenium/Offline%20Website/Offline%20Website/pages/examples/register.html";
		Assert.assertEquals(act, exp);		
	}
	
	@Test(priority = 14)
	public void downloadsTitle() {
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/pages/examples/downloads.html");
		String act = driver.getTitle();
		System.out.println("act"+act);
		String exp = "JavaByKiran | Downloads";
		System.out.println("exp" + exp );
		driver.close();
		Assert.assertEquals(act, exp);
	}
	
	@Test(priority = 15)
	public void checkingLogoutTitle() {
		driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/pages/examples/logout.html");
		String act = driver.getTitle();
		System.out.println("act"+act);
		String exp = "JavaByKiran | Log in";
		System.out.println("exp" + exp );
		driver.close();
		Assert.assertEquals(act, exp);
	}
	

	@Test(priority = 16)
	public void openLinkJBK() {
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
	}
	@Test(priority = 17,dependsOnMethods = "openLinkJBK")
	public void checkingUsefulLinks() {
		driver.findElement(By.xpath("/html/body/div/aside[1]/section/ul/li[5]/a")).click();
		String act = driver.getTitle();
		Assert.assertEquals(act, "JavaByKiran | Useful Links");				
	}
		
	@Test(priority = 18,dependsOnMethods = "openLinkJBK")
	public void CheckOperatorLink() {
		driver.findElement(By.xpath("/html/body/div/aside[1]/section/ul/li[4]/a")).click();
		String act = driver.getTitle();
		Assert.assertEquals(act, "JavaByKiran | Operators");
	}
	
	@Test(priority = 19,dependsOnMethods = "openLinkJBK")
	public void checkFooterText() {
		String act =driver.findElement(By.xpath("/html/body/div/footer/div/b")).getText();
		System.out.println("Actual :" + act);
		String exp = "Design for Selenium Automation Test";
		System.out.println("Expceted: " + exp);
		Assert.assertEquals(act, exp);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
