package com.clarion.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {

	Properties properties;
	
	public Readconfig() {
		
		File src= new File("./configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			properties= new Properties();
			properties.load(fis);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
	public String getApplicationURL()
	{
		String url=properties.getProperty("applicationURL");
		return url;
	}
	public String getUserName()
	{
		String uName=properties.getProperty("userName");
		return uName;
	}
	public String getPassword()
	{
		String uPass=properties.getProperty("passWord");
		return uPass;
	}
	public String getBrowser()
	{
		String uBrowser=properties.getProperty("browser");
		return uBrowser;
	}
	public String getChromePath()
	{
		String uChropath=properties.getProperty("chromePath");
		return uChropath;
	}
	
	public String getFirefoxPath()
	{
		String uFirefoxPath=properties.getProperty("firefoxPath");
		return uFirefoxPath;
	}
	
}
