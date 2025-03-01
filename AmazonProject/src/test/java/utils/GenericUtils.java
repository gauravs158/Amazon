package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	public WebDriver driver;
	String parentWindow;
	String childWindow;
	Iterator<String> it;
	Set<String> handles;
	
	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver switchToRequiredWindow(String requiredWindow) {
		handles = driver.getWindowHandles();
		it = handles.iterator();
		while (it.hasNext()) {
			parentWindow = it.next();
			childWindow = it.next();
		}
		
//		if(requiredWindow.equalsIgnoreCase("parentWindow") && !driver.getWindowHandle().equalsIgnoreCase(parentWindow))
//		return driver.switchTo().window(parentWindow);
//		else 
			if(requiredWindow.equalsIgnoreCase("childWindow") && !driver.getWindowHandle().equalsIgnoreCase(childWindow))
			return driver.switchTo().window(childWindow);
		else {return driver.switchTo().window(parentWindow);}
	}
}
