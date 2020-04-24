package com.clarion.TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.clarion.Utilities.Readconfig;

public class TestBase_Class {

	Readconfig objConfig=new Readconfig();
	public WebDriver driver;
	
	@BeforeClass
	public void launchBrowser_setUpMethod() {
		
		if(objConfig.getBrowser().equalsIgnoreCase(("chrome")))
		{
			System.setProperty("webdriver.chrome.driver", objConfig.getChromePath());
			//System.setProperty("webdriver.chrome.driver", "/home/vaibhav/Browser_Driver/chromedriver_linux64/chromedriver");
			driver= new ChromeDriver();
		}else if(objConfig.getBrowser().equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", objConfig.getFirefoxPath());
			//System.setProperty("webdriver.chrome.driver", "/home/vaibhav/Browser_Driver/chromedriver_linux64/chromedriver");
			driver= new ChromeDriver();
		}
	}
	
	@BeforeMethod
	public void lauchApplication()
	{
		driver.get(objConfig.getApplicationURL());
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@AfterClass
	public void closeAllInstances()
	{
		driver.quit();
	}
	
	public void selectTextFromDropdown(WebElement element, String textName )
	{
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(textName);
	}
	
	public void datePicker(String month, String day) throws InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//td[@class='title']"))));
		String tableMonth= driver.findElement(By.xpath("//td[@class='title']")).getText();					
		
		if(tableMonth.equals(month))
			driver.findElement(By.xpath("//tbody/tr[@class='daysrow']/td[@class='day' and contains(text(),'"+day+"')]")).click();
	}
	
	public String comparisionWithMultiWebElements(List<WebElement> tableData, String writePromise)
	{
		String matchFound="";
		for(int i=0; i<tableData.size(); i++)
		{
			if(writePromise.equals(tableData.get(i).getText()))
			{
				matchFound=tableData.get(i).getText();
			}
		}
			return matchFound;
	}
	
}
