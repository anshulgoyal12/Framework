package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver){
		
		this.driver = driver;
	}
	
	
	By signIn = By.xpath(".//*[@id='topmenu-nav']/ul/li[3]/a");
	
	By signInAsBuyer = By.xpath(".//*[@id='topmenu-nav']/ul/li[3]/ul/li[1]/a");
	
	By title = By.cssSelector("div[class='solution-block']>div>div[class='title']");
	
	By elementspresent = By.cssSelector(".nav-block.customer-service");
	
	public WebElement signIn(){
		
		return driver.findElement(signIn);
	}
	
	public WebElement signInAsBuyer(){
		
		return driver.findElement(signInAsBuyer);
	}
	
	public WebElement title(){
		
		return driver.findElement(title);
	}
	
	public WebElement elementspresent(){
		
		return driver.findElement(elementspresent);
	}
}


