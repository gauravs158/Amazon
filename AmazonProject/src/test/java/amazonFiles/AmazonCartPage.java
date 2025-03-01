package amazonFiles;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class AmazonCartPage {
	WebDriver driver;
	Actions a;
	SoftAssert sa = new SoftAssert();
	WebDriverWait wait;
	int totalCartValueExpected;

	public AmazonCartPage(WebDriver driver) {
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
	
	@FindBy(id="sc-subtotal-amount-activecart")
	WebElement itemTotal;
	
	private int cartPageItemTotal() {
		String extractedCartItemTotal = itemTotal.getText();
		
		String cleanedNumber = extractedCartItemTotal.replace("₹", "").replace(",", "").split("\\.")[0].trim();
		return Integer.parseInt(cleanedNumber);		
	}
	
	public void getPrice(String bookName) {
		WebElement priceTag = driver.findElement(By.xpath("//span[normalize-space()='" + bookName + "']/ancestor::div[@data-cy='title-recipe']/following-sibling::div[@class='puisg-row'][1]//div[@data-cy='price-recipe']//span[@class='a-price-whole']"));
		wait.until(ExpectedConditions.visibilityOfAllElements(priceTag));
		String extractedBookPrice = priceTag.getText();
		String priceWithoutComma = extractedBookPrice.replace(",", "");
    	int bookPrice = Integer.parseInt(priceWithoutComma);
		totalCartValueExpected = totalCartValueExpected + bookPrice;
	}
	
	public void verifyCartTotal(int totalCartValueActual) {
		totalCartValueExpected = cartPageItemTotal();
		System.out.println("cartTotal is: "+ totalCartValueActual);
		System.out.println("totalCartValueExpected is: "+ totalCartValueExpected);
		sa.assertEquals(totalCartValueActual, totalCartValueExpected);
		
		//driver.quit();
		sa.assertAll();
	}

	public void verifyAllBooksAdded(List<String> bookList) {

		List<WebElement> books = driver.findElements(By.xpath("//a[@class='a-link-normal sc-product-link sc-product-title aok-block']"));
		for (WebElement ele : books) {
			String bookName = ele.getText();
			bookList.contains(bookName);
			System.out.println("Bookname being verified is:"+bookName);
			System.out.println("Does the list contain " +bookName+ " ? : "+bookList.contains(bookName));
			sa.assertEquals(bookList.contains(bookName), true);
		}
		//driver.quit();
		sa.assertAll();
	}
	
	
}
