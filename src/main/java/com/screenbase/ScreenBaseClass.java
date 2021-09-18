package com.screenbase;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class ScreenBaseClass {
	
	public static AppiumDriver<MobileElement> driver;
	public WebDriverWait wait;
	
	public ScreenBaseClass(AppiumDriver<MobileElement> driver ) {
		this.driver = driver;
	}
	
	public void hideKeyboard() {
		
		driver.hideKeyboard();
		
	}
	
	public void pressEnter() {
		
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
	}

}
