package test.java;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;

public class TC002_loginTest extends BaseClass {
	
	@Test
	public void verify_login() throws InterruptedException {
		
		try {
		//HomePage
		logger.info("starting logging test");
		HomePage pg=new HomePage(driver);
		
		
		Thread.sleep(10000);
		pg.clickMyAccount();
		
		
		logger.info("clicking my Account");
		Thread.sleep(10000);
		pg.clickMyAccount();
		Thread.sleep(2000);
		pg.clickLogin();
		Thread.sleep(2000);
		
		
		//login
		LoginPage lpg=new LoginPage(driver);
		logger.info("providing email");
		lpg.provideEmail("bibhu2802@gmail.com");
		Thread.sleep(2000);
		logger.info("providing pass");
		lpg.setPass("Test@1234");
		Thread.sleep(2000);
		logger.info("logging in");
		lpg.clickLogin();
		
		//MyAccount
		MyAccount myacc= new MyAccount(driver);
		boolean target=myacc.isMyAccountPageExists();
		Assert.assertEquals(target, true,"Login Failed");
		logger.info("Finishing logging test");
		}
		catch(Exception e) {
			System.out.println("jfjn");
		}
	}

}
