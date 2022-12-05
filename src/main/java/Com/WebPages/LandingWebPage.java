package Com.WebPages;






import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import ReusableMethodPackage.ReusableMethods;

public class LandingWebPage extends ReusableMethods{

WebDriver driver;
	public LandingWebPage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

@FindBy(xpath="//li/a[text()=\"Log in\"]") WebElement ClickLoginButtonWe;
@FindBy(xpath="//input[@type=\"number\"]") WebElement LoginWithWe;

@FindBy(xpath="//span[text()=\"Send One Time Password\"]") WebElement sendpswdWe;
@FindBy(xpath="//span[text()=\"Next\"]")  WebElement NextWe;
@FindBy(xpath="//input[starts-with(@placeholder,\"Ywca\")]") WebElement setLocationWe;
@FindBy(xpath="//div[@class=\"sc-imapFV gZAjRp\"]") WebElement searchLocation;
@FindBy(xpath="//input[contains(@placeholder,\"Search for restaurant, cuisine or a dish\")]") WebElement SearchWe;
@FindBy(xpath="//div/p[text()=\"Biryani - Delivery\"]") List<WebElement> selectdineTypeWe;
public LoginwebPage ClickLoginButton () {
	
	Actions a=new Actions(driver);
	a.moveToElement(ClickLoginButtonWe).click().build().perform();

	return new LoginwebPage(driver);
	
	
	
}


public SearchresultPage SearchFood(String Food) throws InterruptedException {
	
	SearchWe.click();	
	SearchWe.sendKeys(Food);

Thread.sleep(2000);
	Stream<WebElement> w1=selectdineTypeWe.stream().filter(s->s.getText().equalsIgnoreCase("Biryani - Delivery"));
	List<WebElement> l1=w1.collect(Collectors.toList());
	System.out.println(l1.get(0));
WebElement w2=	(WebElement) l1.get(0);
Wait<WebDriver> fWait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
fWait.until(new Function<WebDriver,WebElement>(){
public WebElement apply(WebDriver driver){
return w2;
}

})
;
w2.click();

	return new SearchresultPage(driver);
}

public void setLocation() throws InterruptedException {
	Thread.sleep(5000);
	setLocationWe.click();
	Webdriverwait(driver,10,SearchWe);
	searchLocation.click();
	Webdriverwait(driver,10,SearchWe);
	
}



	

}
