package Selenium;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.LandingPage;

public class ValidateTest extends Base{
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void navigateURL() throws IOException{
	
		log.debug("Navigating the URL");
		driver.navigate().to("https://beta.vendorsdepot.com/");
		log.info("URL is successfully displayed");

	}

	@Test(priority=3)
	public void validateElementTest() throws IOException{
		
		LandingPage l = new LandingPage(driver);
		
		Assert.assertTrue(l.elementspresent().isDisplayed());
		System.out.println(l.elementspresent().getText());
		log.info("Validate the test");
		
		}
	
}


