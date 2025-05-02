package amazonFiles;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import utils.TestContextSetup;

public class AmazonRelatedItemsListPage {
	WebDriver driver;
	AmazonRelatedItemsListPage amazonRelatedItemsListPage;
	TestContextSetup testContextSetup;
	List<String> bookList = new ArrayList<String>();
	int totalCartValueExpected;
	Actions a;
	SoftAssert sa = new SoftAssert();
	WebDriverWait wait;
	WebElement book;
	WebElement priceTag;

	public AmazonRelatedItemsListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.a = new Actions(driver);
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	}

	private WebElement getItemNameElement(String itemName) {
		bookList.add(itemName);
		book = driver.findElement(By.xpath("//span[normalize-space()='" + itemName + "']"));
		return book;
	}

	private WebElement getItemNameElement(String itemName, String extraInfo) {
		bookList.add(itemName);
		book = driver.findElement(By.xpath("//span[contains(text(), '"+itemName+"') and contains(text(), '"+extraInfo+"')]"));
		return book;
	}

	public void selectItem(String itemName) {
		WebElement item = getItemNameElement(itemName);
		item.click();
	}

	public void selectItem(String itemName, String extraInfo) {
		WebElement item = getItemNameElement(itemName, extraInfo);
		item.click();
	}
	
	public int getPrice(String itemName) {
		priceTag = driver.findElement(By.xpath("//span[normalize-space()='" + itemName + "']/ancestor::div[@data-cy='title-recipe']/following-sibling::div[@class='puisg-row'][1]//div[@data-cy='price-recipe']//span[@class='a-price-whole']"));
		wait.until(ExpectedConditions.visibilityOfAllElements(priceTag));
		String extractedBookPrice = priceTag.getText();
		String priceWithoutComma = extractedBookPrice.replace(",", "");
    	int bookPrice = Integer.parseInt(priceWithoutComma);
		//return totalCartValueExpected = totalCartValueExpected + bookPrice;
    	return bookPrice;
	}
}
