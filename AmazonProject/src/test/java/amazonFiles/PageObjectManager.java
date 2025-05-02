package amazonFiles;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	public AmazonLandingPage landingPage;
	public AmazonItemPage itemPage;
	public AmazonRelatedBooksListPage relatedBooksListPage;
	public AmazonCartPage cartPage;
	public AmazonCustomerService amazonCustomerService;
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
	
	public AmazonRelatedBooksListPage getAmazonRelatedBooksListPage() {
		relatedBooksListPage = new AmazonRelatedBooksListPage(driver);
		return relatedBooksListPage;
	}
	
	public AmazonCustomerService getAmazonCustomerService() {
		amazonCustomerService = new AmazonCustomerService(driver);
		return amazonCustomerService;
	}
}
