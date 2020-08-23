package com.androidapp.tests;

import com.androidapp.pages.LoginPage;
import com.androidapp.pages.ProductPage;
import com.maveric.core.driver.Driver;
import com.maveric.core.driver.DriverFactory;
import com.maveric.core.driver.RemoteCapabilities;
import com.maveric.core.testng.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AndroidTests extends BaseTest {

    public DriverFactory driverFactory = new DriverFactory();
    RemoteCapabilities remoteCapabilities = new RemoteCapabilities(DriverFactory.Platform.android , DriverFactory.Browser.chrome, RemoteCapabilities.driver);
    
    @BeforeMethod(alwaysRun = true)
    private void testbeforeMethod() {
    	System.out.println("My Test Before Method");
    	driverFactory.createRemoteDriverUpdated();     	
    }

    @Test(enabled = true, groups = {"android"})
    public void EriBank() {
    	System.out.println("ENTERED TEST********************");
    	   	
    	AndroidDriver<AndroidElement> driver = remoteCapabilities.driver;
    	
    	if (driver.toString()==""){
    		System.out.println("&&& Driver is not available &&&");
    	}
    	
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.navigate().back();
    	System.out.println("&&& Browser Capabilities set and execution ON &&&");
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.findElementById("com.experitest.ExperiBank:id/usernameTextField").sendKeys("company");
    	driver.findElementById("com.experitest.ExperiBank:id/passwordTextField").sendKeys("company");
    	driver.findElementById("com.experitest.ExperiBank:id/loginButton").click();
		
		if (driver.findElementById("android:id/button1").isDisplayed()){
			driver.navigate().back();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("com.experitest.ExperiBank:id/makePaymentButton").click();
		
		if (driver.findElementById("android:id/button1").isDisplayed()){
			driver.navigate().back();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("com.experitest.ExperiBank:id/phoneTextField").sendKeys("9878976543");
		driver.findElementById("com.experitest.ExperiBank:id/nameTextField").sendKeys("testuser");
		driver.findElementById("com.experitest.ExperiBank:id/amount").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementById("com.experitest.ExperiBank:id/countryButton").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (driver.findElementById("android:id/button1").isDisplayed()){
			driver.navigate().back();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ListView/android.widget.TextView[1]").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("com.experitest.ExperiBank:id/sendPaymentButton").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("android:id/button1").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("com.experitest.ExperiBank:id/logoutButton").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().back();	

    }

}
