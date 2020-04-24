package com.clarion.TestCases;


import org.testng.annotations.Test;

import com.clarion.Pages.LoginPage;
import com.clarion.Utilities.Readconfig;
import com.clarion.Utilities.Reporting;

import junit.framework.Assert;

public class TC1_clarion_LoginTest_inValidUsernamePass_01 extends TestBase_Class {

			LoginPage lPage;
			Reporting report;
			Readconfig objConfig = new Readconfig();
			
	@Test(priority = 1)
	public void withoutUsernamePasswordTest() throws InterruptedException
	{	
				//Instantiation
				report = new Reporting();
				lPage= new LoginPage(driver);
				
				//Step1: Click on login button without username password
				lPage.clickOnLoginButton();
		
				Thread.sleep(3000);
		
				String ActualError = lPage.errorMessage.getText();
				
				//Verified validation on login page
				Assert.assertEquals(ActualError, "Invalid Username/password");
				
				report.capturedScreenShot(driver, "TC01_SC01");
	
	}
	
	@Test
	public void withUsernameWithoutPasswordTest() throws InterruptedException
	{
				//Instantiation
				report = new Reporting();
				lPage= new LoginPage(driver);
				
				//Step1: Click on login button with username without password
				lPage.setUsername(objConfig.getUserName());
				
				report.capturedScreenShot(driver, "TC01_SC02");
				lPage.clickOnLoginButton();
				
				report.capturedScreenShot(driver, "TC01_SC03");
				
				Thread.sleep(3000);

				String ActualError = lPage.errorMessage.getText();
				
				//Verified validation on login page
				Assert.assertEquals(ActualError, "Invalid Username/password");
				
				
	
	}
		
}
