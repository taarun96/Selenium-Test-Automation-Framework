package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;

import static com.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtility{
	
	public HomePage(Browser browserName,boolean isHeadless) {
		super(browserName,isHeadless);
		// TO call parent class constructor from child class constructor
		//goToWebSite(readProperty(QA, "URL"));
		goToWebSite(JSONUtility.readJSON(QA).getUrl());
	}


	


	private  static final By SIGN_IN_LINK_LOCATOR	=By.xpath("//a[contains(text(),'Sign in')]");    //CLASS VARIABLE
	
	
	public LoginPage goToLoginPage() {
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage=new LoginPage(getDriver());
		return loginPage;
	}

	
	
	public HomePage(WebDriver driver) {
	    super(driver); // To Call the Parent Class constructor from the child constructor
	    goToWebSite(JSONUtility.readJSON(QA).getUrl());
	}
	
	
	
	
	
	
	public void quit() {
	    if (getDriver() != null) {
	        getDriver().quit();   // closes browser session
	             // removes ThreadLocal (very important)
	    }
}
	
}
