package selenium;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class LoginTest {
	
	public static WebDriver driver;
	public final String URL="http://localhost:4200/login";
	
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
	
	@Test
	public void confirmHomePage() {
		LoginHome lh = new LoginHome(driver);
		assertEquals(driver.getTitle(), lh.title);
	}
	
	


}
