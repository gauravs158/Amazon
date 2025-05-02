package stepDefinitionFiles;

import amazonFiles.AmazonItemPage;
import io.cucumber.java.en.*;
import utils.TestContextSetup;

public class AmazonItemPageSD {
	TestContextSetup testContextSetup;
	AmazonItemPage amazonItemPage;
	
	public AmazonItemPageSD(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		amazonItemPage = testContextSetup.pageObjectManager.getAmazonItemPage();
	}
	
	@When("^the user clicks AddToCart button on (.+)$")
	public void the_user_clicks_add_to_cart_button(String bookName) {
		
		amazonItemPage.addToCart();
	}
	
	@And("^the user clicks AddToCart button if globalRatings is > 300 and starRating is > 4$")
	public void the_user_clicks_AddToCart_if_reviewCount_GreaterThan_300_and_StarRating_GreaterThan_4() {
		amazonItemPage.conditionalReviewAndStarAddToCart();
	}
	
	@When("the user navigates to the cart")
	public void the_user_navigates_to_the_cart() {

		amazonItemPage.goToCartPage();
	}
}
