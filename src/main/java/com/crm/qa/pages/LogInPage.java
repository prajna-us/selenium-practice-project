package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LogInPage extends TestBase {
	
	//define pagefactory or object repository
	
	@FindBy(name="email") WebElement userName;
	@FindBy(name="password") WebElement passWord;
	@FindBy(xpath="//div[text()='Login']") WebElement logIn;
	@FindBy(xpath="//div[@class='ui message']/a") WebElement forgotPassword;
	@FindBy(xpath="//a[contains(text(),'Sign Up')]") WebElement signUp;
	@FindBy(xpath="//div[@class='onesignal-bell-launcher-button']") WebElement bellSymbol;
	

	//intializing the pageobjects
	
	public LogInPage() {
		
		PageFactory.initElements(driver,this); // all abovevariables will be initialized with driver.This means current class object.other than this wecan write LogInPage.class
	}
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validatebellSymbol() {
		return bellSymbol.isDisplayed();
		
	}
	
	public HomePage logIn(String uname,String pw) {
		
		userName.sendKeys(uname);
		passWord.sendKeys(pw);
		logIn.click();
		return new HomePage();
		
	}
	
}


