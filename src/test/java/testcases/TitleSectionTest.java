package testcases;

import java.util.Hashtable;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.basefortestcases.TestBase;
import com.screens.HomeScreen;
import com.screens.LoginScreen;
import com.utilities.ScrollUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TitleSectionTest extends TestBase{
	
	LoginScreen loginScreen;
	HomeScreen homeScreen;
	
	@BeforeTest
	public void initTest() {
		
		setUp();
		loginScreen = new LoginScreen(driver);
		homeScreen = new HomeScreen(driver);
	}
	
	@Test(dataProviderClass=com.utilities.DataProviders.class, dataProvider="flipBoard")
	public void validateTitle(Hashtable<String, String> data) {
		
		com.utilities.ExcelReader excel = new com.utilities.ExcelReader(com.utilities.Constants.SUITE_1_XL_PATH);
		com.utilities.DataUtil.checkExecution("FlipBoardSuite", "validateTitle", data.get("RunMode"), excel);
		loginScreen.clickGetStartedButton().chooseTopics(4).clickContinue().skipLogin();
		homeScreen.goToTitleSection(2);
		//takeScreenshot();
		ScrollUtil.scrollUp(2, (AndroidDriver<MobileElement>) driver);
	}
	
	@AfterTest
	public void quitDriver() {
		quit();
	}

}
