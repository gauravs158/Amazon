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

		amazonCartPage.verifyAllBooksAdded(testContextSetup.itemList);
	}

	@Then("total displayed in cart page should be equal to the total book price")
	public void total_displayed_in_cart_page_should_be_equal_to_total_bookprice() {
		amazonCartPage.verifyCartTotal(testContextSetup.cartTotal);
	}
	
	@Then("all items with GlobalRatings > 300 and StarRatings > 4 are displayed in the cart")
	public void all_items_with_GlobalRatings_GreaterThan300_and_StarRatings_GreaterThan4_are_displayed_in_cart() {
		
	}
}
