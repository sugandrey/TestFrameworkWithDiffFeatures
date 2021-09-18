package com.screens;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;

import com.screenbase.ScreenBaseClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginScreen extends ScreenBaseClass {
	
	@AndroidFindBy(id="flipboard.app:id/icon_button_text")
	public WebElement continueButton;

	public LoginScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public ChooseTopicsScreen clickGetStartedButton() {
		
		continueButton.click();
		
		return new ChooseTopicsScreen(driver);
	}
	
	

}
