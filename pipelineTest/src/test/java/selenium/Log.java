package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * This is being used to test log in. Other tests were failing(they are commented out in
 * LoginTest class) so tried new approach.  
 */
public class Log {
	
	    public static void main(String[] args) throws InterruptedException, NoSuchElementException {

	        String URL = "http://localhost:4200/login";
	        String username = "username";
	        String password = "password";

	        WebDriver driver;
	    	System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        //Goes to SellerCloud website
	        driver.get(URL);
	        WebDriverWait wait;
	        wait = new WebDriverWait(driver, 20);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

	        driver.findElement(By.id("login_username")).sendKeys(username);
	        driver.findElement(By.id("login_password")).sendKeys(password);
	        driver.findElement(By.xpath(".//*[@id='login']/a")).click();



	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='nav']/div/div[1]/div/div[4]/div/a/div[1]")));
	      



	    }
	}


