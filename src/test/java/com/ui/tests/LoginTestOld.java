package com.ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;

public class LoginTestOld {
	public static void main(String[] args) {
		WebDriver wd=new ChromeDriver();
		HomePage homePage=new HomePage(wd);
		LoginPage loginPage=homePage.goToLoginPage();
		loginPage.doLoginWith("memero1542@smkanba.com", "password");
		
	}
}
