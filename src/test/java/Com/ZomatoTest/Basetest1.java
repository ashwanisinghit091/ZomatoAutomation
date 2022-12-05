package Com.ZomatoTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;





public class Basetest1  {
	public WebDriver driver;
	Properties p;
	
	public  WebDriver invokeBrowser() throws IOException {
		
		FileInputStream fs=new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\main\\java\\Com\\utilityPackage\\Config.properties"));
	p=new Properties();
		p.load(fs);
		
		String BrowserName=System.getProperty("Browser")!=null?System.getProperty("Browser"):p.getProperty("Browser");
		
	
		
		if(BrowserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Resources\\chromedriver1.exe");
	    driver=new ChromeDriver();
	    driver= hitURL();}
		
		
		if(BrowserName.equalsIgnoreCase("EdgeDriver")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\Resources\\msedgedriver.exe");
		    driver=new EdgeDriver();
		    driver= hitURL();}
		
		if(BrowserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.geckodriver.driver", System.getProperty("user.dir")+"\\Resources\\geckodriver.exe");
		    driver=new FirefoxDriver();
		   driver= hitURL();}
		return driver;
		
		
		
	}

	
	public WebDriver  hitURL() {
		driver.get(p.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	return driver;
		
	}
	
	
	
}
