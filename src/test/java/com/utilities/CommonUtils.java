package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class CommonUtils {

	private static AppiumDriver<MobileElement> driver;
	private static URL serverURL;
	private static DesiredCapabilities capabilities = new DesiredCapabilities();
	private static String APPIUM_PORT;
	private static int IMPLICIT_WAIT_TIME;
	private static int EXPLICIT_WAIT_TIME;
	private static String BASE_PKG;
	private static String APP_ACTIVITY;
	private static String APP_PATH;
	private static String BROWSER_NAME;
	private static String PLATFORM_NAME;
	private static String PLATFORM_VERSION;
	private static String DEVICE_NAME;
	private static String UDID; // FOR iOS
	private static String BUNDLE_ID;// FOR iOS
	private static String APP;// FOR iOS
	private static Properties prop = new Properties();
	private static FileInputStream fis;
	
	public static void loadAndroidConfProp(String loadPropertyFile) {
		
		
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/" + loadPropertyFile);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		IMPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("implicit.wait"));
		EXPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("explicit.wait"));
		BASE_PKG = prop.getProperty("base.pkg");
		APP_ACTIVITY = prop.getProperty("app.activity");
		BROWSER_NAME = prop.getProperty("browser.name");
		PLATFORM_NAME = prop.getProperty("platform.name");
		PLATFORM_VERSION = prop.getProperty("platform.version");
		DEVICE_NAME = prop.getProperty("device.name");
		APPIUM_PORT = prop.getProperty("appium.server.port");
		APP_PATH = prop.getProperty("application.path");
		
	}


	public static void setAndroidCapabilities() {

		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
		//capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
		//capabilities.setCapability(CapabilityType.BROWSER_NAME, BROWSER_NAME);
		
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, BASE_PKG);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY);
		
	}

	public static void loadIOSConfProp(String loadPropertyFile) {

	}

	public static void setIOSCapabilities() {

	}

	public static AppiumDriver<MobileElement> getAndroidDriver() {
		
		try {
			serverURL = new URL("http://localhost:" + APPIUM_PORT + "/wd/hub");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver = new AndroidDriver<MobileElement>(serverURL, capabilities);
		return driver;
	}

	public static AppiumDriver<MobileElement> getIOSdDriver() {

		return driver;
	}
}
