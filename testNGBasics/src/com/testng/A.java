package com.testng;

import java.io.FileInputStream;
import java.util.Properties;

public class A {
	
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("config1.properties");
		Properties properties = new Properties();
		properties.load(fis);
		String a = properties.getProperty("testPlanFile");
		System.out.println(a);

}}
