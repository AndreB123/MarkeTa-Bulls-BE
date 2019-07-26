package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginHome {
	public String title = "MarkeTa-Bulls";
	
	@FindBy(how= How.NAME, using ="username")	
	public WebElement username;	
	@FindBy(name="password")
	public WebElement password;
	@FindBy(name="login")
	public WebElement login;	
	@FindBy(xpath="//a[text()='Home']")
	public WebElement homeLink;
	@FindBy(xpath="//a[text()='SIGN OFF']")
	public WebElement signoff;
	
	public LoginHome(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void login(String username, String password) {
		this.username.sendKeys(username); //simulates typing
		this.password.sendKeys(password);
		this.login.click();
		
	}

	

}
