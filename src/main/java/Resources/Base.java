package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Base {
	
	public static WebDriver driver;
	public Properties prop;
	
	public void initializeDriver() throws IOException{
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\indianic\\Framework\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.equals("Firefox")){
			
			driver = new FirefoxDriver();
			
			
		}else if(browserName.equals("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\indianic\\Desktop\\Selenium\\chromedriver_win32 (4)\\chromedriver.exe");
			driver = new ChromeDriver();
			
			
		}else if(browserName.equals("IE")){
			
			System.setProperty("webdriver.ie.driver", "C:\\Users\\indianic\\Desktop\\Selenium\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	
	}
	
	@BeforeSuite
	public void initialize() throws IOException{
		
		initializeDriver();
		driver.get(prop.getProperty("Url"));
		
		
	}
	
	@AfterSuite
	public void tearDown(){
		
		driver.quit();
	}
	
	public void screenshot(String result) throws IOException{
		
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C:\\Users\\indianic\\Framework\\Screenshot\\"+result+"screenshot.png"));
	}

}
