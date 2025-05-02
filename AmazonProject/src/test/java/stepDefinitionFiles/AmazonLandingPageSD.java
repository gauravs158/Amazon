package stepDefinitionFiles;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import amazonFiles.AmazonLandingPage;
import io.cucumber.java.en.*;
import utils.TestContextSetup;

public class AmazonLandingPageSD {
	TestContextSetup testContextSetup;
	AmazonLandingPage amazonLandingPage;
	List<WebElement> list;
	SoftAssert sa = new SoftAssert();
	String links;
	int brokenLinkCounter=0;
	public AmazonLandingPageSD(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		amazonLandingPage = testContextSetup.pageObjectManager.getAmazonLandingPage();
	}
	
	@Given("the user is on Amazon homepage")
	public void the_user_is_on_Amazon_homepage() {
		Assert.assertTrue(amazonLandingPage.getURLandingPage().equalsIgnoreCase("https://www.amazon.in/"));
	}
	
	@When("^the user searches for (.+)$")
	public void the_user_searches_for_itemName(String itemName) {
		amazonLandingPage.searchTextBox(itemName);
	}
	
	@When("^the user adds (.+) to itemList$")
	public void the_user_adds_book_to_itemList(String itemName) {
		testContextSetup.itemList.add(itemName);		
	}
	
	@And("the user scrolls down to the footer section")
	public void the_user_scrolls_down_to_the_footer_section() throws InterruptedException {
		amazonLandingPage.scrollToElement("footerSection");
	}
	
	@And("^the user counts the number of broken links present in the (.+) section$")
	public void the_user_counts_the_number_of_broken_links_present_in_the_section(String sectionName) throws IOException {
		list = amazonLandingPage.getListOfLinks(sectionName);
		int code;
		for(WebElement we : list) {
			links=we.getDomAttribute("href");
			URL link=new URL(links);
			HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
			httpConn.connect();
			code = httpConn.getResponseCode();
			if(code >= 400)
		      {
				brokenLinkCounter++;
		        System.out.println("Broken Link: " + links);
		      }
		      else
		      {
		        System.out.println("Valid Link: " + links);
		      }
			httpConn.disconnect();
		}
	}
	
	@And("^the user counts the number of links present in the (.+) section$")
	public void the_user_counts_the_number_of_links_present_in_the_section(String sectionName) {
		list = amazonLandingPage.getListOfLinks(sectionName);
		for(WebElement we : list) {
			System.out.println(we.getDomAttribute("href"));
		}
	}
	
	@And("^the count is (.+)$")
	public void the_count_is(int count) {
		System.out.println("brokenLinkCounter "+brokenLinkCounter);
		System.out.println("count "+count);
		sa.assertEquals(brokenLinkCounter, count);
		sa.assertAll();
	}
}