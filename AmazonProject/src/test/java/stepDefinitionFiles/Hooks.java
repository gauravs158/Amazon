package stepDefinitionFiles;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	
	public TakesScreenshot scrShot;
	public TestContextSetup testContextSetup;
	
	public Hooks(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@After
	public void afterExecution() throws IOException{
		testContextSetup.testBase.WebDriverManager().quit();
	}
	
	@AfterStep
	public void afterStepExecution(Scenario scenario) throws IOException {
		
		WebDriver driver = testContextSetup.testBase.WebDriverManager();
		if(scenario.isFailed()) {
			scrShot = ((TakesScreenshot) driver);
	        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
	        byte[] fileContent = FileUtils.readFileToByteArray(SrcFile);
	        scenario.attach(fileContent, "image/png", "image");
		}
	}
}
