package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	public static WebDriverWait wait;
	public static WebDriver driver;
	
	public WaitUtility(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	private static void explicitwait(String xpath)
	{
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	}
	private static void fluentWait()
	{
		
	}
	
}
