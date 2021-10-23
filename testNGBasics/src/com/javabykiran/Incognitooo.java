package com.javabykiran;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Incognitooo {
	
	
	static WebDriver driver= null;

	  public static void main(String args[]) throws InterruptedException {

	    //for private window

	    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	    ChromeOptions option = new ChromeOptions();
	    option.addArguments("incognito");
	    capabilities.setCapability(ChromeOptions.CAPABILITY,option);
	    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");       
	    driver= new ChromeDriver(capabilities);

	    String url = "https://www.google.com/";
	    driver.manage().window().maximize();
	    driver.get(url);
	    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    
	  } 
}
