package com.clarion.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.clarion.Pages.LoginPage;
import com.clarion.Utilities.Readconfig;
import com.clarion.Utilities.Reporting;

public class TC2_clarion_LoginTest_validUsernamePass_02 extends TestBase_Class {

	LoginPage lpage_2;
	Reporting report;
	Readconfig objConfig = new Readconfig();
	@Test(priority = 1)
	public void withValidUsernameAndPassword()
	{
		//Instantiation
		report = new Reporting();
		lpage_2 = new LoginPage(driver);
		
		lpage_2.setUsername(objConfig.getUserName());
		
		lpage_2.setPassword(objConfig.getPassword());
		
		lpage_2.clickOnLoginButton();
		
		report.capturedScreenShot(driver, "TC02_SC01");
		
		System.out.println("After Login:"+driver.getTitle());
		
		Assert.assertEquals(driver.getTitle(), "Promise Log");
	}
	
}
