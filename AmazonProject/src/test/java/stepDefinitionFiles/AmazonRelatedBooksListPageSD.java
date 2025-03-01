package stepDefinitionFiles;

import amazonFiles.AmazonRelatedBooksListPage;
import io.cucumber.java.en.*;
import utils.TestContextSetup;

public class AmazonRelatedBooksListPageSD {
	TestContextSetup testContextSetup;
	AmazonRelatedBooksListPage amazonRelatedBooksListPage;
	int total;
	
	public AmazonRelatedBooksListPageSD(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		amazonRelatedBooksListPage = testContextSetup.pageObjectManager.getAmazonRelatedBooksListPage();
	}
	
	@When("^the user selects (.+)$")
	public void the_user_selects_bookName(String bookName) {
		amazonRelatedBooksListPage.selectBook(bookName);
	}
	
	@And("^the user adds (.+) price to total$")
	public void the_user_adds_the_prices_of_all_books(String bookName) {
		testContextSetup.cartTotal = testContextSetup.cartTotal + amazonRelatedBooksListPage.getPrice(bookName);
	}
}
