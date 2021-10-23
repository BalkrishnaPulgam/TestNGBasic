package com.javabykiran;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestCases {
	
		
@Test
		public void checkTestOne() {
	
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("file:///E:/Selenium/Offline%20Website/Offline%20Website/index.html");
	String lableHeading = driver.findElement(By.xpath("/html/body/div/div[1]/a/b")).getText();
	System.out.println("lableHeading>>"+ lableHeading);
	driver.close();
	Assert.assertEquals(lableHeading, "Java By Kiran");
		
}

  @Test
  public void checkTestTwo() {
	  
	  
	Assert.assertEquals(5, 5);
  }

  @Test
  public void checkTestThree() {
  	Assert.assertEquals(7, 7);
  }

}
