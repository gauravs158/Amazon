package stepDefinitionFiles;


import org.testng.Assert;

import amazonFiles.AmazonCustomerService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetup;

public class AmazonCustomerServiceSD {

	TestContextSetup testContextSetup;
	AmazonCustomerService amazonCustomerService;
	
	public AmazonCustomerServiceSD(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		amazonCustomerService = testContextSetup.pageObjectManager.getAmazonCustomerService();
	}

	@When("the user scrolls down to {string}")
	public void user_scrolls_down_to_BrowseHelpTopics(String elementName) throws InterruptedException {
		amazonCustomerService.scrollToElement();
	}
	
	@And("the user counts the number of links in Customer Service page")
	public void user_counts_number_of_links__in_CustomerServicepage() {
		amazonCustomerService.countLinksOnPage();
	}
	
	@And("the user counts the number of links not working")
	public void user_counts_number_of_links_not_working() {
		amazonCustomerService.checkBrokenLinks();
	}
	
	@Then("all pages are working")
	public void all_pages_are_working() {
		int numberOfBrokenLinks = amazonCustomerService.numberOfBrokenLinks();
		Assert.assertTrue(numberOfBrokenLinks==0, "There are broken links on the page.");
	}
}
