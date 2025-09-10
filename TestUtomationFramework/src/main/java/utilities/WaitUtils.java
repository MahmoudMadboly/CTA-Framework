package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	
	//use explicit wait using a specific conditions
	public static void waitExciplicitly(WebDriver driver , Duration time , ExpectedCondition<?> condition) {
		
	 new WebDriverWait(driver, time).until(condition);
		
	}
	
	
	
	//use fluent wait using a specific condition & pulling during specific time
	public static void waitFluently() {
		
		
		
	}
}