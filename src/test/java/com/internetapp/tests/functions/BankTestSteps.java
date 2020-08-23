package com.internetapp.tests.functions;

import com.codoid.products.exception.FilloException;
import com.internetapp.pages.OutlookHome;
import com.maveric.core.utils.data.ExcelDataReader;

public class BankTestSteps {

	public void functionalSteps(String lifeCycle, String testCase) throws FilloException, InterruptedException {

		BankFunctions bf = new BankFunctions();

		switch (lifeCycle) {

		case "outlookLogin": {
			bf.loginToOutlook(testCase);
			break;
		}
		case "openAirProcess": {
			System.out.println("inside openAirProcess" + ExcelDataReader.getData("Sheet2", testCase, "lifecycle").contains("outlookLogin"));
			if (ExcelDataReader.getData("Sheet2", testCase, "lifecycle").contains("outlookLogin"))
				bf.openAirFromOutlook();
			else
				{
					bf.loginToOutlook(testCase);
					new OutlookHome().clickMenuOpenAir();

				}
			bf.updateTimesheet(testCase);
			break;
		}

		}
	}

}
