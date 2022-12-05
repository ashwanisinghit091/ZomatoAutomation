package Com.WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableMethodPackage.ReusableMethods;

public class LoginwebPage extends ReusableMethods{

	
	
	
	
	
	
	
	
	
	
	
	
	

WebDriver driver;
	public LoginwebPage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	
	
	@FindBy(xpath="//input[@type=\"number\"]") WebElement LoginWithWe;

	@FindBy(xpath="//span[text()=\"Send One Time Password\"]") WebElement sendpswdWe;
	
	
	
	
	
	
	
	public HomeWebPage LoginWithOTP () {
		Frames("auth-login-ui",driver);
		System.out.println("switched to frame");

		LoginWithWe.sendKeys("8368671756");
		sendpswdWe.click();
		return  new HomeWebPage(driver);
	}
}
