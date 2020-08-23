package com.androidapp.tests;

 

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.testng.annotations.*;

import com.maveric.core.testng.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

	public class ExperitestClient2 extends BaseTest{

	    private String accessKey = "eyJ4cC51Ijo0NTU2OTcsInhwLnAiOjQ1NTY4OSwieHAubSI6Ik1UVTRPVE0yTnprMU1EQXlNdyIsImFsZyI6IkhTMjU2In0.eyJleHAiOjE5MDQ3Mjc5NTAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.9PEKvslTXNVQjibm_oLIBni8iknsIwo1etQfjBMQ8ME";
	    protected IOSDriver<IOSElement> driver = null;
	    DesiredCapabilities dc = new DesiredCapabilities();

	    @BeforeTest
	    public void setUp() throws MalformedURLException {
	        dc.setCapability("testName", "Quick Start iOS Native Demo");
	        dc.setCapability("accessKey", accessKey);
	        dc.setCapability("deviceQuery", "@os='ios' and @category='PHONE'");
	        
	        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
	        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
	        driver = new IOSDriver<>(new URL("https://demo.experitest.com/wd/hub"), dc);
	        System.out.println("iOS IS SET");
	    }

	    @Test
	    public void quickStartiOSNativeDemo() {
	    	
	    	System.out.println("### Entering Test iOS #####");
	    	 driver.rotate(ScreenOrientation.PORTRAIT);
	         driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
	         driver.hideKeyboard();
	         driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
	         driver.findElement(By.xpath("//*[@id='loginButton']")).click();
	         driver.findElement(By.xpath("//*[@id='makePaymentButton']")).click();
	         driver.findElement(By.xpath("//*[@id='phoneTextField']")).sendKeys("0541234567");
	         driver.findElement(By.xpath("//*[@id='nameTextField']")).sendKeys("Jon Snow");
	         driver.findElement(By.xpath("//*[@id='amountTextField']")).sendKeys("50");
	         driver.findElement(By.xpath("//*[@id='countryButton']")).click();
	         driver.findElement(By.xpath("//*[@id='Switzerland']")).click();
	         driver.findElement(By.xpath("//*[@id='sendPaymentButton']")).click();
	         driver.findElement(By.xpath("//*[@id='Yes']")).click();
	         System.out.println("### Completed Test #####");         
	
	    }

	    @AfterTest
	    public void tearDown() {
	        System.out.println("Report URL: "+ driver.getCapabilities().getCapability("reportUrl"));
	        driver.quit();
	    }
}



