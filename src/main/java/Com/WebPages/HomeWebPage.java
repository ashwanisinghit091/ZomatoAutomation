package Com.WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableMethodPackage.ReusableMethods;




public class HomeWebPage extends ReusableMethods {

	
	
	
	
	
	
	
	
	
	
	
	WebDriver driver;
	
	
	
public HomeWebPage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

@FindBy(xpath="//input[contains(@placeholder,\"Search for restaurant, cuisine or a dish\")]") WebElement SearchWe;

public void SearchFood() {
	Webdriverwait(driver,30,SearchWe);
	SearchWe.click();	
	SearchWe.sendKeys("Biryani");
	
}

}
