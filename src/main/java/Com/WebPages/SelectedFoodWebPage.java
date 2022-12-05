package Com.WebPages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableMethodPackage.ReusableMethods;




public class SelectedFoodWebPage extends ReusableMethods{
	
	
	
	WebDriver driver;
	
	
	SelectedFoodWebPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
@FindBy(xpath="//label[text()=\"veg only\"]") WebElement VegOnlyOptionWe;
@FindBy(xpath="//label[text()=\"contains egg\"]") WebElement ContainsEggsWe;

public void VegOnlyOption() throws IOException {
	Webdriverwait(driver,20,VegOnlyOptionWe);
	javaScript(driver);
	ScreenShotElement(VegOnlyOptionWe,"VegOnlyOption");
	VegOnlyOptionWe.click();
	
	
}
public void ContainsEggs() {
	ContainsEggsWe.click();
	
	
}



}
