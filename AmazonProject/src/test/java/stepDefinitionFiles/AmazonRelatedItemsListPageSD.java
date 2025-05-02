package stepDefinitionFiles;

import amazonFiles.AmazonRelatedItemsListPage;
import io.cucumber.java.en.*;
import utils.TestContextSetup;

public class AmazonRelatedItemsListPageSD {
	TestContextSetup testContextSetup;
	AmazonRelatedItemsListPage amazonRelatedItemsListPage;
	int total;
	
	public AmazonRelatedItemsListPageSD(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		amazonRelatedItemsListPage = testContextSetup.pageObjectManager.getAmazonRelatedItemsListPage();
	}
	
	@When("^the user selects (.+)$")
	public void the_user_selects_itemName(String itemName) {
		amazonRelatedItemsListPage.selectItem(itemName);
	}
	
	@When("^the user clicks (.+) with (.+)$")
	public void the_user_selects_itemName(String itemName, String extraInfo) {
		amazonRelatedItemsListPage.selectItem(itemName, extraInfo);
	}
	
	@And("^the user adds (.+) price to total$")
	public void the_user_adds_the_prices_of_all_books(String bookName) {
		testContextSetup.cartTotal = testContextSetup.cartTotal + amazonRelatedItemsListPage.getPrice(bookName);
	}
}
