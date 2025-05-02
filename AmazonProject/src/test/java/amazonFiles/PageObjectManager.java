package amazonFiles;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	public AmazonLandingPage landingPage;
	public AmazonItemPage itemPage;
	public AmazonRelatedItemsListPage relatedItemsListPage;
	public AmazonCartPage cartPage;
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public AmazonLandingPage getAmazonLandingPage() {
		landingPage = new AmazonLandingPage(driver);
		return landingPage;
	}
	
	public AmazonCartPage getAmazonCartPage() {
		cartPage = new AmazonCartPage(driver);
		return cartPage;
	}
	
	public AmazonItemPage getAmazonItemPage() {
		itemPage = new AmazonItemPage(driver);
		return itemPage;
	}
	
	public AmazonRelatedItemsListPage getAmazonRelatedItemsListPage() {
		relatedItemsListPage = new AmazonRelatedItemsListPage(driver);
		return relatedItemsListPage;
	}
}
