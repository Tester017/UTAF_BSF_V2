package com.internetapp.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.maveric.core.driver.Driver;
import com.maveric.core.driver.DriverFactory;

import de.retest.recheck.RecheckImpl;
import de.retest.web.selenium.RecheckDriver;

public class CommonFunctions {
	
	DriverFactory driverFactory = new DriverFactory();
    public RecheckImpl recheckin;

	public void startApp(String url, String driverType) {
		try {
	    	recheckin = new RecheckImpl();

			WebDriver driver = Driver.getWebDriver();
			if (driverType.contains("desktop")) {
				driver = driverFactory.driverSetup();
				driver = new RecheckDriver((RemoteWebDriver) driver); 	
			}
			if (driverType.contains("mobile")) {
				driver = driverFactory.mobdriverSetup();
	    		driver = new RecheckDriver((RemoteWebDriver) driver); 
			}
			
			System.out.println("desktop driver is ready");
			recheckin.startTest();
			System.out.println("### recheckin start ###");
	    	System.out.println("Driver Instantiated is : " + driver);


			driver.navigate().to(url);
//			waitForPageLoad();
			System.out.println(driver);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			recheckin.check( driver, "initial" );
	        recheckin.capTest();
//			logScreenshot("login");

		} catch (Exception e) {
			System.err.println("The Browser Could not be Launched. Hence Failed");
			throw new RuntimeException();
		}

	}

}
