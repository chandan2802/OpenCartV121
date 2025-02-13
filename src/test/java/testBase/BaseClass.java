package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {
	
 public WebDriver driver;
 public Logger logger;
 public Properties p;
	  
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException {
		
		logger=LogManager.getLogger(this.getClass());
		FileReader file= new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
				
		switch(br.toLowerCase()) {
		case "chrome":driver= new ChromeDriver(); break;
		case "edge":driver= new EdgeDriver(); break;
		case "firefox":driver= new FirefoxDriver(); break;
		default: System.out.println("Invalid browser");return;
		}
		
		driver.get(p.getProperty("appURL1")); //reading url from properties file
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	
	
	@AfterClass
   public  void tearDown() {
		driver.close();
	}
	
	 public String randomString() {
		   
		   String generatedString=RandomStringUtils.randomAlphabetic(5);
		   return generatedString;
		   
	   }
	   
	  public String randomAlphanumeric() {
		  
		  
		  
		  String generatedString=RandomStringUtils.randomAlphabetic(10);
		  String generatednumber=RandomStringUtils.randomNumeric(3);
		  return (generatedString+'@'+generatednumber);
		   
	   } 
	    

}
