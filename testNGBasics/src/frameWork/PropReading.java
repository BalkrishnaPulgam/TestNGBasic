package frameWork;

import java.io.FileInputStream;
import java.util.Properties;

public class PropReading {
	
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("config.properties");
		Properties properties = new Properties();
		properties.load(fis);
		String brType = properties.getProperty("browser");
		String url = properties.getProperty("url");
		String expUrl = properties.getProperty("expectedUrl");
		
		System.out.println("Expected Url:"+expUrl);
		System.out.println("val>> " + brType);
		System.out.println("val>> " + url);
		
		
		String userEmail=properties.getProperty("userid");	
		System.out.println("UserEmail>> "+userEmail);
		
		String userPassword=properties.getProperty("userpass");
		System.out.println("Userpass>> "+ userPassword);
		
		
		String xpathvalue = properties.getProperty("clickButtonXpath");
		System.out.println(xpathvalue);
	}

}
