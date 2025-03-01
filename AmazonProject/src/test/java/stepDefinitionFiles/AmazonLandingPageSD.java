package stepDefinitionFiles;

import org.testng.Assert;

import amazonFiles.AmazonLandingPage;
import io.cucumber.java.en.*;
import utils.TestContextSetup;

public class AmazonLandingPageSD {
	TestContextSetup testContextSetup;
	AmazonLandingPage amazonLandingPage;
	
	public AmazonLandingPageSD(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		amazonLandingPage = testContextSetup.pageObjectManager.getAmazonLandingPage();
	}
	
	@Given("the user is on Amazon homepage")
	public void the_user_is_on_Amazon_homepage() {
		Assert.assertTrue(amazonLandingPage.getURLLandingPage().equalsIgnoreCase("https://www.amazon.in/"));
	}
	
	@When("^the user searches for (.+)$")
	public void the_user_searches_for_bookName(String bookName) {
		amazonLandingPage.searchTextBox(bookName);
	}
	
	@When("^the user adds (.+) to bookList$")
	public void the_user_adds_book_to_bookList(String bookName) {
		testContextSetup.bookList.add(bookName);		
	}
}
