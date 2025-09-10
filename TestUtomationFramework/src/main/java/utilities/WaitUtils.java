package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	
	
	public static void waitExciplicitly(WebDriver driver , Duration time , ExpectedCondition<?> condition) {
		
	 new WebDriverWait(driver, time).until(condition);
		
	}
}