package com.internetapp.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.internetapp.tests.functions.BankTestSteps;
import com.maveric.core.testng.BaseTest;
import com.maveric.core.testng.listeners.DriverListener;
import com.maveric.core.utils.data.ExcelDataReader;


public class MavericTest extends BaseTest {

	@DataProvider(name="ExcelInputs",parallel=false)
	public Object[] getExcelData() throws FilloException {
		return ExcelDataReader.getControlData("ControlSheet", "TC_ID");
	}

	@Test(groups = { "web" }, dataProvider = "ExcelInputs")
	public void KeywordTest(String tcId) throws FilloException, InterruptedException {
		DriverListener.testCase.set(tcId);
		String[] lifeCycles = ExcelDataReader.getData("Sheet2", tcId, "lifecycle").split(";");

		for (String lifeCycle : lifeCycles) {
			System.out.println(lifeCycle);
			new BankTestSteps().functionalSteps(lifeCycle, tcId);
		}
		
	}
}
