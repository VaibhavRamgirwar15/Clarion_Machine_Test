package com.clarion.TestCases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.clarion.Pages.LogPromise;
import com.clarion.Pages.LoginPage;
import com.clarion.Utilities.Readconfig;
import com.clarion.Utilities.Reporting;

public class TC3_clarion_LogPromise_AddingPromise_03 extends TestBase_Class{

	//Object References
	LogPromise objPromise;
	LoginPage lpage_2;
	Reporting report;
	SimpleDateFormat formatt= new SimpleDateFormat("dd/mm/yy HH:mm:ss");
	Date date= new Date();
	Readconfig objConfig = new Readconfig();
	
	@Test(priority = 1)
	public void addingPromiseToLogPromise()
	{
			//Instantiation
			report= new Reporting();
			lpage_2 = new LoginPage(driver);
			
			//Step1: Login to the application
			lpage_2.setUsername(objConfig.getUserName());
			lpage_2.setPassword(objConfig.getPassword());
			lpage_2.clickOnLoginButton();
			report.capturedScreenShot(driver, "TC03_SC01");
			
			//Step2: Click on Log Promise link
			objPromise= new LogPromise(driver);
			objPromise.clickOnLogPromise();
			report.capturedScreenShot(driver, "TC03_SC02");
			
			//Step3: Select Dropdown
			WebElement element = driver.findElement(By.xpath("//select[@name='cboEmp']"));
			this.selectTextFromDropdown(element, "Sonali test");
			report.capturedScreenShot(driver, "TC03_SC03");
			
			//Step4: Send text in textbox
			String writePromise="This is promise from Sonali test on "+formatt.format(date);
			driver.findElement(By.id("txtPromise")).sendKeys(writePromise);
			report.capturedScreenShot(driver, "TC03_SC04");
			
			//Step5: Click on Log promise button
			objPromise.clickOButtonnLogPromise();
			report.capturedScreenShot(driver, "TC03_SC05");
			
			
	}
	
}
