package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/featureFiles",
glue="stepDefinitionFiles", monochrome=true,
dryRun=false,
plugin = {
//        "json:build/cucumber-reports/cucumber.json",
//        "rerun:build/cucumber-reports/rerun.txt",
//        "pretty:target/cucumber.html",
		"html:target/cucumber.html",
        "json:target/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
//        "com.aventstack.chaintest.plugins.ChainTestCucumberListeners:",
        "rerun:target/failed_scenarios.txt"
  }
)
public class TestNGRunner extends AbstractTestNGCucumberTests{

	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
}