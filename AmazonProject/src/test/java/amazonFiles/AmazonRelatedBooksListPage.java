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

public class AmazonRelatedBooksListPage {
	WebDriver driver;
	AmazonRelatedBooksListPage amazonRelatedBooksListPage;
	TestContextSetup testContextSetup;
	List<String> bookList = new ArrayList<String>();
	int totalCartValueExpected;
	Actions a;
	SoftAssert sa = new SoftAssert();
	WebDriverWait wait;
	WebElement book;
	WebElement priceTag;

	public AmazonRelatedBooksListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.a = new Actions(driver);
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	}

	private WebElement getBookNameElement(String bookName) {
		bookList.add(bookName);
		book = driver.findElement(By.xpath("//span[normalize-space()='" + bookName + "']"));
		return book;
	}

	public void selectBook(String bookName) {
		WebElement book = getBookNameElement(bookName);
		book.click();
	}
	
	public int getPrice(String bookName) {
		priceTag = driver.findElement(By.xpath("//span[normalize-space()='" + bookName + "']/ancestor::div[@data-cy='title-recipe']/following-sibling::div[@class='puisg-row'][1]//div[@data-cy='price-recipe']//span[@class='a-price-whole']"));
		wait.until(ExpectedConditions.visibilityOfAllElements(priceTag));
		String extractedBookPrice = priceTag.getText();
		String priceWithoutComma = extractedBookPrice.replace(",", "");
    	int bookPrice = Integer.parseInt(priceWithoutComma);
		//return totalCartValueExpected = totalCartValueExpected + bookPrice;
    	return bookPrice;
	}
}
