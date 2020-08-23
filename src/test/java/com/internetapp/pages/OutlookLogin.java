package com.internetapp.pages;

import static com.maveric.core.utils.reporter.Report.log;

import org.openqa.selenium.By;
import com.maveric.core.common.functions.CommonDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

/*import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;*/


public class OutlookLogin extends CommonDef{
	
//	@Given("^Navigate to outlook with \"([^\"]*)\" and \"([^\"]*)\"$")
	public OutlookLogin outlookNavigate(String url,String driverType) 
	{   
    	startApp(url, driverType);    
//		new CommonFunctions().startApp(url, driverType);
        return this;
    }
	
	public OutlookLogin enterUserName(String dUserName) 
	{     
    	clearAndType(findElement(By.name("loginfmt")), dUserName);                 
        return this;
    }
	public OutlookLogin enterPassword(String dPassword) 
	{      
    	clearAndType(findElement(By.name("passwd")), dPassword);                 
        return this;
    }
	public OutlookLogin clickNext() 
	{      
    	click(findElement(By.id("idSIButton9")));                 
        return this;
    }
	public OutlookHome clickStaySignNo() 
	{      
    	click(findElement(By.id("idBtn_Back")));                 
        return new OutlookHome();
    }
	
	/*@Given("Navigate to outlook with {string} and {string}")
	public OutlookLogin outlookNavigate(String url,String driverType) 
	{   
	startApp("http://mail.maveric-systems.com/", "desktop");   
//    	startApp(url, driverType);    
//		new CommonFunctions().startApp(url, driverType);
        return this;
    }
	
	@Then("Enter User Name")
	public OutlookLogin enterUserName1() 
	{     
    	clearAndType(findElement(By.name("loginfmt")), "danielf@maveric-systems.com");                 
        return this;
    }
	@And("Enter Password")
	public OutlookLogin enterPassword1() 
	{      
    	clearAndType(findElement(By.name("passwd")), "Mavaug@123");                 
        return this;
    }
	@And("Click enter")
	public OutlookLogin clickNext1() 
	{      
    	click(findElement(By.id("idSIButton9")));                 
        return this;
    }
	@And("Click No to Stay Sign in")
	public OutlookHome clickStaySignNo1() 
	{      
    	click(findElement(By.id("idBtn_Back")));                 
        return new OutlookHome();
    }*/


}
