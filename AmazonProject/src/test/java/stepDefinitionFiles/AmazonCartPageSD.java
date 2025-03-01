package stepDefinitionFiles;

import amazonFiles.AmazonCartPage;
import io.cucumber.java.en.*;
import utils.TestContextSetup;

public class AmazonCartPageSD {
	TestContextSetup testContextSetup;
	AmazonCartPage amazonCartPage;
	
	public AmazonCartPageSD(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		amazonCartPage = testContextSetup.pageObjectManager.getAmazonCartPage();
	}

	@Then("all books are displayed in the cart")
	public void all_books_are_displayed_in_the_cart() {

		amazonCartPage.verifyAllBooksAdded(testContextSetup.bookList);
	}

	@Then("total displayed in cart page should be equal to the total book price")
	public void total_displayed_in_cart_page_should_be_equal_to_total_bookprice() {
		amazonCartPage.verifyCartTotal(testContextSetup.cartTotal);
	}
}
