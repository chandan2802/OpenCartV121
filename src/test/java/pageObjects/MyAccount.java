package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class MyAccount extends BasePage {

	@FindBy(xpath="//h2[text()=\"My Account\"]")
	WebElement heading;
	
	@FindBy(xpath="//div[@class=\"dropdown\"]//a[text()=\"Logout\"]")
	WebElement logoutlnk;
	
	public MyAccount(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void clickLogout() {
		
		logoutlnk.click();
	}
	
	

	public boolean isMyAccountPageExists() {
		try {
			return(heading.isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
	}
}
