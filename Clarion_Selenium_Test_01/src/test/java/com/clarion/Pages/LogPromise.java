package com.clarion.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogPromise {

WebDriver driver;
	
	public LogPromise(WebDriver cDriver)
	{
		driver=cDriver;
		PageFactory.initElements(cDriver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Log Promise')]")
	WebElement elelogPromise;
	
	@FindBy (xpath = "//input[@id='btnSubmit']")
	WebElement btnLogPromise;
	
	@FindBy(xpath = "//a[contains(text(),'Promises From')]")
	WebElement elePromiseFrom;
	
	@FindBy(xpath = "//a[contains(text(),'Promises To')]")
	WebElement elePromiseTo;

	@FindBy(xpath = "//a[contains(text(),'My Account')]")
	WebElement eleMyAccount;
	
	@FindBy(id = "idImg1")
	WebElement startDateCalenderImg;
	
	@FindBy(id = "idImg2")
	WebElement endDateCalenderImg;
	
	//update id if not work
	@FindBy(id = "btnSerach")
	WebElement searchButton;
	
	public void clickOnSearchButton()
	{
		searchButton.click();
	}
	
	public void clickOnLogPromise()
	{
		elelogPromise.click();
	}
	
	public void clickOButtonnLogPromise()
	{
		btnLogPromise.click();
	}
	
	public void clickOnPromiseFrom(String vPromiseFrom)
	{
		elePromiseFrom.click();
	}
	
	public void clickOnPromiseTo(String vLogPromise)
	{
		elePromiseTo.click();
	}
	
	public void clickOnMyAccount()
	{
		eleMyAccount.click();
	}
	
	public void clickOnStartDateCalender()
	{
		startDateCalenderImg.click();
	}
	public void clickOnEndDateCalender()
	{
		endDateCalenderImg.click();
	}
	
	
}
