package com.internetapp.tests.functions;

import com.codoid.products.exception.FilloException;
import io.cucumber.java.Scenario;
import io.cucumber.java8.En;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CucumberTestSteps implements En {
	
String tcId;
BankFunctions bf = new BankFunctions();
	
	@io.cucumber.java.Before
	public void before(Scenario scenario) {
	     //this.sce = scenario
		 this.tcId=scenario.getName().split("_")[0];
	     System.out.println(">>>>>>-------"+scenario.getName());
	     System.out.println(">>>>>>-------"+scenario.getId());
	     System.out.println(">>>>>>-------"+tcId);
	}
	
	public CucumberTestSteps() {
    	
  	  Given("Login to outlook", () -> { bf.loginToOutlook(tcId); });
  	  Then("Navigate to open air from outlook", () -> {bf.openAirFromOutlook();});
  	  And("Open time sheet editor", () -> { bf.navigateToTS(tcId); });
  	  And("Update and submit time sheet", () -> { bf.updateTimesheet(tcId); });
  	  
	}
	
	
	/*@Given("Login to outlook")
	public void login_to_outlook() throws FilloException {
		bf.loginToOutlook(tcId); 
	}
	@Then("Navigate to open air from outlook")
	public void openAirFromOutlook(){
		bf.openAirFromOutlook(); 
	}
	@And("Open time sheet editor")
	public void navigateToTS() throws FilloException, InterruptedException {
		bf.navigateToTS(tcId);
	}

	@And("Update and submit time sheet")
	public void updateTimesheet() throws FilloException, InterruptedException {
		bf.updateTimesheet(tcId);
	}*/

}
