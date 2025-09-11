package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import configSetup.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.WaitUtils;


public class TestBase {


	protected static WebDriver driver;
	int time = 0;
	String endPoint = ConfigReader.getConfigData("URL");
	String browserName = ConfigReader.getConfigData("browserName"); 


	public WebDriver getDriver() {

		return driver;

	}


	//launch the required browser & open the end point
	@BeforeMethod
	public void OpenBrowser() {


		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;


		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;


		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;


		case "safari":
			driver = new SafariDriver(); // no WebDriverManager needed
			break;



		default:
			throw new IllegalArgumentException("Unsupported browser: " + browserName);

		}


		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));

		driver.get(endPoint);


		//	WaitUtils.waitExplicily(driver, Duration.ofSeconds(time),
		//		condition	);

	}



	//close the browser
	@AfterMethod
	public void closeBrowser() {

		if(driver != null) {

			driver.quit();

		}else {

			System.out.println("Most probably Driver is null");

		}
	}
}
