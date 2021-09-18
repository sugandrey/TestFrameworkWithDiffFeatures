package testcases;

import java.util.Hashtable;




import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.basefortestcases.TestBase;
import com.screens.ChooseTopicsScreen;
import com.screens.LoginScreen;

public class FlipboardLoginTest extends TestBase {
	
	LoginScreen loginScreen;
	ChooseTopicsScreen topicScreen;
	
	@BeforeTest
	public void initDriver() {
		
		setUp();
		loginScreen = new LoginScreen(driver);
		topicScreen = new ChooseTopicsScreen(driver);
	}
	
	@Test(priority=1, dataProviderClass=com.utilities.DataProviders.class, dataProvider="flipBoard")
	public void validateGetStartedButton(Hashtable<String, String> data) {
		
		
		com.utilities.ExcelReader excel = new com.utilities.ExcelReader(com.utilities.Constants.SUITE_1_XL_PATH);
		com.utilities.DataUtil.checkExecution("FlipBoardSuite", "validateGetStartedButton", data.get("RunMode"), excel);
		loginScreen.clickGetStartedButton();
		Assert.fail("The test is failed");
		
	}
	
	
	@Test(priority=2, dataProviderClass=com.utilities.DataProviders.class, dataProvider="flipBoard")
	public void chooseTopicsTest(Hashtable<String, String> data) {
		
		com.utilities.ExcelReader excel = new com.utilities.ExcelReader(com.utilities.Constants.SUITE_1_XL_PATH);
		com.utilities.DataUtil.checkExecution("FlipBoardSuite", "chooseTopicsTest", data.get("RunMode"), excel);
		topicScreen.chooseTopics(4).clickContinue();
		
		
	}
	
	@AfterTest
	public void quitDriver() {
		quit();
	}

}
