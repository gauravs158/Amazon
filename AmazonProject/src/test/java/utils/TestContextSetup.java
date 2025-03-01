package utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import amazonFiles.PageObjectManager;

public class TestContextSetup {

	public WebDriver driver;
	public int cartTotal;
	public List<String> bookList = new ArrayList<>();
	public TestBase testBase;
	public PageObjectManager pageObjectManager;
	public GenericUtils genericUtils;
	
	public TestContextSetup() throws IOException {
		testBase = new TestBase();
		genericUtils = new GenericUtils(testBase.WebDriverManager());
		pageObjectManager = new PageObjectManager(testBase.WebDriverManager());
		
	}
}
