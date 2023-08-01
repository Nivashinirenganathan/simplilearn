package com.amazon.Swiggy;

import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "Features",
		glue = "com.amazon.Swiggy",
		//dryRun = true
		//tags = "@TC_101"
	    tags = "@product_purchase"
		)


public class TestRunner extends AbstractTestNGCucumberTests{

}
 