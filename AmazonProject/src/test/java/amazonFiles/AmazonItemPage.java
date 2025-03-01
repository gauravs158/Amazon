package amazonFiles;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class AmazonItemPage {

	WebDriver driver;
	Actions a;
	SoftAssert sa = new SoftAssert();
	WebDriverWait wait;	
	List<String> bookList = new ArrayList<String>();
	//TestContextSetup testContextSetup;

	public AmazonItemPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.a = new Actions(driver);
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	}

	@FindBy(id = "nav-cart")
	WebElement cartIcon;

	@FindBy(id = "add-to-cart-button")
	WebElement addToCartBtn;

	public void addToCart() {
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			String landingPage = it.next();
			String bookPage = it.next();
			driver.switchTo().window(bookPage);
			addToCartBtn.click();
			driver.close();
			driver.switchTo().window(landingPage);
		}
	}

	public void goToCartPage() {
		cartIcon.click();
	}

}
