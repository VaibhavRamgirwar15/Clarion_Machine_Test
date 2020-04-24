package com.clarion.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.clarion.Pages.LogPromise;
import com.clarion.Pages.LoginPage;
import com.clarion.Utilities.Readconfig;
import com.clarion.Utilities.Reporting;

public class TC2_clarion_LoginTest_validUsernamePass_02 extends TestBase_Class {

	LoginPage lpage_2;
	LogPromise promise;
	Reporting report;
	Readconfig objConfig = new Readconfig();
	@Test(priority = 1)
	public void withValidUsernameAndPassword()
	{
		//Instantiation
		report = new Reporting();
		lpage_2 = new LoginPage(driver);
		promise = new LogPromise(driver);
		
		lpage_2.setUsername(objConfig.getUserName());
		
		lpage_2.setPassword(objConfig.getPassword());
		
		report.capturedScreenShot(driver, "TC02_SC01");
		
		lpage_2.clickOnLoginButton();
		
		report.capturedScreenShot(driver, "TC02_SC02");
		
		Assert.assertEquals(promise.logout.isDisplayed(), true);
		
		System.out.println("Succesfully login to the Application...!!!");
	}
	
}
