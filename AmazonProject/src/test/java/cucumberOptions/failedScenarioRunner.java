package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="",
glue="stepDefinitionFiles", monochrome=true,
dryRun=false,
plugin = {
        "json:build/cucumber-reports/cucumber.json",
        "rerun:build/cucumber-reports/rerun.txt",
        "pretty:target/cucumber.html",
        "json:target/cucumber.json",
        "com.aventstack.chaintest.plugins.ChainTestCucumberListeners:",
        "rerun:target/failed_scenarios.txt"
  })

public class failedScenarioRunner  extends AbstractTestNGCucumberTests{

}
