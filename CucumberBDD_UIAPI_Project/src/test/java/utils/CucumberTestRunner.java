package utils;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		tags="@StudentRegistrationForm",
		features={"src/test/resources/features"},
		glue={"stepDefinitions","appHooks"},
		plugin={"pretty","html:target/reports/htmlreport.html"})

public class CucumberTestRunner extends AbstractTestNGCucumberTests {


}
