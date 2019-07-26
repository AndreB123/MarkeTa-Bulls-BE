package selenium;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {

	public static WebDriver driver;
	public final String URL = "http://localhost:4200/login";
	public String username;
	public String password;
	public String balance;

	/*
	 * Setting up the test suite and adding in driver in order to start testing. 
	 */
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.get(URL);
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

	/*
	 * A test to confirm the homepage. 
	 */
	@Test
	public void confirmHomePage() {
		LoginHome lh = new LoginHome(driver);
		assertEquals(driver.getTitle(), lh.title);
	}
	
	
////	@Test(dependsOnMethods = { "confirmHomePage" })
////	public void log() {	
////		LoginHome lh = new LoginHome(driver);
////		assertEquals(driver.getTitle(), lh.username);
////		assertEquals(driver.getTitle(), lh.password);
////		
////	}
////
//////	/*
//////	 * Test to confirm log in success once the home page is confirmed. 
//////	 */
////	@Test(dependsOnMethods = { "confirmHomePage" })
////	public void login() {
////		LoginHome lh = new LoginHome(driver);
////		WebDriverWait wait = new WebDriverWait(driver, 7);
////		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
////		FluentWait<WebDriver> fwait = null;
////		WebElement username = (WebElement) fwait;
////		until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
////		/*
////		 * Handling alerts with Selenium
////		 */
////		if (ExpectedConditions.alertIsPresent().apply(driver) != null) {
////			driver.switchTo().alert().dismiss();
////		}
////
////		lh.login("bobbert", "bobbert");
////
////	}
////
////private void until(ExpectedCondition<WebElement> visibilityOfElementLocated) {
////	// TODO Auto-generated method stub
////	
//}
}
