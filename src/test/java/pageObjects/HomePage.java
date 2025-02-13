package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath="//span[text()=\"My Account\"]")
	WebElement linkMyAccount;
	
	@FindBy(xpath="//div[@class=\"dropdown\"]//a[text()=\"Register\"]")
	WebElement linkRegister;
	
	@FindBy(linkText="Login")
	WebElement login;

public void clickMyAccount() {
	linkMyAccount.click();
}

public void clickRegister() {
	linkRegister.click();
}

public void clickLogin() {
	login.click();
}

}
