package com.internetapp.tests;

import org.testng.annotations.Test;

import com.maveric.core.cucumber.CucumberBaseTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"./src/test/resources/features/OutlookLogin.feature"},
        tags = "@tag3",
        glue = {"com.internetapp.tests.functions"},
        monochrome=true
)
public class CucumberRunner extends CucumberBaseTest {


}

/*public class CucumberRunner extends AbstractTestNGCucumberTests {


}*/