package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css="input[name=\"email\"]")
	WebElement emailfield;
	
	@FindBy(css="input[name=\"password\"]")
	WebElement password;
	
	@FindBy(xpath="//button[text()=\"Login\"]")
	WebElement loginbutton;
	
	public void provideEmail(String email) {
		emailfield.sendKeys(email);
	}
	
	public void setPass(String p) {
		password.sendKeys(p);
	}
	
	public void clickLogin() {
		loginbutton.click();
	}
	
	

}
