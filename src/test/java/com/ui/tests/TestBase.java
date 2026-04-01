package com.ui.tests;



import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import static com.constants.Browser.CHROME;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {
    protected HomePage homePage;
    Logger logger = LoggerUtility.getLogger(this.getClass());
    private boolean isLambdaTest ;
    Browser browserEnum;

    @BeforeMethod(description = "Load the Homepage of the website")
    @Parameters({"browser","isLambdaTest","isHeadless"})
    public void setup(
    		@Optional("chrome") String browser,
    		@Optional("false") boolean isLambdaTest,
    		@Optional("true") boolean isHeadless,
    		ITestResult result) {
        WebDriver lambdaDriver;
        	this.isLambdaTest = isLambdaTest;
   
        if (isLambdaTest) {
            lambdaDriver = LambdaTestUtility.intializeLambdaTestSession(browser,
                    result.getMethod().getMethodName());
            homePage = new HomePage(lambdaDriver);
            
        } else {
            // Running the test on local machine!!!
            logger.info("Load the Homepage of the website");

            try {
                browserEnum = Browser.valueOf(browser.trim().toUpperCase());
            } catch (Exception e) {
                browserEnum = Browser.CHROME;
            }
            homePage = new HomePage(browserEnum, isHeadless);
            
       

        }
    }

    public BrowserUtility getInstance() {
        return homePage;
    }

    @AfterMethod(description = "Tear Down the browser")
    public void tearDown() {
    	if (isLambdaTest) {
			LambdaTestUtility.quitSession();
		}
        homePage.quit(); //local machine session quit
    }
}