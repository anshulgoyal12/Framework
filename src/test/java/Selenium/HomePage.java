package Selenium;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomePage extends Base {
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	
	

		@Test(priority=1)
		public void basePageNavigation() throws IOException{
		
		LandingPage l = new LandingPage(driver);
		
		Assert.assertEquals(l.title().getText(),"ONE STOP SHOP SOLUTION");
		System.out.println(l.title().getText());
		log.debug("Clicking on Sign in link");
		l.signIn().click();
		log.debug("Clicking on Sign in as Buyer link ");
		l.signInAsBuyer().click();
		log.info("Open the Login Page Successfully");
		
	}
	
		@Test(dataProvider="getData",priority=2)
		public void loginPage(String username, String Password) throws InterruptedException{
			
		LoginPage lp = new LoginPage(driver);
		log.debug("Enter Username and Password");
		lp.username().sendKeys(username);
		lp.password().sendKeys(Password);
		lp.SignInButton().click();
		log.info("User is successfully login into the Application");
		Thread.sleep(2000);
		}
	
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] data = new Object[2][2];
		
		data[0][0] = "JonMark";
		data[0][1] = "indianic";
							
	    data[1][0] = "KenWilliamson";
		data[1][1] = "indianic";
		
		return data;
		
	}
	
}
