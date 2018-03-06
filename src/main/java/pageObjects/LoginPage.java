package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver){
		
		this.driver = driver;
	}
	
	
	By username = By.id("email");
	By password = By.id("password");
	By SignInButton = By.xpath("//*[@id='signInForm']/div[5]/button");

	public WebElement username(){
		
		return driver.findElement(username);
	}
	
	public WebElement password(){
		
		return driver.findElement(password);
	}
	
	public WebElement SignInButton(){
		
		return driver.findElement(SignInButton);
	}
}


