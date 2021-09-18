package com.basefortestcases;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.screenbase.ScreenBaseClass;
import com.utilities.AppiumServer;
import com.utilities.CommonUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TestBase {
	
	public AppiumDriver<MobileElement> driver;
	public static String loadPropertyFile = "android_flipboard.properties";
	public static Logger log = Logger.getLogger(TestBase.class);
	
//public void takeScreenshot() {
//		
//		Date d = new Date();
//		String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
//		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		try {
//			FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "\\reports\\" + fileName));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	
	public void setUp() {
		
		
		if(driver == null) {
			PropertyConfigurator.configure(System.getProperty("user.dir") + 
					"\\src\\test\\resources\\properties\\log4j.properties");
			
			if(loadPropertyFile.startsWith("android_")) {
				
				AppiumServer.startServer();
				log.info("Appium server started");
				CommonUtils.loadAndroidConfProp(loadPropertyFile);
				log.info(loadPropertyFile + " properties file is loaded");
				CommonUtils.setAndroidCapabilities();
				log.info("Cababililies are downloaded");
				driver = CommonUtils.getAndroidDriver();
				log.info("Driver is downloaded");
				
			}
			else if (loadPropertyFile.startsWith("iOS_")) {
				
			}
		}
		
	}
	
	public void quit() {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		driver.quit();
		log.info("Test case execution completed");
		AppiumServer.stopServer();
		log.info("Appium server stopped!!!");
		
		
	}

}
