package amazonFiles;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class AmazonCustomerService {
	
	List<WebElement> links;
	int linkCount;
	int brokenLinksCounter;
	Actions a;
	SoftAssert sa = new SoftAssert();
	WebDriverWait wait;	
	WebDriver driver;
	public AmazonCustomerService(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.a = new Actions(driver);
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	}
	
	//@FindBy(xpath="//h1[normalize-space()='Browse Help Topics']")
	//WebElement browseHelpTopics;
	
	WebElement browseHelpTopics = driver.findElement(By.xpath("//h1[normalize-space()='Browse Help Topics']"));

	
	public void countLinksOnPage() {
		links = driver.findElements(By.tagName("a"));
		linkCount = links.size();
		System.out.println("linkCount is: "+linkCount);
	}
	
	public void scrollToElement() throws InterruptedException {
		//Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Actions action = new Actions(driver);
		action.moveToElement(browseHelpTopics).build().perform();
		//action.moveToElement(browseHelpTopics).perform();
		browseHelpTopics.sendKeys(Keys.DOWN);
		Thread.sleep(3000);
	}
	
	public void checkBrokenLinks() {
		
		for(WebElement link : links) {
			String url = link.getDomAttribute("href");
			if (url != null && !url.isEmpty()) {
				verifyLink(url);
			}
		}
	}
	private void verifyLink(String url) {
        try {
            URL link = new URL(url);
            HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
            httpConn.setRequestMethod("HEAD");
            httpConn.connect();

            int responseCode = httpConn.getResponseCode();

            if (responseCode >= 400) {
            	brokenLinksCounter++;
                System.out.println(url + " is a **BROKEN** link (Response Code: " + responseCode + ")");
            } else {
                System.out.println(url + " is a **VALID** link (Response Code: " + responseCode + ")");
            }
        } catch (IOException e) {
            System.out.println(url + " is **BROKEN** due to an exception: " + e.getMessage());
        }
    }
	
	public int numberOfBrokenLinks() {
		System.out.println("Total number of links that are not working on this page is: "+brokenLinksCounter);
		return brokenLinksCounter;		
	}
}
