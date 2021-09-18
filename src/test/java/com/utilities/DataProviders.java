package com.utilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="flipBoard")
	public static Object[][] getDataSuite1(Method m) {
		
		System.out.println(m.getName());
		
		ExcelReader excel = new ExcelReader(Constants.SUITE_1_XL_PATH);
		String testCase = m.getName();
		return DataUtil.getData(testCase, excel);
	}
	
}
