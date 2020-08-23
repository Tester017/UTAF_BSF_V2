package com.maveric.core.common.functions;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.maveric.core.driver.DriverFactory;
import com.maveric.core.utils.web.WebActions;

public class CommonDef extends WebActions{
	
    DriverFactory driverFactory=new DriverFactory();

    public String now() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMHmmss");
		return sdf.format(cal.getTime());
	}
	public void startApp(String url, String driverType) {
		try {
			if (driverType.contains("desktop")) {
				driver = driverFactory.driverSetup();
//	    		driver = new RecheckDriver((RemoteWebDriver) driver); 	
			}
			if (driverType.contains("mobile")) {
				driver = driverFactory.mobdriverSetup();
//	    		driver = new RecheckDriver((RemoteWebDriver) driver); 
			}

			driver.navigate().to(url);
//			waitForPageLoad();
			System.out.println(driver);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			logScreenshot("login");

		} catch (Exception e) {
			System.err.println("The Browser Could not be Launched. Hence Failed");
			throw new RuntimeException();
		}

	}

	/* Desc: Find an Element */
	public WebElement findElement(By by) {
		WebDriver driver = getWebdriver();
		return driver.findElement(by);
	}

	/* Desc: Click an Element */
	public void click(WebElement ele) {
		String text = "";
		try {
			WebDriver driver = getWebdriver();
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			text = ele.getText();
			ele.click();
			logScreenshot("The Element " + text + " clicked");
		} catch (StaleElementReferenceException e) {
			logScreenshot("The Element " + text + " could not be clicked");
			throw new RuntimeException();
		}
	}

	/* Desc: Click an Element */
	public void click(By by) {
		String text = "";
		WebElement ele = findElement(by);
		try {
			WebDriver driver = getWebdriver();
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			text = ele.getText();
			ele.click();
			logScreenshot("The Element " + text + " clicked");
		} catch (StaleElementReferenceException e) {
			logScreenshot("The Element " + text + " could not be clicked");
			throw new RuntimeException();
		}
	}
	
	public void click(By by, String text) {
		WebElement ele = findElement(by);
		try {
			WebDriver driver = getWebdriver();
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			logScreenshot("The Element " + text + " clicked");
		} catch (StaleElementReferenceException e) {
			logScreenshot("The Element " + text + " could not be clicked");
			throw new RuntimeException();
		}
	}

	/* Desc: Click an Element using JavaScript */
	public void clickJS(WebElement ele) {
		String text = "";
		try {
			WebDriver driver = getWebdriver();
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			text = ele.getText();
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", ele);
			logScreenshot("The Element " + text + " clicked");
		} catch (Exception E) {
			logScreenshot("The Element " + ele + " could not be clicked");
			throw new RuntimeException();
		}
	}

	/* Desc: Click an Element using JavaScript */
	public void clickJS(By by) {
		String text = "";
		WebElement ele = findElement(by);
		try {
			WebDriver driver = getWebdriver();
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			text = ele.getText();
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", ele);
			logScreenshot("The Element " + text + " clicked");
		} catch (Exception E) {
			logScreenshot("The Element " + ele + " could not be clicked");
			throw new RuntimeException();
		}
	}

	/* Desc: Clear and Send Keys to Text Box */
	public void clearAndType(WebElement ele, String data) {
		try {
			WebDriver driver = getWebdriver();
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.clear();
			ele.sendKeys(data);
			logScreenshot("The Data :" + data + " entered Successfully");
		} catch (ElementNotInteractableException e) {
			logScreenshot("The Element " + ele + " is not Interactable");
			throw new RuntimeException();
		}
	}

	/* Desc: Clear and Send Keys to Text Box */
	public void clearAndType(By by, String data) {
		WebElement ele = findElement(by);
		try {
			WebDriver driver = getWebdriver();
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.clear();
			ele.sendKeys(data);
			logScreenshot("The Data :" + data + " entered Successfully");
		} catch (ElementNotInteractableException e) {
			logScreenshot("The Element " + ele + " is not Interactable");
			throw new RuntimeException();
		}
	}

	/* Desc: Send Keys to Text Box */
	public void sendKeys(WebElement ele, String data) {
		try {
			WebDriver driver = getWebdriver();
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.sendKeys(data);
			logScreenshot("The Data :" + data + " entered Successfully");
		} catch (ElementNotInteractableException e) {
			logScreenshot("The Element " + ele + " is not Interactable");
			throw new RuntimeException();
		}
	}

	/* Desc: Send Keys to Text Box */
	public void sendKeys(By by, String data) {
		WebElement ele = findElement(by);
		try {
			WebDriver driver = getWebdriver();
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.sendKeys(data);
			logScreenshot("The Data :" + data + " entered Successfully");
		} catch (ElementNotInteractableException e) {
			logScreenshot("The Element " + ele + " is not Interactable");
			throw new RuntimeException();
		}
	}

	/* Desc: Wait for Page to Load */
	public void waitForPageLoad() {
		WebDriver driver = getWebdriver();
		ExpectedCondition<Boolean> expect = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				System.out.println(driver);

				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		wait = new WebDriverWait(driver, 120);
		try {
			wait.until(expect);
		} catch (Exception E) {
//			ExReporter.log(LogStatus.INFO, "Page Load Condition failed. Continuing with test");
		}
	}

	/* Desc: Select a value from Drop Down */
	public void dropdown(WebElement ele, String keysToSend) {
		try {
			Select select = new Select(ele);
			select.selectByVisibleText(keysToSend);
			logScreenshot(keysToSend + " is selected successfully ");
		} catch (NoSuchElementException E) {
			logScreenshot(keysToSend + " is not selected successfully ");
			throw new RuntimeException();
		}catch (Exception E) {
			logScreenshot(keysToSend + " is not selected successfully ");
			throw new RuntimeException();
		}
	}

	/* Desc: Select a value from Drop Down */
	public void dropdown(By by, String keysToSend) {
		WebElement ele = findElement(by);
		try {
		Select select= new Select(ele);
		select.selectByVisibleText(keysToSend);
		logScreenshot(keysToSend+" is selected successfully ");
		} catch (Exception E) {
			logScreenshot(keysToSend + " is not selected successfully ");
			throw new RuntimeException();
		}
	}

	public void switch_Window(By by) {

		try {
			WebDriver driver = getWebdriver();
			Set<String> win = driver.getWindowHandles();
			click(by);
			Set<String> win2 = driver.getWindowHandles();
			for (String w : win2)
				if (!win.contains(w))
					driver.switchTo().window(w);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*public String captureScreen() {
		String path;
		File trgtPath = null;
		try {
			File source=null;
			WebDriver driver = getWebdriver();
				WebDriver augmentedDriver = new Augmenter().augment(driver);
				source = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
			String temp = ConfigProvider.getConfig("Testname") + "/" +TestData.getConfig("DataBinding") + "/" + TestData.getConfig("DataBinding")+ "_" + now() + ".png";
			path = ExReporter.reportPath + "/" + temp;
			//System.out.println(path);
			trgtPath = new File(path);

			FileUtils.copyFile(source, trgtPath);
			//return source.getName();// trgtPath.getAbsolutePath();
			return temp;
		} catch (Exception e) {
			return "";
		}
		// return trgtPath.getAbsolutePath();

	}*/
}
