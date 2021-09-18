package testcases;

import java.util.Hashtable;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.basefortestcases.TestBase;
import com.screens.HomeScreen;
import com.screens.LoginScreen;
import com.screens.SearchScreen;
import com.utilities.ScrollUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SearchItemTest extends TestBase {
	
	LoginScreen loginScreen;
	SearchScreen searchScreen;
	
	@BeforeTest
	public void initDriver() {
		
		setUp();
		loginScreen = new LoginScreen(driver);
		searchScreen = new SearchScreen(driver);
	}
	
	@Test(priority=1, dataProviderClass=com.utilities.DataProviders.class, dataProvider="flipBoard")
	public void searchItemTest(Hashtable<String, String> data) {
		
		
		com.utilities.ExcelReader excel = new com.utilities.ExcelReader(com.utilities.Constants.SUITE_1_XL_PATH);
		com.utilities.DataUtil.checkExecution("FlipBoardSuite", "searchItemTest", data.get("RunMode"), excel);
		HomeScreen screen = loginScreen.clickGetStartedButton().chooseTopics(4).clickContinue().skipLogin();
		screen.selectBottomPanel(3);
		
		
		searchScreen.searchFlipBoard(data.get("searchText"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ScrollUtil.scrollUp(2, (AndroidDriver<MobileElement>) driver);
	}
	
	
	@AfterTest
	public void quitDriver() {
		quit();
	}

}
