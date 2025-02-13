package test.java;


import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterationPage;
import pageObjects.HomePage;
import testBase.BaseClass;



public class tc001_AccountRegisterationTest extends BaseClass {
	
   @Test
   public  void verify_account_registeration() throws InterruptedException {
	   
	   try {
	   logger.info("****** Starting tc001_AccountRegisterationTest *** ");
	   
	   HomePage hopg= new HomePage(driver);
	   Thread.sleep(10000);
	   logger.info("****** clicking MyAccount *** ");
	   hopg.clickMyAccount();
	   Thread.sleep(10000);
	   hopg.clickMyAccount();
	   logger.info("****** clicking Register link *** ");
	   hopg.clickRegister();
	   
	   AccountRegisterationPage accrg= new  AccountRegisterationPage(driver);
	   
	   
	   logger.info("****** Providing Customer Details *** ");
	   accrg.inputFname(randomString().toUpperCase());
	   accrg.inputLname(randomString().toUpperCase());
	   accrg.inputEmail(randomString()+"@yopmail.com");
	   String pass=randomAlphanumeric();
	   accrg.setPassword(pass);
	   Thread.sleep(2000);
	   accrg.clickSubscribe();
	   Thread.sleep(2000);
	   accrg.clickprivacypolicy();
	   Thread.sleep(2000);
	   accrg.clickcontinue();
	   Thread.sleep(2000);
	   
	   
	   logger.info("****** Validated expected message *** ");
	   String confirmmsg=accrg.getConfirmationMsg();
	   if(confirmmsg.equals("Your Account Has Been Created!")) {
		   Assert.assertTrue(true);
	   }
	   else {
		   logger.error("Test Failed...");
		   logger.debug("Debug logs...");
		   Assert.assertTrue(false);
	   }
	   
	   }
	   catch(Exception e) {
		  
		   Assert.fail();
	   }
	   
	   logger.info("******Test case executed *** ");
		
	}
   
  
    

}
