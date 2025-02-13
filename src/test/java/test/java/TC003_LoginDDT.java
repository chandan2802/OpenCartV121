package test.java;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	
	
	@Test(dataProvider="LoginDatafunc",dataProviderClass=DataProviders.class) //getting data provider from different class
   public void verify_login_DDT(String email, String p, String expresult) throws InterruptedException {
		
		try {
		//HomePage
		logger.info("starting TC003_LoginDDT test");
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
		lpg.provideEmail(email);
		Thread.sleep(2000);
		logger.info("providing pass");
		lpg.setPass(p);
		Thread.sleep(2000);
		logger.info("logging in");
		lpg.clickLogin();
		
		//MyAccount
		MyAccount myacc= new MyAccount(driver);
		boolean target=myacc.isMyAccountPageExists();
		
		if(expresult.equalsIgnoreCase("valid")) {
			if(target==true) {
				pg.clickMyAccount();
				myacc.clickLogout();
				Assert.assertTrue(true);

			}
			
			else {
				Assert.assertTrue(false);
			}
		}
		
		if(expresult.equalsIgnoreCase("Invalid")) {
			if(target==true) {
				pg.clickMyAccount();
				myacc.clickLogout();
				Assert.assertTrue(false);

			}
			
			else {
				Assert.assertTrue(true);
			}
			
		}
		
		

}
catch(Exception e) {
	Assert.fail();
}
   }
}
