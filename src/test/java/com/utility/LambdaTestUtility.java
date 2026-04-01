package com.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LambdaTestUtility {
	 private static final String HUB_URL = "https://hub.lambdatest.com/wd/hub";
	    private static ThreadLocal<WebDriver> driverlocal = new ThreadLocal<WebDriver>();
	    private static ThreadLocal<DesiredCapabilities> capabilitieslocal = new ThreadLocal<DesiredCapabilities>();

	    public static WebDriver intializeLambdaTestSession(String browser,String testName) {
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("browserName", browser);
	        capabilities.setCapability("browserVersion", "127");

	        Map<String, Object> ltOptions = new HashMap<>();
	        ltOptions.put("user", "taarun96");
	        ltOptions.put("accessKey", "LT_EHDsvZKLdtt4mmoTOmjevqI5MefDP1NmhS8dcu6qGb6e1Rz");
	        ltOptions.put("build", "Selenium 4");
	        ltOptions.put("name", testName);
	        ltOptions.put("platformName", "Windows 10");
	        ltOptions.put("seCdp", true);
	        ltOptions.put("selenium_version", "4.23.0");

	        capabilities.setCapability("LT:Options", ltOptions);
	        capabilitieslocal.set(capabilities);
	        WebDriver driver=null;
	        try {
				 driver = new RemoteWebDriver(new URL(HUB_URL), capabilitieslocal.get());
				 driverlocal.set(driver);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        driverlocal.set(driver);
	        
	        return driverlocal.get();
	    }
	    
	    
	    public static void quitSession() {
	        if (driverlocal.get() != null) {
	            driverlocal.get().quit();
	        }
	    }
}
