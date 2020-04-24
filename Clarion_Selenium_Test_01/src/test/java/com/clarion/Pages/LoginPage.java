package com.clarion.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver cDriver)
	{
		driver=cDriver;
		PageFactory.initElements(cDriver, this);
	}
	
	
	@FindBy(name="txtUsername")
	WebElement Username;
	
	@FindBy(name="txtPassword")
	WebElement Password;
	
	@FindBy(name="submit1")
	WebElement Login;
	
	@FindBy(xpath = "//font[text()='Invalid Username/password']")
	public WebElement errorMessage;
	
	public void setUsername(String uName)
	{
		Username.sendKeys(uName);
	}
	
	public void setPassword(String uPass)
	{
		Password.sendKeys(uPass);
	}
	
	public void clickOnLoginButton()
	{
		Login.click();
	}
	
}
