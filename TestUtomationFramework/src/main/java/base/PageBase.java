package base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;

import utilities.WaitUtils;

public class PageBase {


	protected WebDriver driver;
	Actions action;
	JavascriptExecutor js;

	public PageBase(WebDriver driver) {

		this.driver = driver;

	}



	//set some reusable methods


	//find single web element method
	public WebElement getWebElement(By element) {

		return driver.findElement(element);

	}


	//find a list of web elements
	public List<WebElement> getWebElementList(By list) {

		return driver.findElements(list);

	}



	//click method
	public void clickOnButton(By button) {

		getWebElement(button).click();

	}


	//write a text method
	public void setText(By field , String text) {

		getWebElement(field).sendKeys(text);

	}




	//select an element from dropdown list
	public void selectItem(WebElement list , String selectionTypes , String value) {

		Select select = new Select(list);



		switch(selectionTypes.toLowerCase()) {

		case "value":

			select.selectByValue(value);
			break;


		case "text":

			select.selectByVisibleText(value);
			break;


		case "index":

			select.selectByIndex(Integer.parseInt(value));
			break;

		default:

			throw new IllegalArgumentException("Invalid selection type: " + selectionTypes);

		}

	}



	//wait method
	public void waitForElement(Duration time , ExpectedCondition<?> condition) {

		WaitUtils.waitExciplicitly(driver, time, condition);

	}


	//hover on element
	public void hoverOnElement(WebElement element) {

		action = new Actions(driver);

		action.moveToElement(element).perform();

	}


	//clear a field
	public void clearField(By field) {

		driver.findElement(field).clear();

	}



	//click using java script method
	public void clickUsingJS(WebElement element) {

	//	js = (JavascriptExecutor) driver;

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

	}













}