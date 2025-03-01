package amazonFiles;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class AmazonLandingPage {

	WebDriver driver;
	Actions a;
	SoftAssert sa = new SoftAssert();
	WebDriverWait wait;

	public AmazonLandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.a = new Actions(driver);
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	}
	


	@FindBy(id = "twotabsearchtextbox")
	WebElement searchTextBox;
	
	@FindBy(partialLinkText = "mobile-phones")
	WebElement mobilesNavBtn;
	
	@FindBy(partialLinkText = "Books")
	WebElement booksNavBtn;
	
	@FindBy(partialLinkText = "computers-and-accessories")
	WebElement computersNavBtn;
	
	@FindBy(partialLinkText = "Home-Kitchen")
	WebElement homeKitchenNavBtn;
	
	public void searchTextBox(String bookName) {
		searchTextBox.clear();
		searchTextBox.sendKeys(bookName);
		a.sendKeys(Keys.ENTER).perform();
	}
	
	public String getURLLandingPage() {
		return driver.getCurrentUrl();
	}

}
