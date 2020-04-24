package com.clarion.TestCases;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.clarion.Pages.LogPromise;
import com.clarion.Pages.LoginPage;
import com.clarion.Utilities.Readconfig;
import com.clarion.Utilities.Reporting;

public class TC4_clarion_LogPromise_verifyPromiseAdded_04 extends TestBase_Class{

	//Object Reference
	LogPromise objPromise;
	LoginPage lpage_2;
	Reporting report;
	SimpleDateFormat formatt= new SimpleDateFormat("dd/mm/yy HH:mm:ss");
	Date date= new Date();
	Readconfig objConfig = new Readconfig();
	
	@Test(priority = 1)
	public void verifyingNewlyAddedPromiseInLogPromise() throws InterruptedException
	{
				//Instantiation
				report= new Reporting();
				lpage_2 = new LoginPage(driver);
				
				//Step1: Login to the Application
				lpage_2.setUsername(objConfig.getUserName());
				lpage_2.setPassword(objConfig.getPassword());
				lpage_2.clickOnLoginButton();
				report.capturedScreenShot(driver, "TC04_SC1");
				
				//Step2: Click on Log Promise link
				objPromise= new LogPromise(driver);
				objPromise.clickOnLogPromise();
				report.capturedScreenShot(driver, "TC04_SC2");
				
				//Step3: Select Value from drop down
				WebElement element = driver.findElement(By.xpath("//select[@name='cboEmp']"));
				this.selectTextFromDropdown(element, "Sonali test");
				report.capturedScreenShot(driver, "TC04_SC3");
				
				//Step4: Send TextMessage
				String writePromiseText="This is promise from Sonali test on "+formatt.format(date);
				driver.findElement(By.id("txtPromise")).sendKeys(writePromiseText);
				report.capturedScreenShot(driver, "TC04_SC4");
				
				//Step5: Click log promise button
				objPromise.clickOButtonnLogPromise();
				report.capturedScreenShot(driver, "TC04_SC5");
				
				//Step6: Select Dropdown Value
				WebElement eleSearchTable = driver.findElement(By.xpath("//select[@id='cboEmp']"));
				this.selectTextFromDropdown(eleSearchTable, "Sonali test");
				report.capturedScreenShot(driver, "TC04_SC6");
				
				//Step7: Select Start Date from calendar
				objPromise.clickOnStartDateCalender();
				this.datePicker("April, 2020", "22");
				
				objPromise.clickOnEndDateCalender();
				//this.datePicker("April, 2020", "24");
				objPromise.setEndDate("24-04-2020");
				report.capturedScreenShot(driver, "TC04_SC7");
				
				//Step8: Click on search button
				objPromise.clickOnSearchButton(); 
				report.capturedScreenShot(driver, "TC04_SC8");
				
				//Step9 Verify the added value
				List<WebElement> elements= driver.findElements(By.xpath("//body[@class='body_default']//tr//tr//tr//td[text()='Sonali test']//following::td[1]"));
				String tablePromiseText = this.comparisionWithMultiWebElements(elements, writePromiseText);
				Assert.assertEquals(writePromiseText, tablePromiseText);
				report.capturedScreenShot(driver, "TC04_SC9");
				System.out.println("Verified Promise has been verified succesfully..!!!");
				
	}
	
		
}
