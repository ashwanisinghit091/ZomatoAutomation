package Com.WebPages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableMethodPackage.ReusableMethods;

public class SearchresultPage extends ReusableMethods{

	
	
	
	JavascriptExecutor js;
	
	SelectedFoodWebPage selectedFoodWebPage;
	

WebDriver driver;
	public SearchresultPage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//h4[text()=\"Biryani Badshah\"]") WebElement searchResultsWe;
	@FindBy(xpath="//h4") List<WebElement> SelectSpecific_restro;
	
	
	public SelectedFoodWebPage searchresults() {
		for(int i=0;i<10;i++) {
		// js=(JavascriptExecutor)driver;
		//	js.executeScript("window.scrollBy(0,80)");
			javaScript(driver);
		if(searchResultsWe.isDisplayed()) {
		searchResultsWe.click();
		
		break;
		}

		}
		return new SelectedFoodWebPage(driver);
	}

	public SelectedFoodWebPage SelectSpecific_restro_from_searchresults(String Restro_Name) {
		for(int i=0;i<100;i++) {
		// js=(JavascriptExecutor)driver;
		//	js.executeScript("window.scrollBy(0,80)");
			javaScript(driver);
		if(SelectSpecific_restro.get(i).getText().equalsIgnoreCase(Restro_Name)) {
			SelectSpecific_restro.get(i).click();
		
		break;
		}

		}
		return new SelectedFoodWebPage(driver);
	}
	
}
