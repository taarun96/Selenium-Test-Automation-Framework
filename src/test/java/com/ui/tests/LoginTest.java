package com.ui.tests;

import static com.constants.Browser.CHROME;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojos.User;




@Listeners(com.ui.Listeners.TestListener.class)
public class LoginTest extends TestBase{
	


	@Test(
			description="Verify login for a user",
			groups= {"e2e","sanity"},
			dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,
			dataProvider="LoginTestDataProvider"
		)
	public void loginTest(User user) {
	
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(),"Jack Kumar");
		//assertEquals(userName,"Jack Kumar");
		
	}
/*
	@Test(
		    description = "Verifies with the valid user is able to login into the application",
		    groups = { "e2e", "sanity" },
		    dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,
		    dataProvider = "LoginTestCSVDataProvider"
		)
		public void loginCSVTest(User user) {

		    assertEquals(
		        homePage.goToLoginPage()
		                .doLoginWith(user.getEmailAddress(), user.getPassword())
		                .getUserName(),
		        "Jack Kumar"
		    );
		}

	
	@Test(
		    description = "Verifies with the valid user is able to login into the application",
		    groups = { "e2e", "sanity" },
		    dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,
		    dataProvider = "LoginTestExcelDataProvider",
		    retryAnalyzer = com.ui.Listeners.MyRetryAnalyzer.class
		)
		public void loginExcelTest(User user) {
	

		    assertEquals(
		        homePage.goToLoginPage()
		                .doLoginWith(user.getEmailAddress(), user.getPassword())
		                .getUserName(),
		        "Jack Kumar1"
		    );
	
		}
		*/
}
