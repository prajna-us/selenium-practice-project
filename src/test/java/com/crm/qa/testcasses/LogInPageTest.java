package com.crm.qa.testcasses;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LogInPage;

public class LogInPageTest extends TestBase{
	 // declar it in class level so through out the program we can use
	//constructor to call super method  and call testbase class constructor.Using super() we will call super class constructor.
	//homepage is the reference variable
	
	LogInPage loginpage;
	HomePage homepage;
	public LogInPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		
		//create loginPage constructor
		loginpage=new LogInPage();
		}
	@Test(priority=1)
	public void loginPageTitleTest() {
		
		String title=loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	@Test(priority=2)
	public void subscribeImageBell() {
		boolean flag =loginpage.validatebellSymbol();
		Assert.assertTrue(flag);
		
	}
	@Test(priority=3)
	public void loginTest() {
		
		homepage =loginpage.logIn(prop.getProperty("username"),prop.getProperty("password"));
		
		
	}
	
	
	
	
	
}
