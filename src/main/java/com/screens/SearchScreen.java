package com.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.screenbase.ScreenBaseClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchScreen extends ScreenBaseClass {
	
	WebDriverWait wait;
	
	@AndroidFindBy(id="flipboard.app:id/search_box_place_holder")
	public WebElement searchBox;
	
	@AndroidFindBy(id="flipboard.app:id/search_view_input")
	public WebElement searchInput;

	public SearchScreen(AppiumDriver<MobileElement> driver) {
		
		super(driver);
		wait = new WebDriverWait(driver, 5);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void searchFlipBoard(String searchText) {
		
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		searchBox.click();
		searchInput.sendKeys(searchText);
		pressEnter();
		
	}

}
