package amazonFiles;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
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
	
	@FindBy(xpath="//div[@class='navFooterLinkCol navAccessibility']/..")
	WebElement footerSection;
	
	//div[normalize-space()='Get to Know Us']//following-sibling::ul//li
	
//	List<WebElement> listOfElements = driver.findElements(By.xpath("//div[normalize-space()='Get to Know Us']//following-sibling::ul//li"));
	
	public void searchTextBox(String itemName) {
		searchTextBox.clear();
		searchTextBox.sendKeys(itemName);
		a.sendKeys(Keys.ENTER).perform();
	}
	
	public String getURLandingPage() {
		return driver.getCurrentUrl();
	}
	
	public void scrollToElement(String sectionName) throws InterruptedException {
		Thread.sleep(1000);
		if(sectionName.equalsIgnoreCase("footerSection")) {
		new Actions(driver).scrollToElement(footerSection).perform();
		Thread.sleep(1000);}
	}
	//div[normalize-space()='Get to Know Us']//following-sibling::ul//li/a
	public List<WebElement> getListOfLinks(String elementName) {
		List<WebElement> listOfElements = driver.findElements(By.xpath("//div[normalize-space()='"+elementName+"']//following-sibling::ul//li/a"));
		System.out.println("Number of elements in this section is: "+listOfElements.size());
		return listOfElements;
	}

}
