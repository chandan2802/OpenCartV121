package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterationPage extends BasePage{

	public AccountRegisterationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@name=\"firstname\"]")
	WebElement txtFname;
	
	@FindBy(xpath="//input[@name=\"lastname\"]")
	WebElement txtlname;
	
	@FindBy(xpath="//input[@name=\"email\"]")
	WebElement email;
	
	@FindBy(xpath="//input[@name=\"password\"]")
	WebElement password;
	
	@FindBy(xpath="//input[@id=\"input-newsletter\"]")
	WebElement clkSubscribe;
	
	@FindBy(xpath="//div[@class=\"text-end\"]//input[@class=\"form-check-input\"]")
	WebElement clkPrivacyPolicy;
	
	@FindBy(xpath="//button[text()=\"Continue\"]")
	WebElement clkcontinue;
	
	@FindBy(tagName="h1")
	WebElement msgConfirmation;
	
	@FindBy(xpath="//b[text()=\"Privacy Policy\"]/parent::a")
	WebElement privacypolicylnk;
	
	@FindBy(xpath="//button[@class=\"btn-close\"]")
	WebElement close;
	
	public void inputFname(String fname) {
		txtFname.sendKeys(fname);
	}
	
	public void inputLname(String lname) {
		txtlname.sendKeys(lname);
	}
	
	public void inputEmail(String Email) {
		email.sendKeys(Email);
	}
	
	public void setPassword(String p) {
		password.sendKeys(p);
	}
	public void clickSubscribe() {
		
		
		WebElement element = clkSubscribe;
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}
	
	public void clickprivacypolicy() throws InterruptedException {
		
		
        WebElement element = clkPrivacyPolicy;
        
		
		
		privacypolicylnk.click();
		Thread.sleep(2000);
		close.click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);  
		
		
	}
	
	public void clickcontinue() {
		clkcontinue.click();
	}
	
	public String getConfirmationMsg() {
		
		try {
			return (msgConfirmation.getText());
		}
		catch(Exception e){
			return (e.getMessage());
		}
		
		
	}

}
