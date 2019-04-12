package com.naukri.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base 
{
	public static WebDriver driver;
	public static Properties prop;
	
	public static String configFilePath= "C:\\Users\\kumar.sushobhan\\OneDrive - Accenture\\Eclipse Work\\NaukriAutomation\\src\\config\\configuration.properties";

	
	public Base() throws IOException {
		prop= new Properties();
		System.out.println(prop);
		FileInputStream fis= new FileInputStream(new File("C:\\Users\\kumar.sushobhan\\OneDrive - Accenture\\Eclipse Work\\NaukriAutomation\\src\\config\\configuration.properties"));
		prop.load(fis);
	}
	
	public static void initialize()
	{
		System.out.println(configFilePath);
		String browserName= prop.getProperty("browser");
		String url= prop.getProperty("url");
		
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
			driver= new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir"+"\\src\\drivers\\chromedriver.exe"));
			driver= new FirefoxDriver();
			break;
		default:
			System.out.println("No browser is provided");
			break;
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(url);
	}
}
