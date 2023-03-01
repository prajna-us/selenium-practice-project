package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	// Inside base class read the properties 
	
	public static WebDriver driver; //
	public static Properties prop;
	
	//TestBase class constructor use to intialize the properties object to fetch config(env)variables from config.properties file
	public TestBase() {
			
		
		try {
			
			prop=new Properties();
			FileInputStream fis=new FileInputStream("C:\\Users\\mohan\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(fis);
		}catch(FileNotFoundException x) {
			x.printStackTrace();
		}catch(IOException x) {
			x.printStackTrace();
		}
		
	}
	
	//initialization method
	public static void initialization() {
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.Chrome.driver", "C:\\Users\\mohan\\eclipse-workspace\\numpytest\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver =new ChromeDriver();
			
		}else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.Chrome.driver", "C:\\Users\\mohan\\eclipse-workspace\\numpytest\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver =new FirefoxDriver();
				}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.pageLoadTimeOut));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.ImplicityWaitTimeOut));
		driver.get(prop.getProperty("url"));
		
	}
}
