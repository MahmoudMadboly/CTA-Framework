package utilities;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrowserUtils {
	
	//static WebDriver driver;
	//static JavascriptExecutor js = (JavascriptExecutor) driver;

	//some browser based methods
	
	
	//scroll to a specific element
	public static void scrollIntoElement(WebDriver driver , WebElement element) {


		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
	}


	public static void scrollIntoElementByPixel(WebDriver driver , String pixel) {

		
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0, arguments[0]);", Integer.parseInt(pixel));

	}
	
	
	//scroll down
	public void scrollDown(WebDriver driver) {
		
		// Scroll to top first (optional, to ensure starting from top)
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, 0);");
		
		// Get the height of the entire page
		long pageHeight = (long) ((JavascriptExecutor)driver).executeScript("return document.body.scrollHeight");
		
		
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, arguments[0]);", pageHeight);
		
		
	}

		
	
	//scroll Up
		public void scrollUp(WebDriver driver) {
			

			// Scroll to top first (optional, to ensure starting from top)
			((JavascriptExecutor)driver).executeScript("window.scrollTo(0, 0);");
			
		}
		
		
		public void scrollDownGradually() {}
		
		
		public void scrollUpGradually() {}
}
